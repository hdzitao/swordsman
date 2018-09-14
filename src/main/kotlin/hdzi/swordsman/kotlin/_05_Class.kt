package hdzi.swordsman.kotlin

import hdzi.swordsman.java._02_FunctionInterfaceToKotlin
import kotlin.reflect.KProperty

/**
 * Created by taojinhou on 2018/8/20.
 */

/**
 * 最简单的类
 */
class Simple

/**
 * 简单的对象:实现单例,匿名类等
 */
object obj

/**
 * 较完整的类定义
 * 如果主构造函数没有任何注解或者可⻅性修饰符，可以省略这个 constructor 关键字:
 * class Person(val name: String, var age: Int)
 */
class Person private constructor(val name: String, var age: Int) { // 主构造函数,自动定义属性和访问器
    init { // 初始化代码块1. 请注意，初始化块中的代码实际上会成为主构造函数的⼀部分
        println("init 1 ...")
    }

    constructor(name: String) : this(name, 1)
    constructor() : this("Hdzi") {// 次构造器,调用其他 能通到主构造函数 的其他构造函数
        println("Default constructor...")
    }

    val type: String = "Man" // 常量,自动定义访问器
    var local: String = "上海" // 变量,自动定义访问器

    // 自定义访问器
    val home: String
        get() = "浙江" // 自定义的getter
    var school: String = "春晖"
        set(school) { // 自定义setter
            println("转校......")
            field = school // field指向属性自己
        }

    init { // 初始化代码块2
        println("init 2 ...")
    }

    // lateinit 修饰的变量不需要初始化
    lateinit var subject: String

    // 伴生对象
    companion object
}

/**
 * 扩展函数和扩展属性
 *
 * + 扩展函数中可以正常使用类属性、方法和this
 * + 需要导入才能生效
 * + 扩展函数实际上是静态函数,接受者调整为第一个参数
 * + 静态函数之故,扩展函数不适用多态,具体调用由 声明的类型 而不是运行时类型决定.
 *   所以即使用父类指向子类,调用的也是父类的扩展函数,因为接受者是父类
 */
fun Person.showLocal() = println("name: $name, local: ${this.local}")

// 扩展半生对象
fun Person.Companion.ext() = println("Companion")

// 扩展属性由getter和setter代理,没有实际存储的地方
var Person.family: String
    get() = "Tao"
    set(value) = println("悲剧的setter") // 改变类中已有的字段

/**
 * new 一个实例
 */
val person = Person()

/**
 * 继承
 */

// kotlin的类默认是 final 的,不能继承,需要手工指定可继承: open
open class Base {
    open fun v() {} // 手工指定可重写
    fun nv() {} // 默认不可重新

    open val x = 1 // 可重写字段
}

interface IBase {
    val p: Int //抽象字段
    fun v() {}
}

/**
 * 基类构造函数执⾏时，派⽣类中声明或覆盖的属性都还没有初始化。
 * 如果在基类初始化逻辑中（直接或通过另⼀个覆盖的 open 成员的实现间接）
 * 使⽤了任何⼀个这种属性，那么都可能导致不正确的⾏为或运⾏时故障。
 * 设计⼀个基类时，应该避免在构造函数、属性初始化器以及 init 块中使⽤ open 成员
 */
// 继承时就要指定 父类构造函数
class Derived(override val p: Int) : Base(), IBase { // 主构造函数中也可以加 override
    // override关键字表示重写,默认open.注意如果父类函数提供了参数默认值,子类重写就不能有默认值
    /* final(不可再次重写) */ override fun v() {
        super<Base>.v() // 继承来多个同名方法,需要自实现,通过 super<Base> 访问相应父类方法
        super<IBase>.v()
    }

    // 重写父类字段(另注意,这里用var重写了val,反之是不行的,
    // 因为⼀个 val 属性本质上声明了⼀个 getter ⽅法，⽽将其覆盖为 var 只是在⼦类中额外声明⼀个 setter ⽅法)
    override var x = 2
}


/**
 * 接口 kotlin接口类似java
 */

/**
 * 数据类
 *
 * 自动生成:equals/hashcode/toString/componentN/copy
 */
data class User(val name: String, val age: Int)

/**
 * 数据类解构
 *
 * +解构依靠componentN函数
 *  val (name, age) = user 等于
 *  val name = user.component1()
 *  val age  = user.component2()
 * +componentN 函数需要 operator 限定
 * +不需要的字段用 _ 丢弃
 * +Pair类型在lambda中自动解构(方便在Map上调工具方法)
 */
fun getUserNameAge(user: User) {
    val (name, age) = user // 不支持global变量
}

/**
 * 密封类
 *
 * 只能在同文件内声明其子类
 */
sealed class Expr

data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

