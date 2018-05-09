package test.bluext.interview.singleton;

/**
 * Description：饿汉式
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
