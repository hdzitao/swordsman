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
 * 延迟属性
 */
val lazyVar: String by lazy {
    "lazy value"
}

