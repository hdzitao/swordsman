package hdzi.swordsman.scala

/**
  * Created by taojinhou on 2018/8/20.
  */
object _04_String {
  def main(args: Array[String]): Unit = {
    // 模板字符串
    val name = "Hdzi"

    def getAge() = 20

    // 用 $ 在字符串里插值,复杂插值用 ${}
    val introduction = s"Name: $name, age: ${getAge()}"

    // 原始字符串
    val rs =
      """
        |abc
        |def
      """.stripMargin

    // 符号
    val sym = 'abc

  }
}
