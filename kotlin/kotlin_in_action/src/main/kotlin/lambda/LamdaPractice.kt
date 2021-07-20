package lambda

/*
* 람다 식을 표현할 때는 식을 간략히 할 수 있는 몇가지 규칙이 있다.
* 1. 맨 마지막 인자가 람다일 경우, 람다 식을 소괄호 밖으로 뺄 수 있다.
* 2. 컴파일러가 유추할 수 있는 타입인 경우, 인자 타입은 생략 가능하다.
* 3. 매개변수가 하나 뿐일 때 그 매개변수 이름을 대신해 사용할 수 있는 키워드 it을 사용하면 된다.
*
* */

fun higherOrderFunction(stringParam: String, funParam: () -> String) {
    println(stringParam + funParam())
}


fun callByValue(b:Boolean): Boolean {
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = {
    println("lambda function")
    true
}
fun sum(x:Int, y:Int) = x + y
fun funcParam(a:Int, b:Int, c:(Int, Int)->Int):Int {
    return c(a,b)
}

fun main() {
    higherOrderFunction("hello") {
        "world"
    }
    val out: () -> Unit = { println("Hello world!") }
    out()
    val new = out
    new()

    val result = callByValue(lambda())
    println(result)

    funcParam(3,2, ::sum)
}