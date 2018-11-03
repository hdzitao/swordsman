package hdzi.swordsman.scala

/**
  * Created by taojinhou on 2018/8/20.
  */
object _05_Class {

  // 在主构造器前不加限定符即为public
  class Person private(val name: String, var age: Int) { // 主构造函数,自动定义属性和访问器
    def this(name: String) {
      this(name, 1)
    }

    def this() { // 次要构造函数
      this("Hdzi") // 第一条必须是调用其他 能通到主构造函数 的其他构造函数
    }

    var local: String = "上海" // 变量,自动定义访问器

    val _type: String = "Man" // 常量,自动定义访问器

    // 自定义访问器
    /**
      * scala自定为字段生成访问器,访问器权限同字段;
      * private[this]声明不要生成访问器
      */
    private[this] val _home: String = "浙江"

    def home = _home

    private[this] var _school: String = "春晖"

    def school_=(school: String) = { // 调用时去掉 _ ,形同 person.school = "new value"
      println("转校......")
      this._school = school
    }
  }

  /**
    * 伴生对象
    */
  object Person {
    /**
      * 利用 apply 方法直接用类名创建对象
      *
      * @param name
      * @param age
      * @return
      */
    def apply(name: String, age: Int): Person = new Person(name, age)
  }

  def newPerson(): Unit = {
    // new 一个实例
    val person = new Person()
    // 利用 apply 方法直接用类名创建对象
    val person2 = Person("name", 20)
  }

  /**
    * 继承
    */
  class Base

  trait BaseInterface1

  trait BaseInterface2

  class Sub extends Base with BaseInterface1 with BaseInterface2

  class Sub2 extends BaseInterface1 with BaseInterface2 // 只有接口也用 extends

  /**
    * trait混入
    *
    * super查找方法路径:
    *                T
    *                ^^
    *                <<<<<<<<<<<<<<<
    * class A extends B with C with D{
    *                              ^^
    *     override def ...===========
    * }       ^^
    *         ^^
    *         <<<<<<<<<<<<<<<<<<<
    * val i = new A with E with F
    */
  trait Implement {
    def show(): Unit
  }

  trait Implement1 extends Implement {
    // 方法体内调用了一个抽象方法，得用abstract修饰。
    // 此trait无法正常被class extends了，因为不能保证其super路径上一定有实现
    // 要解决这个问题:
    // 1. 在继承此trait之前，继承一个实现了show()方法的trait或类，确保其super路径上有实现：
    //    class MixIn extends ImplementShow(实现了show方法) with Implement1
    // 2. 可以给Implement的show方法一个默认空实现，这样就不用abstract修饰了，一切又正常了
    abstract override def show(): Unit = {
      println(1)
      super.show()
    }
  }

  trait Implement2 extends Implement1 {
    abstract override def show(): Unit = {
      println(2)
      super.show()
    }
  }

  class MixIn extends Implement {
    override def show(): Unit = {
      println(4)
    }
  }

  class MixIn2 extends MixIn with Implement1 {
    override def show(): Unit = {
      println(5)
      super.show()
    }
  }

  def main(args: Array[String]): Unit = {
    val m = new MixIn with Implement2
    m.show()

    val m2 = new MixIn2
    m2.show()
  }

}
