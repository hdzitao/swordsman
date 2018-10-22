package hdzi.swordsman.java.cglib;

import net.sf.cglib.reflect.MulticastDelegate;

/**
 * Created by taojinhou on 2018/10/22.
 */
public class _11_MulticastDelegate {
    public interface DelegatationProvider {
        void setValue(String value);
    }

    public static class SimpleMulticastBean implements DelegatationProvider {
        private String value;

        @Override
        public void setValue(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        // 多重代理的接口
        MulticastDelegate multicastDelegate = MulticastDelegate.create(DelegatationProvider.class);
        // 添加多重代理的目标
        SimpleMulticastBean first = new SimpleMulticastBean();
        SimpleMulticastBean second = new SimpleMulticastBean();
        multicastDelegate = multicastDelegate.add(first);
        multicastDelegate = multicastDelegate.add(second);

        DelegatationProvider provider = (DelegatationProvider) multicastDelegate;
        // setValue方法下发给所有被代理的目标
        provider.setValue("Hello world");

        System.out.println(first.getValue());
        System.out.println(second.getValue());
    }
}
