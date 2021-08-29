package book200.mid

// 클래스의 프로퍼티는 선언과 동시에 초기화하거나 init블록 안에서 반드시 초기화해주어야 한다.
// 사용자 정의 클래스라면 어떻게 초기화하면 될까?

// 점을 표현하는 클래스
class Point(val x:Int, val y:Int)
//사각형을 표현하는 클래스
class Rect {
    lateinit var pt:Point //lateinit은 클래스 안에서 바로 초기화하지 않아도 된다.
    lateinit var pt2:Point
    // 너비, 높이, 넓이 프로퍼티를 계산하기 위해 getter 커스터마이징
    val width:Int get() = pt2.x - pt.x
    val height:Int get() = pt2.y - pt.y
    val area get() = width * height
}

fun main(args:Array<String>) {
    val rect = Rect()
    rect.pt = Point(3,3)
    rect.pt2 = Point(6,5)

    // pt1, pt2를 지정하지 않고 아래를 출력하면 에러가 발생한다.
    println("너비:${rect.width}")
    println("높이:${rect.height}")
    println("넒이:${rect.area}")
}
