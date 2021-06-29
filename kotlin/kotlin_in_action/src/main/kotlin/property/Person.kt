package property

class Person private constructor(val name:String, var isMarried:Boolean){
    init {
        println("${name}is VIP")
    }
}

class Animal {
    var age:Int = 20
    var name:String ="wong"

    constructor(age:Int, name:String) {
        this.age = age
        this.name = name
    }
}

class Student(val name:String) {
    var age:Int

    init {
        age = 26
    }

    constructor(name:String, age:Int): this(name){
        // 이곳에서 init 블럭 실행
        println(this.age) // 26
        this.age = age
        println(this.age) // 27
    }
}

fun main(args: Array<String>){
    val student1 = Student("Jimny", 27)
}