package test.bluext.interview;

/**
 * Description：类加载中死循环测试
 *
 * @author : xutao
 *         Created_Date : 2018-04-18 9:50
 */
public class DeadLoopClassLoadTest {

    static class DeadLoop {
        static {
            if (true) {
                System.out.println("i am dead");
                while (true) {
                }
            }
        }
    }


    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            System.out.println("t1 start..");
//            DeadLoop obj = new DeadLoop();
//        });
//        Thread t2 = new Thread(() -> {
//            System.out.println("t2 start..");
//            DeadLoop obj = new DeadLoop();
//        });
//
//        t1.start();
//        t2.start();
    }
}
