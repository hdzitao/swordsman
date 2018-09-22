package hdzi.swordsman.scala

import org.junit.{Assert, Test}

class FunctionStruct {

  @Test
  def testSum(): Unit = {
    def sum(list: List[Int]): Int = list match {
      case Nil => 0
      case head :: tail => head + sum(tail)
    }

    Assert.assertEquals(0, sum(Nil))
    Assert.assertEquals(45, sum(List(1, 2, 3, 4, 5, 6, 7, 8, 9)))
  }

  @Test
  def testHead(): Unit = {
    def head[T](h: T, t: List[T]): List[T] = h :: t

    Assert.assertEquals(List(1, 2, 3), head(1, List(2, 3)))
  }

  @Test
  def testUnderline(): Unit = {
    val add3 = { (a: Int, b: Int, c: Int, f: (Int, Int, Int) => Int) =>
      println(f(a, b, c))
    }

    add3(1, 2, 3,  _ + _ + _ /* 单行函数字面量，三条横线代表三个参数 */)
  }
}
