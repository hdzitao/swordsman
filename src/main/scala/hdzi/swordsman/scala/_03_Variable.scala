package hdzi.swordsman.scala

/**
  * Created by taojinhou on 2018/8/20.
  */

object _03_Variable {
  def main(args: Array[String]): Unit = {
    /* 变量(和kotlin完全相同) */
    var var1: Int = 1 // 完整定义
    var var2 = 1 // 简化定义(类型推导)

    /* 常量 */
    val val1: Int = 1
    val val2 = 1

    /**
      * Option - Some/None
      */
    val map = Map(1 -> "one")
    val one = map(1)
    val oneO = map.getOrElse(2, ".")
  }
}