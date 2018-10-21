package hdzi.swordsman.java.cglib;

import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class _02_Enhancer {
    public String test() {
        return "hello world";
    }

    public int test2() {
        return 1;
    }

    public static void main(String[] args) {
        // new 一个增强类
        Enhancer enhancer = new Enhancer();
        // 动态设置其父类
        enhancer.setSuperclass(_02_Enhancer.class);
        /* 设置拦截器 */
        // 一个Filter对应一个callback（用相同的数组下标）
        enhancer.setCallbackFilter(method -> {
            if (method.getReturnType() == String.class) {
                return 0;
            }

            return 1;
        });
        // 用FixedValue修正所有函数返回值
        enhancer.setCallbacks(new Callback[]{(FixedValue) () -> "hello cglib", NoOp.INSTANCE});
        _02_Enhancer proxy = (_02_Enhancer) enhancer.create();

        System.out.println(proxy.test());
        System.out.println(proxy.test2());

        // 上述方法需要自己对应filter和callback，可以用ClassBackHelper完成统一管理
        main2();
    }

    private static void main2() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(_02_Enhancer.class);
        // 和普通的filter不同的是,CallbackHelper不是返回CallBack[]的下标，而是CallBack
        CallbackHelper callbackHelper = new CallbackHelper(_02_Enhancer.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getReturnType() == String.class) {
                    return (FixedValue) () -> "hello cglib";
                }

                return NoOp.INSTANCE;
            }
        };
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        _02_Enhancer proxy = (_02_Enhancer) enhancer.create();

        System.out.println(proxy.test());
        System.out.println(proxy.test2());
    }
}
