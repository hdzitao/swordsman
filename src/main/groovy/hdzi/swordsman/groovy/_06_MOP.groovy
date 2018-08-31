package hdzi.swordsman.groovy

/**
 * Created by taojinhou on 2018/8/23.
 */

/**
 * 拦截
 */
// 能修改源码
class MyClass implements GroovyInterceptable {
    @Override
    Object invokeMethod(String name, Object args) {
        // ......
        return metaClass.getMetaMethod(name, args)?.invoke(this, args)
    }
}
// 不能修改源码
MyClass.metaClass.invokeMethod = { String name, Object args ->
    //......
    return metaClass.getMetaMethod(name, args)?.invoke(delegate, args)
}

/**
 * 注入方法
 */
// use 块
class UseStringUtil {
    static def toSSN(String self) {
        return "1.ssn:$self"
    }
}
// use 块 语法2
@Category(String)
class UseStringUtil2 {
    def toSSN() { // 不需要 static 和 参数
        return "2.ssn:${this}" // this即指向掉方法的String对象
    }
}

use(UseStringUtil) {
    println "a".toSSN() // use类的静态方法被路由到代码块内的String对象上
}
use(UseStringUtil2) {
    println "a".toSSN()
}

// 往 metaClass 里添加方法
String.metaClass.toSSN = { ->
    return "3.ssn:${delegate}" // 要用 delegate !!!
}
println "a".toSSN()

def ssn = "a"
ssn.metaClass.toSSN = { ->
    return "4.ssn:${delegate}"
}
println ssn.toSSN()

// Mixin
class BeMixin {
    def toSSN() {
        return "5.ssn:${this}" // 这个this不是调用方法的this ==||
    }
}

class ToMixin {}

ToMixin.mixin(BeMixin) // 后注入的优先
println new ToMixin().toSSN()

/**
 * 方法合成
 */

// 用 methodMissing
