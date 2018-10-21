package hdzi.swordsman.java.cglib;

import net.sf.cglib.beans.BeanGenerator;

import java.lang.reflect.Method;

public class _04_BeanGenerator {
    public static void main(String[] args) throws Exception {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value", String.class);

        Object o = beanGenerator.create();

        Method setValue = o.getClass().getMethod("setValue", String.class);
        setValue.invoke(o, "tao");

        System.out.println(o.getClass().getMethod("getValue").invoke(o));
    }
}
