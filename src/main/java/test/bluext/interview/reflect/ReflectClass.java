package test.bluext.interview.reflect;

import javax.annotation.Resource;

/**
 * Description：被反射的类
 *
 * @author : xutao
 *         Created_Date : 2018-05-08 11:14
 */
@Resource
public class ReflectClass<Object> implements Interface, AnotherInterface {

    static {
        System.out.println("ReflectClass开始初始化");
    }

    private String privateStr = "privateStr";

    private static String staticPrivateStr = "staticPrivateStr";

    public String publicStr = "publicStr";

    public static String staticPublicStr = "staticPublicStr";

    private String privateMethod(int arg) {
        return "privateMethod+" + arg;
    }

    public String publicMethod(int arg) {
        return "publicMethod+" + arg;
    }

    private static String privateStaticMethod(int arg) {
        return "privateStaticMethod+" + arg;
    }

    public static String publicStaticMethod(int arg) {
        return "publicStaticMethod+" + arg;
    }

    @Override
    public String proxyMethod(String name) {
        return "动态代理方法输出 : " + name;
    }

    @Override
    public String proxyMethod2(String name) {
        return "另一个动态代理方法输出 : " + name;
    }
}
