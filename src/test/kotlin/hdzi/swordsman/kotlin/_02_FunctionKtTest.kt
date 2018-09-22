package hdzi.swordsman.kotlin

import org.junit.Assert.*
import org.junit.Test

class _02_FunctionKtTest {
    @Test
    fun testLambdaCall(): Unit {
        fun <T> doit(i: T, j: T, f: (T, T) -> T) = f(i, j)
        val r = doit(1, 2) {i, j -> i + j} // lambda挂在参数列表后面
        assertEquals(r, 3)
    }
}