package hdzi.swordsman.groovy

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode

/**
 * 强制静态类型检查
 *
 * 丧失动态能力
 */
@TypeChecked
def shout(String str) {
    //return str.toLowercase() // 拼写错误报错，否则它会被当做动态方法而通过编译
    return str.toLowerCase()
}

@TypeChecked
//全类检查
class Sample {
    def beChecked() {}

    // 跳过检查
    @TypeChecked(TypeCheckingMode.SKIP)
    def notChecked() {}
}

/**
 * 静态编译
 *
 * + Java7+版本基本不需要此功能
 */
@CompileStatic
def shout2() {

}