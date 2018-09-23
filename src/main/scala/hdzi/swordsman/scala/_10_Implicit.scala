package hdzi.swordsman.scala

object _10_Implicit {

  implicit class _int(val i: Int) {
    def showSelf(): Unit = {
      println(s"I am $i")
    }
  }

  def main(args: Array[String]): Unit = {
    val v: Int = 19
    v.showSelf()
  }

}
