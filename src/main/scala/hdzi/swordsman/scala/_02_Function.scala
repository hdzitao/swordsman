package hdzi.swordsman.scala

import scala.annotation.tailrec

/**
  * Created by taojinhou on 2018/8/20.
  */
object _02_Function {
  /**
    * 定义简短函数
    */
  def max(a: Int, b: Int): Int = if (a > b) a else b

  /**
    * 定义函数(return可省略)
    */
  def max_v2(a: Int, b: Int): Int = {
    if (a > b) a else b
  }

  /**
    * 有默认值的函数
    * def foo(opt: Int = 0, par: Int) ==> foo(par = 1)  //使⽤默认值opt=0
    */
  def large(i: Int, j: Int = 0) = i > j

  /**
    * 函数重载,这个定义和上面的函数有点冲突,但优先调用下面的函数(应该是下面的函数匹配度高)
    */
  def large(i: Int) = true

  /**
    * 命名参数
    */
  def nameParams() = {
    max(b = 2, a = 1) // 特别注意这个语法在Java是完全不同的意思
  }

  /**
    * 可变参数
    */
  def sum(i: Int*): Int = {
    i.reduce { (i, j) => i + j + 0 }
  }

  def varArg() = {
    sum(1, 2, 3, 4, 5, 6, 7, 8, 9)
    sum(List(1, 2, 3, 4, 5, 6, 7, 8, 9): _*)
  }

  /**
    * 无参函数可以没有括号,调用时也不能有括号
    */
  def name = "Hdzi"

  /**
    * 多个参数列表.函数柯里化定义,调用时也要传多个参数列表
    */
  def addn(n: Int)(i: Int) = i + n

  val add5 = addn(5) _ // 柯里化定义的函数允许参数部分固化

  /**
    * 偏函数
    */
  // 统一定义
  val dis: PartialFunction[Any, Unit] = {
    case i: Int => println(s"Int: $i")
    case s: String => println(s"String: $s")
  }
  // 分开定义
  val dis_v2_p1: PartialFunction[Any, Unit] = {
    case i: Int => println(s"v2 Int: $i")
  }
  val dis_v2_p2: PartialFunction[Any, Unit] = {
    case s: String => println(s"v2 String: $s")
  }
  val dis_v2 = dis_v2_p1 orElse dis_v2_p2

  /**
    * lambda
    */
  val inc: Int => Int = {
    _ + 1
  } // 单参数可用 _ 代替
  val max_v2 = (a: Int, b: Int) => { // 单行{}可省略
    if (a > b) a else b
  }
  val max_v3 = { (a: Int, b: Int) =>
    if (a > b) a else b
  }

  /**
    * 嵌套定义函数
    */
  def outFunc(): () => Int = {
    def innerFunc() = 1

    innerFunc
  }

  /**
    * 强制 尾递归优化
    * scala会自动尝试尾递归优化，默认情况下不报告是否成功，该注解强制尾递归必须成功，失败则报错
    */
  @tailrec
  def findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))

  /**
    * 函数返回多值
    * 用 _1, _2, _3 索引
    */
  def mutiValue(): (Int, String) = {
    return (1, "one")
  }

  /**
    * inline
    */
  @inline def getI: Int = 1
}
