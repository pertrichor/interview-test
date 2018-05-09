package test.bluext.interview;

/**
 * Description：测试一个java文件多个class
 *
 * @author : xutao
 *         Created_Date : 2018-04-18 15:00
 */
public class MultiClassTest {

    public static void main(String[] args) {
        System.out.println(new PrivateClass().i);
        System.out.println(new PrivateClass() {
            public int i = 15;

            public String test(String name) {
                return name;
            }
        }.test("123"));
    }
}

class PrivateClass {
    public int i = 13;
}
