package test.bluext.interview.singleton;

/**
 * Description：懒汉模式
 * <p>
 * 最简单的懒汉模式实现方式 , 为解决并发问题 , 方法添加同步关键字. 但是这大大降低了并发性能.
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
