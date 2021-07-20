package reciever



data class Person(var name: String, var age: Int)


class Book(val author:Person) {
    init {
        requireNotNull(author.age)
        print(author.name)
    }
}

class Book2(author: Person) {
    val author = author.also {
        it.name = "jeemin"

    }
}

