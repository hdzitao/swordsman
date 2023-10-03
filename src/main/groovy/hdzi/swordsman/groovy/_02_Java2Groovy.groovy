package hdzi.swordsman.groovy

import java.util.regex.Pattern

/**
 * 从java到groovy
 */
//==
//执行命令
println "git status".execute().text

//==
//null安全操作符 ?.
static String foo(String str) {
//    if (str != null) {
//        return str.reverse()
//    } else {
//        return null
//    }
    str?.reverse()
}

println foo("abc")

//==
//异常处理 groovy不强制检查异常
static FileInputStream openFile(String fileName) { // 不声明异常抛出
    new FileInputStream(fileName)
}

try {
    openFile("file") // 抛出异常给调用者
} catch (FileNotFoundException ex) {
    ex.printStackTrace()
}

//==
//JavaBean
class Car {
    def miles = 0 // 变量,groovy不强制要求类型
    final year // 常量,groovy不强制要求类型

    Car(year) { // groovy不强制要求类型
        this.year = year
    }
}

Car car = new Car(2023)
println car.year // 自动调用 getter
println car.miles // 自动调用 getter
car.miles = 10 // 自动调用 setter
println car.miles

//==
//灵活初始化
class Robot {
    def type, height, width
}

def robot = new Robot(type: 'arm', height: 10, width: 40) // 用具名参数初始化
println "${robot.type} ${robot.height} ${robot.width}"

//==
//具名参数
def access(map, a, b) {
    println "${map} ${a} ${b}"
}

access(c: 1, d: 2, 3, 4) // 具名参数自动收集在第一个参数中
access(3, 4, c: 1, d: 2) // 和上面的结果一样,不管顺序,具名参数自动收集在第一个参数中

//==
//可选参数
def log(double x, double base = 10) {
    Math.log(x) / Math.log(base)
}

println log(1024) //使用默认值
println log(1024, 2)

def task(name, String[] details) { // groovy把末尾的数组参数看做可选的,并自动收集成数组
    println "${name} - ${details}"
}

task 'Call' // 末尾的数组参数可选
task 'Call', '123-456-789' // 自动收集末尾的数组参数
task 'Call', '123-456-789', '987-654-321' // 自动收集末尾的数组参数

//==
//多赋值
// 左边(),右边数组[],即可多赋值.数组也可以从函数返回以实现多返回的效果
// 两遍的数量不一定要对齐,多的丢弃,少的为null
def (name1, name2) = ["tao", "jinhou"]
println "${name1} ${name2}"

(name2, name1) = [name1, name2] // 利用多赋值交换两值
println "${name1} ${name2}"

//==
//接口
interface HelloInterface {
    String hello()

    String hi(String name)
}

def sayHello(HelloInterface helloInterface) {
    println helloInterface.hello()
    println helloInterface.hi("hdzitao")
}

// 利用 as 把代码块转化成接口,接口中的方法都指向代码块,即使参数上不匹配
sayHello({ "taojinhou" } as HelloInterface)
// 利用 as 和 map 实现对应方法
sayHello(["hello": { "taojinhou" }, "hi": { it }] as HelloInterface)

//==
//布尔值,groovy的布尔判断比java灵活
if (false // bool false
        || []  // 空list
        || [:]  // 空map
        || new int[0] //空数组
        || "" // 空字串
        || '\0' as char // \0 字符
        || 0 // 0
        || null // null
        || { false } as Enumeration // Enumeration.hasMoreElements => false
        || { false } as Iterator // Iterator.hasNext() => false
        || Pattern.compile("a").matcher("b") // 不匹配
) {
    println 'yes'
} else {
    println 'no'
}

//==
//操作符重载
class PlusEle {
    def plus(PlusEle ele) { // 重载 + ,更多的重载符看后续
        println "plus!"
        this
    }
}

new PlusEle() + new PlusEle()