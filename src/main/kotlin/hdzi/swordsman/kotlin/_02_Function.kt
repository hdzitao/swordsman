package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/20.
 */

/**
 * 定义简短函数
 */
fun max(a: Int, b: Int): Int = if (a > b) a else b

/**
 * 定义函数(return不可省略)
 */
fun max_v2(a: Int, b: Int): Int {
    return if (a > b) a else b
}

/**
 * 定义有默认值的函数
 * 可选参数定义在实参前的话，只能用命名参数调用函数来绕过前面的可选参数
 * fun foo(opt: Int = 0, par: Int) ==> foo(par = 1)  //使⽤默认值opt=0
 */
fun large(i: Int, j: Int = 0) = i >= j

/**
 * 函数重载,这个定义和上面的函数有点冲突,但优先调用下面的函数(应该是下面的函数匹配度高)
 */
fun large(i: Int) = true

/**
 * lambda
 */
val inc: (Int) -> Int = { it + 1 } //单参数lambda可用it代替参数
val max_v3 = { a: Int, b: Int -> if (a > b) a else b }

/**
 * 命名参数
 */
fun nameParams() {
    max(b = 2, a = 1) // 特别注意这个语法在Java是完全不同的意思
}

/**
 * 可变参数
 */
fun sum(vararg i: Int): Int {
    return i.reduce(Int::plus)
}

fun varArg() {
    sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    sum(*arr)
}

/**
 * 中缀表示法
 *
 * +它们必须是成员函数或扩展函数；
 * +它们必须只有⼀个参数；
 * +其参数不得接受可变数量的参数且不能有默认值。
 */
infix fun Int.yes(i: Any) = this.hashCode() == i.hashCode()

fun useInfix() {
    val i = 1
    i yes 1
    i.yes(1)
}

/**
 * 局部函数
 */
fun addn(n: Int): (Int) -> Int {
    fun add(i: Int): Int = i + n // 函数内定义函数
    return ::add // 取函数对象
}

/**
 * 尾递归优化
 */
tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))