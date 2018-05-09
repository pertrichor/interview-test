package test.bluext.interview.singleton;

/**
 * Description：
 *
 * @author : xutao
 *         Created_Date : 2018-05-08 17:09
 */
public class Main {

    public static void main(String[] args) {
        int i = 100;
        while (i-- > 0) {
            new Thread(() -> {
//                StaticLazySingleton.getInstance().say();
                try {
                    Thread.currentThread().sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DoubleCheckLazySingleton.getInstance().say();
            }).start();
        }
    }

}
