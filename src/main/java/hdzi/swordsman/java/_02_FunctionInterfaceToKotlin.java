package hdzi.swordsman.java;


@FunctionalInterface //为了在kotlin能用lambda调用java函数式接口，必须需要此注解
public interface _02_FunctionInterfaceToKotlin {
    void aFun(_02_FunctionInterfaceToKotlin self);
}
