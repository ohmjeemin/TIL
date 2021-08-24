package book200.mid

class Person2 private constructor() {
    companion object {
        fun create():Person2 {
            countCreated += 10
            return Person2()
        }

        var countCreated = 0
            private set
    }
}

fun main(args:Array<String>) {
    val a = Person2.create()
    val b = Person2.create()
    println(Person2.countCreated)
}