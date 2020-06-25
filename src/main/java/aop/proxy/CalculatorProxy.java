package aop.proxy;

import aop.inter.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * 使用动态代理 代理Calculator对象
 * 调用日志功能
 * @Author WGL
 * @Date 2020/6/10 10:36
 * @Version 1.0
 */

public class CalculatorProxy {
    public static Calculator getProxy(final Calculator cal) {
        ClassLoader loader = cal.getClass().getClassLoader();
        Class<?>[] interfaces = cal.getClass().getInterfaces();
        // 方法执行器
        InvocationHandler h = new InvocationHandler() {
            /**
             * @Description
             * @Date  2020/6/10 10:45
             * @param proxy 代理对象，这是给jdk使用的，任何时候都不要使用
             * @param method  当前将要执行的目标对象的方法
             * @param args 这个方法调用的时外界传入的参数值
             * @return {@link Object}
             **/
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //利用反射执行目标方法
                // invoke(Object obj,args[] args) obj 调用方法的对象 ，args 方法的参数
                Object result = null;
                try {
                    // LogUtils.logStart();
                    result = method.invoke(cal, args);
                    // LogUtils.logReturning(method,result);
                } catch (Exception e) {
                    // LogUtils.logException(method, e);
                }finally {
                    // LogUtils.logEnd(method);
                }
                //返回值必须返回出去外界才能获取执行后的结果
                return result;
            }
        };
        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
        return (Calculator) proxy;

    }
}
