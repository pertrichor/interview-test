package test.bluext.interview.genericitywildcards;

public class Main {

    public static void main(String[] args) {
        // java7 编译失败 , 显示Apple实例无法装载到Fruit泛型中.
        // java8 编译/运行成功 , 显然java8对泛型有隐式的继承关系检查.
        Plate<Fruit> plate = new Plate<>(new Apple());
        plate.set(new Apple());
        plate.get();
    }

}
