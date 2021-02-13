package Day_1.ClassTest

/**
 * Kotlin 中统一用冒号 : 继承类或实现接口
 * Person 类的后面要加一对（），表示 Student 类的主构造函数在初始化时会调用 Person 类的无参构造函数
 */
class Student(val number:Int ,val grade:Int,name:String,age:Int):Person(name,age),Study{
//TODO Kotlin 的构造函数有两种：主构造函数 和 次构造函数
    //主构造函数没有函数体，每个类默认会有一个不带参数的主构造函数，
    // 也可以在类名后面直接定义来显式指明参数
    //在主构造中执行逻辑可以在init中
    //TODO 柱构造只能有一个，次构造可以有很多个（次构造也可以实例化类，其有函数体）
    init {
        print("init")
    }

    /**
     * Kotlin 规定，当一个类既有主构造函数也有次构造函数时，
     * 所有的次构造函数都必须调用主构造函数（包括间接调用）。
     */
    private constructor(name:String,age:Int):this(0,0,name,age){}
    constructor():this("",0){}

    override fun readBook() {
        println("readBook")
    }

    override fun doHomework() {
        println("doHomework")
    }
}

/**
 * 数据类 - Kotlin 只需在数据类前面声明关键字 data 就可以
 * 单例 - Kotlin 只需把 class 关键字改成 object 就可以了
 */
fun main(){
   val student=Student()
    doStudy(student)
}

/**
 * Kotlin 默认所有参数和变量都不可空，其在编译期进行检查，若希望可以为空则加上?
 */
fun doStudy(study:Study?){
    if(study!=null){
        study.doHomework()
        study.readBook()
    }
    //TODO 也可以使用判空辅助工具
    study?.readBook()
    //?: 的左右两边都接收一个表达式，
    // 若左边表达式的结果不为空则返回左边表达式的结果，否则返回右边表达式的结果
    val a=0
    val b=0
    val c=a?:b
    //操作符 !! 的作用是告诉 Kotlin 非常确信对象不会为空，
    // 不需要 Kotlin 帮忙做空指针检查，若出现问题再直接抛出空指针异常
    val d=a!!

    /**
     * let函数，let 函数提供了函数式 API 的编程接口，
     * 并将原始调用对象作为参数传递到 Lambda 表达式中
     */
    study?.let { stu->
        stu.readBook()
        stu.doHomework()
    }
    //TODO 当lambda表达式只有一个参数的时候，可以将参数名省略，用it代替
    study?.let {
        it.readBook()
        it.doHomework()
    }
}