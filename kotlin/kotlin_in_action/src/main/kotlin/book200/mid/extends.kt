package book200.mid

open class AA
class BB:AA()

//AA에 확장함수 hello 주입
fun AA.hello() = println("AAA")

//BB에 확장함수 hello 주입
fun BB.hello() = println("BBB")

fun main(args:Array<String>){
    //타입은AA이나 실제로 BB를 가리키는 test 참조변수 선언
    val test:AA = BB()
    test.hello() // 확장함수는 참조변수의 타입을 그대로 따른다.
}


