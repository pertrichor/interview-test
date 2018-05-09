package test.bluext.interview.singleton;

/**
 * Description：双重检查懒汉模式
 *
 * @author : xutao
 *         Created_Date : 2018-05-08 17:02
 */
public class DoubleCheckLazySingleton {

    private DoubleCheckLazySingleton() {
    }

    //    private static volatile DoubleCheckLazySingleton doubleCheckLazySingleton;
    private static DoubleCheckLazySingleton doubleCheckLazySingleton;

    public static DoubleCheckLazySingleton getInstance() {
        if (doubleCheckLazySingleton == null) {
            synchronized (DoubleCheckLazySingleton.class) {
                if (doubleCheckLazySingleton == null) {
                    doubleCheckLazySingleton = new DoubleCheckLazySingleton();
                }
            }
        }

        return doubleCheckLazySingleton;
    }

    public void say() {
        System.out.println("DoubleCheckLazySingleton");
    }
}
