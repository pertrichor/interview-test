package test.bluext.interview.jdbc;

import java.sql.*;

/**
 * Description：jdbc测试
 *
 * @author : xutao
 *         Created_Date : 2018-05-03 16:06
 */
public class JDBCTest {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// jdbc4.0后可以省略 , DriverManager.getConnection()中完成了类加载 , 建议保留
            connection = DriverManager.getConnection("jdbc:mysql://10.138.61.54/ddq_reborn?useUnicode=true&characterEncoding=utf-8&useSSL=false", "JDev", "JDev");
            statement = connection.prepareStatement("select `name`,age from t_ddq_test");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                System.out.println(name + " - " + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
