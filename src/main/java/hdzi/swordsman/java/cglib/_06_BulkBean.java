package hdzi.swordsman.java.cglib;

import net.sf.cglib.beans.BulkBean;

import java.util.Arrays;

/**
 * Created by taojinhou on 2018/10/22.
 */
public class _06_BulkBean {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        BulkBean bulkBean = BulkBean.create(_06_BulkBean.class,
                new String[]{"getValue"},
                new String[]{"setValue"},
                new Class[]{String.class});
        _06_BulkBean bean = new _06_BulkBean();
        bean.setValue("Hello world");
        // get值
        Object[] propertyValues = bulkBean.getPropertyValues(bean);
        System.out.println(Arrays.toString(propertyValues));
        // set值
        bulkBean.setPropertyValues(bean, new Object[]{"Hello cglib"});
        System.out.println(bean.getValue());
    }
}
