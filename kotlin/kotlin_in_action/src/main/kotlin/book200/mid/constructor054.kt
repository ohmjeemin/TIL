package book200.mid

//객체를 생성하면서 원하는 값으로 한번에 초기화 하는 방법

class Animal constructor(name:String, age:Int) {
    val name:String
    val age:Int

    init {
        this.name = name
        this.age = age
    }
}

fun main(args: Array<String>) {
    val a = Animal("황구", 1)
    println(a.name)
    println(a.age)
}