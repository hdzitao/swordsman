package hdzi.swordsman.java.cglib;

import net.sf.cglib.reflect.ConstructorDelegate;

/**
 * Created by taojinhou on 2018/10/22.
 */
public class _12_ConstructorDelegate {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public _12_ConstructorDelegate(String value) {
        this.value = value;
    }

    /**
     * 为了对构造函数进行代理，我们需要一个接口，这个接口只含有一个Object newInstance(…)方法，用来调用相应的构造函数
     */
    public interface BeanConstructorDelegate {
        Object newInstance(String value);
    }

    public static void main(String[] args) {
        BeanConstructorDelegate constructorDelegate = (BeanConstructorDelegate) ConstructorDelegate.create(
                _12_ConstructorDelegate.class, BeanConstructorDelegate.class);
        _12_ConstructorDelegate bean = (_12_ConstructorDelegate) constructorDelegate.newInstance("Hello world");
        System.out.println(bean.getValue());
    }
}
