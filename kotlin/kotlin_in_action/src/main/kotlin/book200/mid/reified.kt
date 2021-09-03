package book200.mid

fun <T> check2() {
    val number = 0
//    if(number is T) println("T는 Int타입 입니다")
//    타입 매개변수는 is 연산자의 피연산자로 사용할 수 없다.
}

inline fun <reified T> check() {
    val number = 0
    if(number is T) println("T는 Int타입 입니다")
}
//  타입 매개변수 앞에 reified을 붙여주면 해당 타입 매개변수를 is 연산자에 사용할 수 있다.

fun main(args:Array<String>) {
    check<Int>()
}
