package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/21.
 */

/**
 * 严格类型,没有隐式转换
 */
// int 和 long/float等无法隐式转换(算数运算除外),需要自己调用转换方法
val i: Int = 1
val l: Long = i.toLong()
val l2: Long = 0L + i // 算数运算隐式转换

/**
 *  位运算由相应的中缀函数代替
 *
 *  shl(bits) ‒ 有符号左移 (Java 的 << )
 *  shr(bits) ‒ 有符号右移 (Java 的 >> )
 *  ushr(bits) ‒ ⽆符号右移 (Java 的 >>> )
 *  and(bits) ‒ 位与
 *  or(bits) ‒ 位或
 *  xor(bits) ‒ 位异或
 *  inv() ‒ 位⾮
 */
val x = (1 shl 2) and 0x0000FFFF
