package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/22.
 */

/**
 * 获取kotlin class 对象
 */
val kclass = Int::class
/**
 * 获取java class 对象
 */
val jclass = Int.javaClass

/**
 * 类属性
 * 用 ::
 */
val kproperty: (Int, Int) -> Int = Int::plus