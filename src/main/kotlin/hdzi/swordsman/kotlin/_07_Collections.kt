package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/20.
 */

/**
 * 区间
 */
val range1 = 1..100 // 1到100
val range2 = 100 downTo 1 // 100 到 1
val range3 = 1..100 step 2 // 1到100,步长2
val range4 = 1 until 100 // 1到99

/**
 * in 检查成员
 */
val _in = 2 in range1
val _not_in = -1 !in range1

/**
 *  声明集合:kotlin的集合声明基本依靠工具函数
 */
// 数组
val arrInt = intArrayOf(1, 2, 3) // 内建类型专用(int,long,boolean,float等值类型)
val arrString = arrayOf("A", "B", "C") // 通用
// list
val listInt = listOf(1, 2, 3)
// map
val mapIntString = mapOf(1 to "one", 2 to "two") // 用 to 方法生成Pair<K, V>
// 可变集合 mutable*()
val mlist = mutableListOf(1, 2, 3)

/**
 * 存取集合
 */
fun changeCollection() {
    // 数组
    var ele = arrInt[0] // get方法
    arrInt[0] = 1 // set方法
    // 集合
    ele = listInt[0]
    mlist[0] = 0
}