package hdzi.swordsman.groovy

/**
 * Created by taojinhou on 2018/8/23.
 */

/**
 * Java字符串
 */
def s = 'a' // 字符串
def c = 'a' as char // 字符
def ss = "a" // 不带插值的""

/**
 * GString
 */
def gs = "${ss}" // 带插值的""

/**
 * 原始字符串
 */
def sss = """
用单引号不转义
用双引号支持GString
"""

/**
 * 正则表达式
 *
 * +实际上是个字符串,但不需要转义
 * +存在匹配 =~
 * +精确匹配 ==~
 */
def re = /\d+/
