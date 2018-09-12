package hdzi.swordsman.scala

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

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
    * 变长数组
    */
  val marr = new ArrayBuffer[Int]()

  /**
    * 不可变列表
    */
  val list = List(1, 2, 3, 4, 5, 6)
  val list2 = 1 :: 2 :: 3 :: 4 :: Nil

  /**
    * 可变列表
    */
  val mlist = mutable.MutableList(1, 2, 3, 4)

  /**
    * map
    */
  val map = Map(1 -> "one", 2 -> "two")

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
