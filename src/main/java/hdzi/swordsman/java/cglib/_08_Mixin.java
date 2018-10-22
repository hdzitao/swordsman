package hdzi.swordsman.java.cglib;

import net.sf.cglib.proxy.Mixin;

/**
 * Created by taojinhou on 2018/10/22.
 */
public class _08_Mixin {
    interface First {
        String first();
    }

    static class ClassFirst implements First {
        @Override
        public String first() {
            return "first";
        }
    }

    interface Second {
        String second();
    }

    static class ClassSecond implements Second {
        @Override
        public String second() {
            return "second";
        }
    }

    interface MixinInterface extends First, Second {

    }

    public static void main(String[] args) {
        MixinInterface mixin = (MixinInterface) Mixin.create(new Class[]{First.class, Second.class, MixinInterface.class},
                new Object[]{new ClassFirst(), new ClassSecond()});

        System.out.println(mixin.first());
        System.out.println(mixin.second());
    }


}
