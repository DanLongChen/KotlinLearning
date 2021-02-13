package Day_1

import java.util.*

fun main(){


}

fun lambdaGetMaxWord(){
    val list= listOf<String>("apple","pear","orange")

    //使用传统方式获取到list中名字最长的水果名
    var maxLengthFruit=""
    for(fruit in list){
        if(fruit.length>maxLengthFruit.length){
            maxLengthFruit=fruit
        }
    }
    println("max length fruit is:"+maxLengthFruit)

    /**
     * lambda表达式语法：{ 参数名1：参数类型，参数名2：参数类型 -> 函数体 }
     */
    //TODO 使用函数式获取
    val lambda={fruit:String->fruit.length}
    val maxFruitLengthForLambda=list.maxBy(lambda)
    //TODO 进一步，可以直接将lambda传入maxBy
    val maxFruitLengthForLambda1=list.maxBy({fruit:String->fruit.length})
    //TODO 当 Lambda 参数是函数的最后一个参数时，可将 Lambda 表达式移到函数括号外面
    val maxFruitLengthForLambda2=list.maxBy(){fruit:String->fruit.length}
    //TODO 如果lambda表达式是唯一参数的话，()可以省略
    val maxFruitLengthForLambda3=list.maxBy{fruit:String->fruit.length}
//TODO Kotlin 拥有类型推导机制，Lambda 表达式中的参数列表大多数情况下可不必声明参数类型
    val maxFruitLengthForLambda4=list.maxBy{fruit->fruit.length}
    //TODO 当 Lambda 表达式的参数列表只有一个参数时，也不必声明参数名，可用 it 关键字代替
    val maxFruitLengthForLambda5=list.maxBy{it.length}

    /**
     * 常见函数式API介绍：map，filter，any，all
     */
    val newList=list.map{it.toUpperCase(Locale.ROOT)}//新列表的水果名都是大写
    val newList1=list.filter { it.length<=5 }.map{it.toUpperCase()}//名称<=5的变大写
    val anyResult=list.any { it.length<=5 }//list中有length<=5的则返回true
    val allResult=list.all { it.length<=5 }//list中是否所有的单词都<=5
}

fun runnableTest(){
    Thread(object:Runnable{
        override fun run() {
            print("run")
        }
    }).start()
    //可以简化为
    Thread(Runnable { print("run") }).start()
    //Java 方法的参数列表只有唯一一个单抽象方法接口参数，可把接口名省略
    Thread({ print("run") }).start()
    //当 Lambda 表达式是方法的最后一个参数时，可把它移到方法括号外面，
    // 同时如果它还是方法的唯一一个参数，可把方法的括号省略
    Thread{print("run")}.start()
}

fun nullptrTest(){
    /**
     * Kotlin 默认所有参数和变量都不可空，当你传一个 null 参数时，
     * 编译器会提示错误,Kotlin 把空指针异常的检查提前到了编译时期，
     * 程序若存在空指针异常的风险，那么在编译时会直接报错
     */
}

fun getList():List<String>{
    //    val list=ArrayList<String>()
//    list.add("a")
//    list.add("b")
//    list.add("c")
    /**
     * listOf创建不可变集合
     * 创建可变集合使用mutableListOf
     */
    val list= listOf<String>("a","b","c")
//    list.add("f") todo 进行add操作会报错
    val list1= mutableListOf<String>("a")
    list1.add("f")
    return list1
}

fun getSet():Set<String>{
    /**
     * Set 集合的用法也差不多，
     * 将创建集合的方式变成 setOf() 和 mutableSetOf() 函数而已。
     */
    val set= setOf<String>("a","b")
    return set
}

fun getMap():Map<String,Int>{
    val map=HashMap<String,Int>()
    map.put("apple",1)
    print(map.get("apple"))
    /**
     * Kotlin 中不建议用 put() 和 get() 方法来对 Map 进行数据操作，
     * 而推荐使用一种类似于数组下标的语法结构，
     * 如添加 map["apple] = 1，读取 val number = map["apple"]
     */
    map["peach"]=10
    print(map["peach"])
    // TODO 使用 mapOf() 和 mutableMapOf() 来简化
    return map
}