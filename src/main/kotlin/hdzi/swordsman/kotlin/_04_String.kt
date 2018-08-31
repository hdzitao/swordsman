package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/20.
 */

/**
 * 模板字符串
 */
val name = "Hdzi"
fun getAge() = 20
// 用 $ 在字符串里插值,复杂插值用 ${}
val introduction = "Name: $name, age: ${getAge()}"

/**
 * 字符串字面量
 */
// 支持转移
val s = "Hello!!\n"
// 原始字符串
val text = """
    for (c in "foo"){
        println(c)
    }
""".trimIndent()