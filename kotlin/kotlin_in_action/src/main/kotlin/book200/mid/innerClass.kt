package book200.mid

class Outerr(private val value:Int) {
    fun print() {
        println(this.value)
    }
    //내부 클래스를 선언할 때는 선언문 앞에 inner 키워드를 붙인다
    inner class Inner(private val innerValue:Int){
        fun print() {
            this@Outerr.print()
            println(this.innerValue+this@Outerr.value)
        }
    }
}

fun main(args:Array<String>) {
    val instance:Outerr = Outerr(610)
    val innerInstance:Outerr.Inner = instance.Inner(40)
    innerInstance.print()
}