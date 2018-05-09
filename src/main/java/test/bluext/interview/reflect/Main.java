package test.bluext.interview.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Description：测试反射
 *
 * @author : xutao
 *         Created_Date : 2018-05-08 11:21
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class clazz = Class.forName("test.bluext.interview.reflect.ReflectClass");
//
//        // 类名
//        System.out.println("类名: " + clazz.getName());
//        System.out.println("短类名: " + clazz.getSimpleName());
//        System.out.println();
//
//        // 注解
//        Annotation[] annotations = clazz.getAnnotations();
//        System.out.println("注解名:");
//        for (Annotation annotation : annotations) {
//            System.out.println(annotation.annotationType().getName());
//        }
//        System.out.println();
//
//        // 公共属性
//        Field[] fields = clazz.getFields();
//        System.out.println("公共属性名:");
//        for (Field field : fields) {
//            System.out.println(field.getName());
//        }
//        System.out.println();
//
//        // 所有声明的属性
//        Field[] declaredFields = clazz.getDeclaredFields();
//        System.out.println("所有声明属性名:");
//        for (Field field : declaredFields) {
//            System.out.println(field.getName());
//        }
//        System.out.println();
//
//        // 所有声明的方法
//        Method[] methods = clazz.getDeclaredMethods();
//        System.out.println("所有声明方法名:");
//        for (Method method : methods) {
//            System.out.println(method.getName());
//        }
//        System.out.println();
//
//        AnnotatedType[] annotatedTypes = clazz.getAnnotatedInterfaces();
//        for (AnnotatedType annotatedType : annotatedTypes) {
//            System.out.println(annotatedType.getType().getTypeName());
//        }
//
//        System.out.println("desiredAssertionStatus : " + clazz.desiredAssertionStatus());
//        System.out.println();
//
//        Class[] classes = clazz.getClasses();
//        System.out.println("classes:");
//        for (Class clazzz : classes) {
//            System.out.println(clazzz.getName());
//        }
//        System.out.println();
//
//        System.out.println("clazz.getCanonicalName() : " + clazz.getCanonicalName());
//        System.out.println();
//
//        // 构造器构造实例
//        Constructor<ReflectClass> constructor = clazz.getConstructor();
//        ReflectClass reflectClass = constructor.newInstance();
//        System.out.println("构造器构造实例 : " + reflectClass);
//
//        Object object = clazz.newInstance();
//        System.out.println("直接构造实例 : " + (ReflectClass) object);
//        System.out.println();
//
//        // 通过反射越过泛型检查
//        List<String> list = new ArrayList<>();
//        list.add("str1");
//        list.add("str2");
////        list.add(100);// 编译报错 , 因为泛型在编译器限制了元素类型
//
//        Class listClass = list.getClass();
//        Method addMethod = listClass.getDeclaredMethod("add", Object.class);
//        addMethod.invoke(list, 100);
//        addMethod.invoke(list, true);
//
//        System.out.println(JSON.toJSONString(list));
//        System.out.println();
//
//        TypeVariable[] typeVariables = clazz.getTypeParameters();
//        for (TypeVariable typeVariable : typeVariables) {
//            System.out.println(typeVariable.getName());
//        }

        // 动态代理
        Interface proxy = (Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(), new Class[]{Interface.class, AnotherInterface.class}, new ReflectProxyHandler(Class.forName("test.bluext.interview.reflect.ReflectClass").newInstance()));
        System.out.println(proxy.proxyMethod("1"));
        AnotherInterface proxy2 = (AnotherInterface) proxy;
        System.out.println(proxy2.proxyMethod2("2"));
    }

}
