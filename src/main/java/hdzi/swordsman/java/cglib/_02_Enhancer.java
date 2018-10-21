package hdzi.swordsman.java.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.NoOp;

public class _02_Enhancer {
    public String test() {
        return "hello world";
    }

    public int test2() {
        return 1;
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(_02_Enhancer.class);
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
    }
}
