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
        // new 一个普通bean
        _03_ImmutableBean bean = new _03_ImmutableBean();
        bean.setValue("tao");
        // 根据普通bean生成不可改变bean
        _03_ImmutableBean immutableBean = (_03_ImmutableBean) ImmutableBean.create(bean);

        System.out.println(immutableBean.getValue());
        // 不可改变bean调用set方法报错
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