/**
 * 嵌套类和内部类
 */

class Out : Expr() {
    class Nesting // 嵌套类

    inner class Inner { // 内部类
        fun foo() {
            val out = this@Out // 引用外部类
            val outSuperToString = super@Out.toString() // 引用外部类父类
        }
    }
}

/**
 * 匿名类
 */
// 对象表达式
val out = object : Base() { // 可以不继承类,一个通用的object
    override fun v() {}
}

/**
 * 委托
 */
// 委托接口方法
object DelegationMethod {
    interface Base {
        val message: String
        fun print()
    }

    class BaseImpl(val x: Int) : Base {
        override val message = "BaseImpl: x = $x"
        override fun print() {
            println(message)
        }
    }

    // 委托语法：继承Base并有个Base对象，对Base方法的调用全部委托给Base对象
    class Derived(b: Base) : Base by b {
        // 请注意,以这种⽅式重写的成员不会在委托对象的成员中调⽤,委托对象的成员只能访问自己的实现
        // 在 b 的 `print` 实现中不会访问到这个属性
        override val message = "Message of Derived"
    }
}

// 委托属性
object DelegationField {
    class Delegate {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
            return "$thisRef, thank you for delegating '${property.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            println("$value has been assigned to '${property.name}' in $thisRef.")
        }
    }

    class Example {
        // setter/getter委托给setValue/getValue
        var p: String by Delegate()

        // 延迟加载委托
        val lazyValue: String by lazy {
            "lazy value"
        }

    }

}

/**
 * 操作符重载
 */
operator fun Person.plus(other: Any): Person { // +
    return this
}

/**
 * 成员函数引用
 */
fun useMemberFun(list: List<Person>): Person {
    return list.maxBy(Person::age)!!
}

// 引用Class构造函数
fun useConstruction(): Person {
    val p: () -> Person = ::Person // 多个构造函数需要声明类型
    return p()
}

// 实例方法引用
fun useInstanceFun(p: Person): String {
    val f = p::name
    return f()
}

/**
 * 调用java函数式接口
 */
fun callJavaFunctionInterface() {
    val functionInterface = _02_FunctionInterfaceToKotlin {
        // 实现Java接口
        print("it's done.")
    }

    functionInterface.aFun { println("it's called.") } //调用Java接口

}

/**
 * 用with简化代码
 * 和扩展函数类似
 */
fun alphabet() = with(StringBuilder()) {
    ('A'..'Z').forEach { append(it) } //直接调用方法
    toString() //返回最后语句的值
}

/**
 * 和with相似的apply
 * apply总是返回调用者
 */

fun alphabet2() = StringBuilder().apply {
    ('A'..'Z').forEach { append(it) } //直接调用方法
}.toString() // 返回调用者后 toString

/**
 * 可空类型
 */
fun ableNull(s: String?) { // 在类型后加 ? 表示变量可以为null
    // s.toUpperCase() 可控类型不能直接调用方法

    // 安全调用符:如果s为null返回null,所以su也是可空类型
    var su = s?.toUpperCase()

    // 用 ?: 来为可空类型提供默认值,sue不是可空类型
    var sue = s?.toUpperCase() ?: ""

    // 安全转换 as?
    var ss = s as? Any // 如果s能转换为Any就转换,不能就返回null

    // !! 非空断言
    var sss = s!!
}

// 用扩展函数来处理可空类型
fun String?.isNullOrBlank() = this == null || this.isBlank()
// 直接调用isNullOrBlank,不用 ?.
fun stringIsNullOrBlank(s: String?) = s.isNullOrBlank()

/**
 * 注意,泛型是可空的
 */
fun <T> printHashCode(t: T) {
    println(t?.hashCode()) // 要用安全调用符
}

/**
 * Java的@NotNull和@Nullable注解对应了kotlin基本类型和可空类型
 *
 * 平台类型 Any!
 * 对应Java中没有标注的参数,kotlin把他们当做平台类型,可以像基本类型一样调用方法,但一旦遇到null就抛异常(和Java一样)
 * Any! 类型只能在kotlin内部使用,不能用于声明,对于Java返回的类型,可以声明成 Any 或 Any? ,但如果是Any类型,一旦返回null
 * 立即抛异常
 */

/**
 * 使⽤类型检测及⾃动类型转换
 */
fun getLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length // is 检测后可以当String使用
    }

    when (obj) {
        is Array<*> -> obj.size
    }

    return null
}

/**
 * 强转符 as
 */
fun <T> asT(t: Any): T {
    return t as T
}

/**
 * 数字转换
 */
fun intInLongList() {
    val l = listOf(1L, 2L, 3L)
    val i : Int = 1
    println(i.toLong() in l) // 不匹配的类型不能比较,即使是Int和Long
}
