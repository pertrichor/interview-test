package test.bluext.interview.singleton;

/**
 * Description：饿汉模式
 * <p>
 * 饿汉式单例模式实现最简单 , 但是如果这个实例并未被使用 , 却同样需要为成员hungerSingleton分配内存空间并完成新对象的实例化 , 所以比较消耗内存空间.
 *
 * @author : xutao
 *         Created_Date : 2018-05-08 16:58
 */
public class HungerSingleton {

    private HungerSingleton() {
    }

    private static final HungerSingleton hungerSingleton = new HungerSingleton();

    public static HungerSingleton getInstance() {
        return hungerSingleton;
    }

}
