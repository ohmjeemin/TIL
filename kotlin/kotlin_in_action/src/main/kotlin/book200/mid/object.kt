package book200.mid

// object : 프로그램 전체에서 공유할 수 있는 하나뿐인 객체가 필요할 때

object Person {
    var name:String = ""
    var age:Int = 0
    fun print() {
        println(name)
        println(age)
    }
}

fun main(args:Array<String>) {
    Person.name = "Singleton"
    Person.age = 45
    Person.print()
}