package hdzi.swordsman.java;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class _05_CGLIBProxy {
    static class ProxyClass {
        String getName(String name) {
            System.out.println("getName");
            return "name:" + name;
        }
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyClass.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("brfore......");
            Object result = methodProxy.invokeSuper(o, objects);
            System.out.println("after......");
            return result;
        });

        ProxyClass proxyClass = (ProxyClass) enhancer.create();
        System.out.println(proxyClass.getName("taojinhou"));
    }
}
