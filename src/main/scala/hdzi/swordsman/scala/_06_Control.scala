package hdzi.swordsman.scala

object _06_Control {

  /**
    * if 表达式:if 会返回{}内最后一个值
    */
  def tryIf(a: Int, b: Int) = if (a > b) {
    println("choose a")
    a
  } else {
    println("choose b")
    b
  }

  /**
    * for-in
    */
  def useForIn[T](list: List[T]) = {
    for (i <- list) {
      print(i)
    }
  }

  /**
    * for-in-with-if
    */
  def useForInIf(list: List[Int]) = {
    for (i <- list if i % 2 == 0 if i % 3 == 0) { // 在遍历时可以过滤，可以加多个
      print(i)
    }
  }

  /**
    * for-in-with-yield
    */
  def useForInYield(list: List[Int]) = {
    for {
      i <- list if i % 2 == 0 if i % 3 == 0
    } yield i //生成新的列表
  }

  /**
    * for-in-expand
    */
  def useForInExtend(list: List[String]) = {
    for {
      s <- list
      up = s.toUpperCase // 初始定义值
    } {
      print(s"$s => $up")
    }
  }

  /**
    * while同Java
    */


}
