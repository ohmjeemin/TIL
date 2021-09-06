package book200.mid

//타입 인수를 특정 타입으로 제한하는 방법
interface ValueContainer2{
    fun getValue():Int
}

class AAA:ValueContainer2 {
    override fun getValue():Int = 1102
}
class BBB:ValueContainer2 {
    override fun getValue():Int = 127
}
