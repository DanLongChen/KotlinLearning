package Day_1

import kotlin.math.max

/**
 * kotlin定义变量，只允许使用两种关键字：
 * val（声明不可变变量，相当于final、const）
 * var（声明可变变量）
 * 并且在语句的末尾不需要加上;
 */
//todo(todo为了高亮) fun是定义函数的关键字
fun main() {
    val a = 10
    val b = 20
    val value = getMax1(a, b)
    println("the max num is: $value")
    println("what is ths score:"+ getScore1("jasper"))
    checkNum(a)
    forFunc()
}
/**
 * 参数和返回值的定义顺序与java和c++相反
    先定义参数名，再定义类型和返回值（返回值类似于c++的后置返回值）

 TODO 可以给参数设置默认值，若默认值不是最后一个则需要使用键值对的形式来调用
 如：getMax（num2=20），这里假设其函数形式为fun getMax(num1: Int=10, num2: Int)
 */
fun getMax(num1: Int, num2: Int=10): Int {
    var returnValue=0
    //todo kotlin中的条件语句可以使用if和when，when相当于java中的switch但是更加强大
    if(num1>num2){
        returnValue=num1
    }else{
        returnValue=num2
    }
//    return max(num1, num2) 可以直接使用math库
    /**
     * kotlin中的if可以有返回值，返回值为每个条件最后一行代码
     * (可以对上面代码进行简化)
     */
    return if(num1>num2){
        num1
    }else{
        num2
    }
}

/**
 * 当一个函数只有一行代码时，可以省略函数体部分，
 * 直接将这一行代码使用等号串连在函数定义的尾部。
 */
fun getMax1(num1:Int,num2:Int):Int=if(num1>num2)num1 else num2

/**
 * 执行逻辑只有一行的时候，{}可以省略，else相当于default
 */
fun getScore(name: String): Int = when (name) {
    "jasper" -> 100
    "neo" -> 99
    else -> 0
}

/**
 * 在某些场景，比如 所有名字以Won开头的学生分数都是100分，
 * 则上述函数可以用不带参数的when语句实现
 */
fun getScore1(name: String): Int = when {
    name.startsWith("wang") -> 100
    name == "jasper" -> 90
    else -> 0
}

/**
 * 当前when也可以用来检查类型
 */
fun checkNum(num:Number){
    when(num){
        is Int->println("is Int")
        is Double->println("is Double")
        else->println("is not a number")
    }
}

/**
 * Java 中常用的 for-i 循环在 Kotlin 中被舍弃了，
 * Java 中的 for-each 循环在 Kotlin 中变成了 for-in 循环。
 */
fun forFunc(){
    //TODO Kotlin 用 .. 创建闭区间[0,10]
    for(i in 0..10){
        print(" "+i)
    }
    println()

    //TODO 用 until 关键字创建左闭右开的区间[0,10)步长为2
    for(i in 0 until 10 step 2){
        print(" "+i)
    }
    println()

    for(i in 10 downTo 1){
        print(" "+i)
    }
}
fun whileFunc(target:Int){
    var i=0
    while(i<target){
        println("i is:"+i)
        i++
    }
}