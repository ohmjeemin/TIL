package book200.mid

//데이터 클래스

data class Employee(val name:String, val age:Int, val salary:Int)

fun main(args:Array<String>) {
    val first = Employee("John", 30, 3000)
    val second = Employee("Page", 24, 5300)
    val third = first.copy()

    println(first.toString())
    println(third.toString())
    println(first==second)
    println(first==third)
}