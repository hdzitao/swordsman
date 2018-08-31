package hdzi.swordsman.groovy

/**
 * Created by taojinhou on 2018/8/23.
 */

/**
 * 闭包定义
 */
def inc = { it + 1 } // 单参数可以用 it 代替
def add = { i, j -> i + j } // 多参数需要自己定义

/**
 * 柯里化
 *
 * + curry  正向柯里化
 * + rcurry 逆向...
 * + ncurry 定位...
 */
def add3 = add.curry(3)

/**
 * 闭包的this/owner/delegate
 * 类似Ruby执行block是的self指向
 *
 * this:     定义闭包时的对象;
 * owner:    一般等于this,但如果是在闭包里定义闭包,这个值就是外层的闭包
 * delegate: 一般等于owner,但可以自己设置以达到委托的目的
 */

/**
 * 尾递归
 * 调用 trampoline
 */
def factorial = { int i ->
    def _factorial
    _factorial = { int number, BigInteger theFactorial ->
        number == 1 ? theFactorial : _factorial.trampoline(number - 1, number * theFactorial)
    }

    _factorial(i, 1)
}.trampoline()

println factorial(5)