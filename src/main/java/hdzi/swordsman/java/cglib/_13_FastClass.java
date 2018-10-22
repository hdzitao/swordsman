package hdzi.swordsman.java.cglib;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by taojinhou on 2018/10/22.
 */
public class _13_FastClass {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 顾明思义，FastClass就是对Class对象进行特定的处理，
     * 比如通过数组保存method引用，因此FastClass引出了一个index下标的新概念，
     * 比如getIndex(String name, Class[] parameterTypes)就是以前的获取method的方法。
     * 通过数组存储method,constructor等class信息，从而将原先的反射调用，
     * 转化为class.index的直接调用，从而体现所谓的FastClass。
     *
     * @throws InvocationTargetException
     */
    public static void main(String[] args) throws InvocationTargetException {
        FastClass fastClass = FastClass.create(_13_FastClass.class);
        FastMethod fastMethod = fastClass.getMethod("getValue", new Class[0]);
        _13_FastClass bean = new _13_FastClass();
        bean.setValue("Hello world");
        System.out.println(fastMethod.invoke(bean, new Object[0]));
    }
}
