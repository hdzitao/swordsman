package hdzi.swordsman.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 需要代理的接口
 */
interface ProxyInterface {
    String getName(String name);

}

/**
 * 代理类
 */
class ProxyClass implements InvocationHandler {

    private ProxyInterface proxyInterface;

    public ProxyClass(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before......");
        Object result = method.invoke(proxyInterface, args);
        System.out.println("proxy after......");
        return result;
    }
}

/**
 * Java动态代理
 */
public class _04_DynamicProxy {
    public static void main(String[] args) {
        /**
         * new一个ProxyInterface的实例，并把方法调用代理给ProxyClass的invoke方法
         */
        ProxyInterface instance = (ProxyInterface) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{ProxyInterface.class},
                new ProxyClass(name -> "name: " + name));
        String taojinhou = instance.getName("taojinhou");
        System.out.println(taojinhou);
    }
}
