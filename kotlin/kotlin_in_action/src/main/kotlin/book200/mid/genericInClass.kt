package book200.mid

class Pair<A, B>(val first:A, val second:B) {
    override fun toString() = "$first\n$second"
}
//클래스나 인터페이스에서 타입을 인수로 받으려면 선언시 이름 옆에 <식별자>를 붙인다.
//모든 타입은 Any를 상속하므로, 어떤 타입이 오더라도 toString 멤버 함수를 가지고있다.

fun main(args:Array<String>){
    val pair:Pair<Int, String>  // 제네릭이 적용될 클래스와 인터페이스에는 이름 옆에 <타입인수>를 붙여야 한다.
    pair = Pair<Int, String> (95, "엄지민")    // 생성자를 호출할 때도 생성자 이름 옆에 <타입인수>를 붙인다
    println(pair.toString())
}