package book200.mid


//타입 인수를 여러 개 받으려면 fun 키워드와 함수 이름 사이를 <타입1, 타입2>
fun <T,R> T.test(upgrade:(T)->R):R {
    return upgrade(this)
}

fun main(args:Array<String>) {
    val upgradedName = "지민".test {
        "$it 이가 짱이얌"
    }
    println(upgradedName)
}

