package test.bluext.interview.inter;

/**
 * 测试jdk8的默认接口实现
 */
public class Main {

    public static void main(String[] args){
        DefaultImplementTestInterface defaultImplementTestInterface = new DefaultInplementTestInterfaceImpl();
        System.out.println(defaultImplementTestInterface.functionB());
    }

}
