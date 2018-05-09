package test.bluext.interview;

/**
 * Description：测试内部类
 *
 * @author : xutao
 *         Created_Date : 2018-04-18 15:16
 */
public class InnerClassTest {

    public static String OUTER_STR = "OUTER_STR";

    public String outerPublicStr = "outerPublicStr";

    private String outerPrivateStr = "outerPrivateStr";

    class InnerClass {

        public void test() {
            System.out.println(InnerClassTest.OUTER_STR);
            System.out.println(outerPrivateStr);
        }

    }

    static class InnerStaticClass {
        public static String INNER_STATIC_CLASS_STR = "INNER_STATIC_CLASS_STR";

        private String innerStaticClassStr = "innerStaticClassStr";

        public void test() {
            System.out.println(OUTER_STR);
            System.out.println(innerStaticClassStr);
            System.out.println(INNER_STATIC_CLASS_STR);
        }
    }

    private int k = 100;

    public void test(final int j) {
        class LocalClass {
            public void test() {
                k = k + 1;
                System.out.println(j);
                System.out.println(k);
            }
        }

        new LocalClass().test();
    }

    public void test2() {
        class LocalClassC {
            private int i = 12;

            public int test() {
                System.out.println(i);
                return i;
            }
        }

        LocalClassC localClass = new LocalClassC();
        localClass.test();
    }

    public static void main(String[] args) {
//        InnerClassTest innerClassTest = new InnerClassTest();
//        InnerClass innerClass = innerClassTest.new InnerClass();
//        innerClass.test();
//
//        InnerStaticClass innerStaticClass = new InnerStaticClass();
//        innerStaticClass.test();

        new InnerClassTest().test(3);
    }
}
