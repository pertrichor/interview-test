package test.bluext.interview;

/**
 * Description：测试实例化过程
 *
 * @author : xutao
 *         Created_Date : 2018-04-18 10:27
 */
public class InstanceTest {

    public static class InnerClass {

        public InnerClass() {
            System.out.println("构造方法调用");
        }

        static {
            System.out.println("静态代码块调用");
        }

        {
            System.out.println("普通代码块调用");
        }

        public static void staticInvoke() {
            System.out.println("静态方法调用");
        }

        public void normalInvoke() {
            System.out.println("普通方法调用");
        }

        public static final int i = 5;

        public static int j = 6;

        public int k = 7;

    }

    public static void main(String[] args) {
        System.out.println(InnerClass.j);
    }
}
