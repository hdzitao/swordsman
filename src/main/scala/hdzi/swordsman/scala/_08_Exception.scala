package hdzi.swordsman.scala


/**
  * Created by taojinhou on 2018/9/11.
  */
object _08_Exception {
  def throwException(): Unit = {
    throw new RuntimeException()
  }

  def catchException(): Unit = {
    try {
      throwException()
    } catch {
      case e: RuntimeException =>
        println(e)
      case e: Exception =>
        println("Exception")
        println(e)
    } finally {
      println("finally")
    }
  }

  def main(args: Array[String]): Unit = {
    catchException()
  }
}
