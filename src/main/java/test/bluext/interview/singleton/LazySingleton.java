package test.bluext.interview.singleton;

/**
 * Description：懒汉式
 *
 * @author : xutao
 *         Created_Date : 2018-05-08 16:59
 */
public class LazySingleton {
    private LazySingleton() {
    }

    private static LazySingleton lazySingleton;

    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
