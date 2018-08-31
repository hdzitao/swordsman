package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/21.
 */

/**
 * 泛型类
 */
class Box<T : Number>

/**
 * 泛型方法
 */
fun <T> foo(t: T) = t

/**
 * 型变
 */

/* 声明处型变: 所有使用的地方都能型变 */
// 协变
class Box2<out T>

// 逆变
class Box3<in T>

/* 使用处型变 */
// 协变
val box1: Box<out Number> = Box<Int>()
// 逆变
val box2: Box<in Int> = Box<Number>()

// 星投影
val box3: Box<*> = Box<Float>()