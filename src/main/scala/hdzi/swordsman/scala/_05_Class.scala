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

  def main(args: Array[String]): Unit = {
    // new 一个实例
    val person = new Person()
    // 利用 apply 方法直接用类名创建对象
    val person2 = Person("name", 20)
  }
}
