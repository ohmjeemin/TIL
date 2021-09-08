package book200.mid

//배열은 타입이 같은 변수를 여러 개 만들 때 사용하며
// size, get, set, iterator()가 있다.

fun main(args:Array<String>) {
    val integers:Array<Int> = arrayOf(10,20,30,40)
    println(integers.size)
    println(integers[1])

    for(i in integers) print("$i ")
}