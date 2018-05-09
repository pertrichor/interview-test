package test.bluext.interview.singleton;

/**
 * Description：静态内部类懒汉模式
 *
 * @author : xutao
 *         Created_Date : 2018-05-08 17:07
 */
public class StaticLazySingleton {

    private StaticLazySingleton() {
    }

    private static class LazyLoader {
        private static final StaticLazySingleton STATIC_LAZY_SINGLETON = new StaticLazySingleton();
    }

    public static StaticLazySingleton getInstance() {
        return LazyLoader.STATIC_LAZY_SINGLETON;
    }

    public void say() {
        System.out.println("abc");
    }
}
