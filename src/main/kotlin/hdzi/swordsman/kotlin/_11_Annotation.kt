package hdzi.swordsman.kotlin

/**
 * Created by taojinhou on 2018/8/22.
 */

/**
 * 声明注解
 */

@Target(
    AnnotationTarget.CLASS, AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.RUNTIME)
annotation class Fancy(val what: String = "test") // 构造函数

/**
 * 使用注解
 */
@Fancy("test")
class TestAnnotation @Fancy constructor() {
    lateinit var test1: String
        @Fancy get

    @get:Fancy // 注明注解使用的地方
    lateinit var test2: String
}