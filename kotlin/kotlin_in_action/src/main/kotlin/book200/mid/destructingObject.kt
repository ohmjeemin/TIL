package book200.mid

//데이터 클래스 인스터스에 한해, 객체를 여러 개의 변수로 쪼개는 것이 가능하다.

data class Employee2(val name:String, val age:Int, val salary:Int)

fun main(args:Array<String>) {
    val (name, _, salary) = Employee2("jeemin", 27, 3500)
    println(name)
}