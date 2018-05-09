package test.bluext.interview;

/**
 * Description：
 *
 * @author : xutao
 *         Created_Date : 2018-04-18 10:20
 */
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
    final static int c = 114;
}

class Test {
    public static void main(String[] args) {
        System.out.println(StaticTest.c);
    }
}