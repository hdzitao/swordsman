package hdzi.swordsman.scala


@MyAnnotation
class MyClass

object _11_Annotation {

  def main(args: Array[String]): Unit = {
    val klass = classOf[MyClass]
    klass.getAnnotations.foreach {
      println(_)
    }
  }

}
