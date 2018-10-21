package hdzi.swordsman.java.cglib;

import net.sf.cglib.beans.ImmutableBean;

public class _03_ImmutableBean {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        _03_ImmutableBean bean = new _03_ImmutableBean();
        bean.setValue("tao");

        _03_ImmutableBean immutableBean = (_03_ImmutableBean) ImmutableBean.create(bean);

        System.out.println(immutableBean.getValue());

        try {
            immutableBean.setValue("jin");
        } catch (IllegalStateException e) {
            System.out.println("ImmutableBean不能改变值");
        }

        // 通过被代理的bean修改
        bean.setValue("jin");

        System.out.println(immutableBean.getValue());
    }
}
