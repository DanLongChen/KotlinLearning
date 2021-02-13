package Day_1.ClassTest

interface Study {
    fun readBook()
    fun doHomework(){
        //Kotlin 还允许对接口中定义的函数进行默认实现
        print("默认实现")
    }
}