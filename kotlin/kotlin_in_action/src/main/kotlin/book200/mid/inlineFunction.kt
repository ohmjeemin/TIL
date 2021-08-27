package book200.mid


//함수 앞에 inline 키워드를 붙이면 그 함수는 inline이 된다.
inline fun hello() {
    println("Hello")
    println("Kotlin")
}

fun main(args:Array<String>) {
    //이렇게 호출하면
    hello()
    hello()
    hello()
    //컴파일되면 이렇게 함수 호출문이 함수 속의 문장으로 대체된다.
    println("Hello")
    println("Kotlin")
    println("Hello")
    println("Kotlin")
    println("Hello")
    println("Kotlin")
}

/*
* inline함수는 함수 속의 문장을 재활용하지 않기 때문에, 문장이 많은 함수를 inline으로 바꾸면 프로그램의 크기가 기하급수적으로 늘어난다.
* 문장이 적고 빈번히 호출되는 함수만 inline으로 만들것!!
* */