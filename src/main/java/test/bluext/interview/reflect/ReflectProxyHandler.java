package test.bluext.interview.reflect;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Description：动态代理类
 *
 * @author : xutao
 *         Created_Date : 2018-05-08 14:13
 */
@AllArgsConstructor
public class ReflectProxyHandler implements InvocationHandler {

    private Object proxyObj;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("启用动态代理");
        return method.invoke(proxyObj, args);
    }
}
