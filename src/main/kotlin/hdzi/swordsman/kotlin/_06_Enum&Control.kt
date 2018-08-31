package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/20.
 */

/**
 * 声明枚举
 */
enum class ThreePrimaryColor {
    RED, YELLOW, BLUE
}

/**
 * 带构造器的枚举
 */
enum class Color(val r: Int, val y: Int, val b: Int) {
    RED(255, 0, 0),
    YELLOW(0, 255, 0),
    BLUE(0, 0, 255);

    // 定义方法,注意上面有个 ;
    fun rgb() = (r * 256 + y) * 256 + b
}

/**
 * when(条件){
 *     条件值1 -> 执行语句1
 *     条件值2 -> 执行语句2
 *     条件值3 -> 执行语句3
 *     else -> 执行语句4
}
 */
// 用于枚举
fun displayColor(color: Color) =
    when (color) { // 不需要break,多个case用 , 分隔
        Color.RED -> "RED"
        Color.YELLOW -> "YELLOW"
        else -> "Don't display" // default 分支
    }

// 用于测试类型
fun displayType(e: Number) =
    when (e) {
        is Int -> "Int"
        is Long -> "Long"
        is Float -> "Float"
        else -> "ELSE"
    }

// 用于替换正常的if
fun replaceIf(i: Int) =
    when {
        i < 0 -> "(-inf, 0)"
        i < 10 -> "[0, 10)"
        i < 100 -> "[10, 100)"
        else -> "[100, +inf)"
    }

/**
 * for-in
 */
fun doFor(list: List<*>) {
    for (ele in list) {
        println(ele)
    }
    // 带索引
    for ((idx, ele) in list.withIndex()) {
        println("$idx is $ele")
    }
}

/**
 * while 同 Java
 */

/**
 * if 表达式:if 会返回{}内最后一个值
 */
fun tryIf(a: Int, b: Int) = if (a > b) {
    println("choose a")
    a
} else {
    println("choose b")
    b
}

/**
 * 标签
 */
fun labelFor() {
    // 标记for
    lit@ for (it in listOf(1, 2, 3, 4, 5)) {
        if (it == 3) break@lit // break到标记的for
        print(it)
    }
    print(" done with explicit label")
}

// lambda 中的return
// 在调用如each方法遍历时,只能使用return加标签的方式来退出循环
fun continueForEach() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // 功能似 continue
        print(it)
    }
    print(" done with explicit label")
}

fun breakForEach() {
    run lit@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@lit // 跳到foreach外层代码块中即退出了整个循环
            print(it)
        }
    }
    print(" done with explicit label")
}