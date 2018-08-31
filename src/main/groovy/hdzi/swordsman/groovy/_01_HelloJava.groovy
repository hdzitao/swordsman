package hdzi.swordsman.groovy
/**
 * Created by taojinhou on 2018/8/20.
 */

/**
 * groovy启动不需要main函数,当然groovy也可以像java一样启动
 */
println("Hello Java!")

/**
 * 循环
 */
for (i in 0..2) {
    println("ho ")
}
// java风格
for (def i : 0..2) { // 类型声明不能省略
    println("ho ")
}
// 通过方法
0.upto(2) { println "$it" }
3.times { println "$it" }

/**
 * null判断
 */
def notNull(obj) {
    obj?.toString()
}

/**
 * 异常处理
 */
def throwEx() { // 不需要定义 throws
    throw new Exception("error")
}

def ce() {
    throwEx() // 不强制检查异常
}

/**
 * JavaBean
 *
 * +public/private/protected等限定符无效
 * +可以自定义getter和setter方法(定义方式和Java一致)覆盖自动生成的代码
 */
class Car {
    def miles = 0 // 自动定义getter和setter方法
    final year

    Car(year) {
        this.year = year
    }
}

/**
 * 灵活初始化和具名参数
 */
// 具名参数当做Map收进第一个参数
def access(map, a, b) {
    println("$map, $a, $b")
}

// 无论具名参数在开头还是结尾,都收入第一个参数
access x: 1, y: 2, z: 3, 1, 2
access 1, 2, x: 1, y: 2, z: 3

/**
 * 可选参数
 */
def log(x, base = 10) {
    Math.log(x) / Math.log(base)
}

/**
 * 多赋值
 */
def (a, b) = [1, 2]

/**
 * 实现接口
 */
// 一个方法
interface Useinterface {
    def f(a, b)
}

static def douseinterface(Useinterface useinterface) {
    useinterface.f(1, 2)
}

douseinterface({ a1, b1 ->
    println("$a1, $b1")
} as Useinterface) // 动态接口名用asType方法

// 多个方法
interface Useinterface2 {
    def f1(a)

    def f2(a, b)
}

static def douseinterface2(Useinterface2 useinterface) {
    useinterface.f1(1)
    useinterface.f2(1, 2)
}

// 也可以只给一个lambda作为接口所有方法的实现(参数不匹配会报错)
douseinterface2([
        "f1": { a1 ->
            println("$a1")
        },
        "f2": { a1, b1 ->
            println("$a1, $b1")
        }] as Useinterface2)

/**
 * 布尔求值
 *
 * +Groovy会尝试推断是否为false:
 *  null 或 零值 为false
 */
String pd = "abc"
if (pd) {
    println("yes")
}

/**
 * Groocy允许操作符重载
 */
class CanPlus {
    def plus(Other) { // +
        return this
    }
}

/**
 * 变长参数
 */
static def sum(int ... ints) {
    return Arrays.stream(ints).reduce({ s, i -> s + i }).asInt
}

println sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
println sum([1, 2, 3, 4, 5, 6, 7, 8, 9, 10] as int[]) // []为list,需要转

/**
 * 注解 同Java
 */

/**
 * 泛型 同Java
 */

/**
 * 委托
 */
class Expert {
    def analyze() {}
}

class Worker {
    def work() {}

    def analyze() {}
}

class Manager {
    @Delegate
    Expert expert = new Expert()
    @Delegate
    Worker worker = new Worker() // analyze方法被忽略
}

/**
 * 延迟加载: @Lazy
 */

/**
 * 类Ruby new对象: @Newify
 */

/**
 * 单例: @Singleton 用 instance 获取
 */