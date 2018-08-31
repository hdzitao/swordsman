package hdzi.swordsman.scala

/**
  * Created by taojinhou on 2018/8/22.
  */
object _07_Collections {
  /**
    * 数组
    */
  val arr0 = new Array[Int](10) // size
  val arr1 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9) // 使用apply方法获取一个定义好的array

  /**
    * 区间
    */
  val range0 = 1 to 10 // [1, 10]
  var range1 = 1 until 10 // [1, 10)
  var range2 = 10 to 1 by -1 // 10 到 1, 步长 -1

  /**
    * 元组
    */
  val tuple1 = (1, "one")
  val tuple2 = 2 -> "two" // -> 只适用两元元组
  val one = tuple1._1 // 元组从1开始计数
  val (a, b, c) = (1, "2", 3.0)

}
