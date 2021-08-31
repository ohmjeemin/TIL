package book200.mid

//동반자 객체에 확장 함수
//fun 클래스 이름.Companion.함수이름() {...}
class Member { companion object }
fun Member.Companion.create() = Member()

fun main(args:Array<String>) {
    Member.create()
}