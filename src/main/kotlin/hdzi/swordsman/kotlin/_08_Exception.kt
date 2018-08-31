package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/20.
 */

/**
 *  kotlin异常和java的异常基本相同,最大的不同是kotlin的ce是不受检的
 */
// 抛出异常不用声明
fun throwException() {
    throw Exception()
}

// 接收异常不必检查
fun uncheckException() {
    throwException()
}

// 检查异常
fun checkException() {
    try {
        throwException()
    } catch (e: Exception) {
        println(e)
    } finally {
        println("finally")
    }
}
