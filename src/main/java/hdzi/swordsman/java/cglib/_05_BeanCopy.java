package hdzi.swordsman.java.cglib;

import net.sf.cglib.beans.BeanCopier;

public class _05_BeanCopy {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        BeanCopier beanCopier = BeanCopier.create(_05_BeanCopy.class, _03_ImmutableBean.class, false);
        _05_BeanCopy bean = new _05_BeanCopy();
        bean.setValue("tao");
        _03_ImmutableBean beanOther = new _03_ImmutableBean();
        // copy属性
        beanCopier.copy(bean, beanOther, null);

        System.out.println(beanOther.getValue());
    }
}
