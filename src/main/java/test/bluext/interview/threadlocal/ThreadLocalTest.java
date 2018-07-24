package test.bluext.interview.threadlocal;

import lombok.Getter;
import lombok.Setter;

/**
 * Description：ThreadLocal类测试分析
 * <p>
 * ThreadLocal实现原理: 每个Thread内部维护了一个ThreadLocalMap , ThreadLocalMap是一个定义在ThreadLocal内部的静态内部类.
 * 当调用ThreadLocal的set或get方法时 , 首先调用Thread.currentThread()获取当前线程. 由于每个线程内部有独立的ThreadLocalMap实例.
 * 所以 , 相当于每个线程获得了一份独立的数据空间.<br/>
 * set(val): 将当前ThreadLocal实例的this作为键 , val作为值保存到当前线程的ThreadLocalMap中. 由于key是ThreadLocal的实例引用 , 使得每个不同的ThreadLocal实例下保存的数据对于线程本身是独立的.<br/>
 * get()和remove(): 获取/删除 当前线程内部ThreadLocalMap中的值.
 * <p>
 * 示例1. 因为不同线程维护的ThreadLocalMap实例中 , val为同一个对象(指向同一个内存地址) , 所以修改这个对象的成员将影响其他线程.<br/>
 * 示例2. 由于内部维护的是基本数据类型 , 直接修改值不会对其他线程产生影响.<br/>
 * 示例3. 由于使用ThreadLocal.withInitial(Person::new)创建ThreadLocal实例 , 当调用set(val)或get()时 , 都会调用内部的initialValue()方法 , 这个方法每次返回一个new Person() ,
 * 所以 , 修改person实例的成员不会影响其他线程.<br/>
 * <p>
 * PS: java中都是值传递. val的值即为对象的内存地址. 修改这个值意味着改变这个内存地址 , 而不是修改此内存中保存的数据.
 *
 * @author : xutao
 *         Created_Date : 2018-05-09 16:17
 */
public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {

        // 示例1. person对象中的属性值将被修改.
//        Person person = new Person();
//        Thread t1 = new PersonWorkThread(person);
//        Thread t2 = new PersonWorkThread(person);

        // 示例2. 直接修改值不会影响其他线程.
//        SequenceNum sequenceNum = new SequenceNum();
//        Thread t1 = new IntegerWorkThread(sequenceNum, 10);
//        Thread t2 = new IntegerWorkThread(sequenceNum, 100);

        // 示例3. 每个线程的person实例都是独立的 , 互不干扰.
        Thread t1 = new NewPersonWorkThread();
        Thread t2 = new NewPersonWorkThread();

        // -------------------------------------------

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

//        System.out.println("最后: " + person.getName());// 示例1
        System.out.println("最后: " + NewPersonThreadLocalHolder.threadLocal.get().getName());// 示例3
    }
}

// -- 示例1 ---------------------------------------------------------------------------------------------------------------------

class PersonThreadLocalHolder {
    public static ThreadLocal<Person> threadLocal = new ThreadLocal<>();
}

class PersonWorkThread extends Thread {

    private Person person;

    public PersonWorkThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        PersonThreadLocalHolder.threadLocal.set(person);
        PersonThreadLocalHolder.threadLocal.get().setName(Thread.currentThread().getName() + "的男人");
        System.out.println(Thread.currentThread().getName() + " - " + PersonThreadLocalHolder.threadLocal.get().getName());
    }

}

@Setter
@Getter
class Person {
    private String name;
}

// -- 示例2 ---------------------------------------------------------------------------------------------------------------------

class SequenceNum {
    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public int getNextNum() {
        threadLocal.set(threadLocal.get() + 1);
        return threadLocal.get();
    }
}

class IntegerWorkThread extends Thread {

    private SequenceNum sequenceNum;
    private int count;

    public IntegerWorkThread(SequenceNum sequenceNum, int count) {
        this.sequenceNum = sequenceNum;
        this.count = count;
    }

    @Override
    public void run() {
        int i = count;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " - " + sequenceNum.getNextNum());
        }
    }

}

// -- 示例3---------------------------------------------------------------------------------------------------------------------

class NewPersonThreadLocalHolder {
    public static ThreadLocal<Person> threadLocal = ThreadLocal.withInitial(Person::new);
}

class NewPersonWorkThread extends Thread {

    @Override
    public void run() {
        NewPersonThreadLocalHolder.threadLocal.get().setName(Thread.currentThread().getName() + "的女人");
        System.out.println(Thread.currentThread().getName() + " - " + NewPersonThreadLocalHolder.threadLocal.get().getName());
    }

}