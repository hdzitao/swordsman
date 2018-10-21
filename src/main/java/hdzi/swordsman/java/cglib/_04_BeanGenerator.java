package hdzi.swordsman.java.cglib;

import net.sf.cglib.beans.BeanGenerator;

import java.lang.reflect.Method;

public class _04_BeanGenerator {
    public static void main(String[] args) throws Exception {
        // new 一个bean生成类
        BeanGenerator beanGenerator = new BeanGenerator();
        // 设置动态属性
        beanGenerator.addProperty("value", String.class);
        // new 个实例
        Object o = beanGenerator.create();
        // 动态生成的实例方法只能用反射调用
        Method setValue = o.getClass().getMethod("setValue", String.class);
        setValue.invoke(o, "tao");
        System.out.println(o.getClass().getMethod("getValue").invoke(o));
    }
}
