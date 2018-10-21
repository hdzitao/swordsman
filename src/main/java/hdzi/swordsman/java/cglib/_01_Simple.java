package hdzi.swordsman.java.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class _01_Simple {
    String getName(String name) {
        System.out.println("getName");
        return "name:" + name;

    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(_01_Simple.class);
        // 用MethodInterceptor拦截所有方法调用
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("brfore......");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after......");
            return result;
        });

        _01_Simple proxyClass = (_01_Simple) enhancer.create();
        System.out.println(proxyClass.getName("taojinhou"));
    }
}
