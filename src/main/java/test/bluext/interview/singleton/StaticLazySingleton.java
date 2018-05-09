package test.bluext.interview.singleton;

/**
 * Description：静态内部类懒汉模式
 * <p>
 * 《Effective java》推荐的懒汉模式实现方式.<br/>
 * 由于真正的实例存在于静态内部类中 , 仅在第一次访问时才会进行初始化 , 而final关键字可以确保指令不被重排序并且成员引用不被修改.<br/>
 * 因此 , 这种实现方式没有并发问题.
 * <p>
 * 这是效率最高且具备并发安全性的实现方式.
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

}
