package hdzi.swordsman.scala

object _11_Annotation {

  class MyAnnotation extends annotation.ClassfileAnnotation

  @MyAnnotation
  class MyClass

}
