package hdzi.swordsman.java;

/**
 * 实现多个接口时，重写同名方法
 */
public class _01_MoreInterfaceImpl {
    static interface Grandparent {
        default void say() {
            System.out.println("I'm grandparent.");
        }
    }

    static interface Parent {
        default void say() {
            System.out.println("I'm parent.");
        }
    }

    static class Child implements Parent, Grandparent {

        /**
         * 引用具体的interface默认实现
         */
        @Override
        public void say() {
            Parent.super.say();
            Grandparent.super.say();
        }
    }

    public static void main(String[] args) {
        Grandparent p = new Child();
        p.say();
    }


}
