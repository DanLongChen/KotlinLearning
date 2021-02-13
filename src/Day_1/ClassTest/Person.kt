package Day_1.ClassTest

/**
 * 在Kotlin中，用 class 关键字来声明一个类
 * TODO 使 Person类可以被继承（注：Kotlin 中任何一个非抽象类默认是不可被继承的）
 * TODO 在 Person 类前面加上关键字 open 就可以了
 */
//class Person{}
open class Person(val name:String,val age:Int){
    fun play(){
        println("i am $name and i am $age years old")
    }
}

/**
 * 类的实例化方式和 Java 是基本类似的，但不需要new关键字
 */
fun main(){
    val person = Person("daniel",100)
    person.play()
}