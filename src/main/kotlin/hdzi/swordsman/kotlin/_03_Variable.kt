package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/20.
 */

/**
 *  变量
 */
var var1: Int = 1 // 完整定义
var var2 = 1 // 简化定义(类型推导)

/**
 * 常量
 */
val val1: Int = 1
val val2 = 1

/**
 * 可选类型
 */
val opt: String? = null

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
 * 延迟属性
 */
val lazyVar: String by lazy {
    "lazy value"
}

/**
 * null 检测
 */
fun detectNull(): Int {
    // ?. 检测是否是null
    // ?: 如果null提供默认值
    return opt?.length ?: 0
}

