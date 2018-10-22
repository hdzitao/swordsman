package hdzi.swordsman.java.cglib;

import net.sf.cglib.reflect.MethodDelegate;

/**
 * Created by taojinhou on 2018/10/22.
 */
public class _10_MethodDelegate {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    interface GetValue {
        String getValue();
    }

    public static void main(String[] args) {
        _10_MethodDelegate bean = new _10_MethodDelegate();
        bean.setValue("tao");
        GetValue getValue = (GetValue) MethodDelegate.create(bean, "getValue", GetValue.class);

        System.out.println(getValue.getValue());
    }
}
