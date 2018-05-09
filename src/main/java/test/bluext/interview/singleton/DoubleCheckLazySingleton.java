package test.bluext.interview.singleton;

/**
 * Description：双重检查懒汉模式<br/>
 * <p>
 * 语句1作用 , 是为提交效率 , 如果内部DoubleCheckLazySingleton实例已经完成构造 , 则没有必要去参加同步锁的争夺.<br/>
 * <p>
 * 语句2作用 , 是为并发安全性 , 确保每次只有一个线程能够执行实例的创建动作 , 但是只有这一个同步锁是不够的 , 还依赖语句3.<br/>
 * <p>
 * 语句3作用 , 同样为了并发安全性 , 假设线程1和线程2都通过了语句1的校验 , 线程1率先获得锁 , 完成了语句4后释放锁 , 线程2获得锁后 , 将再次执行语句4. 这破坏了单例的目的.<br/>
 * <p>
 * 语句4作用 , 完成实例的创建.<br/>
 * <p>
 * 语句5作用 , 同步锁释放 , 成员变量doubleCheckLazySingleton的值将被刷新到主内存 , 确保其他线程可见.<br/>
 * <p>
 * 语句6作用 , 假设有线程1线程2 , 线程1正在执行语句4 , 线程2正在执行语句1. 线程1执行时 , 由于虚拟机内部存在指令优化的动作 , 可能先在内存上开辟空间 , 然后将地址赋值给
 * doubleCheckLazySingleton变量 , 此时doubleCheckLazySingleton变量已经不为空. 此时如果线程2执行语句1 , 发现不为空 , 则立即返回doubleCheckLazySingleton. 而线程1
 * 实际上还未完成对象的创建 , 线程2返回的对象如果被使用 , 可能会引发报错. 添加volatile关键字后 , 根据happens-before原则 , volatile写一定发生在之后的volatile读之前 ,
 * 这确保了线程2执行语句1进行volatile读之前 , 线程1执行语句4进行volatile写一定已经完成并且对线程2可见. 从而确保线程2读到的非空的doubleCheckLazySingleton变量已经完成
 * 实例化动作.
 *
 * @author : xutao
 *         Created_Date : 2018-05-08 17:02
 */
public class DoubleCheckLazySingleton {

    private DoubleCheckLazySingleton() {
    }

    private static volatile DoubleCheckLazySingleton doubleCheckLazySingleton;// 6
//    private static DoubleCheckLazySingleton doubleCheckLazySingleton;

    public static DoubleCheckLazySingleton getInstance() {
        if (doubleCheckLazySingleton == null) {// 1
            synchronized (DoubleCheckLazySingleton.class) {// 2
                if (doubleCheckLazySingleton == null) {// 3
                    doubleCheckLazySingleton = new DoubleCheckLazySingleton();// 4
                }
            }// 5
        }

        return doubleCheckLazySingleton;
    }

}
