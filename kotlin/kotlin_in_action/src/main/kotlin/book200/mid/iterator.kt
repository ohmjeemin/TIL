package book200.mid

/*
* 반복자란? 특정 구간 속에 있는 원소를 하나씩 반복적으로 꺼내기 위한 인터페이스를 뜻한다.
* 코틀린에는 Iterator라는 인터페이스거 기본적으로 선언되어 있으며 다음과 같이 생겼다
* interface Iterator<out T> {
*   operator fun next():T
*   operator fun hasNext():Boolean
* }
* */

fun main(args:Array<String>) {
    val range:IntRange = 1..3
    val iter:Iterator<Int> = range.iterator()

    println(iter.hasNext())
    println(iter.next())

    println(iter.hasNext())
    println(iter.next())

    println(iter.hasNext())
    println(iter.next())

    println(iter.hasNext())
}