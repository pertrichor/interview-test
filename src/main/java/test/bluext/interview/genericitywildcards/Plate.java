package test.bluext.interview.genericitywildcards;

/**
 * 盘子
 */
public class Plate<T> {

    private T thing;

    public Plate(T thing) {
        this.thing = thing;
    }

    public void set(T t) {
        this.thing = t;
    }

    public T get() {
        return this.thing;
    }
}
