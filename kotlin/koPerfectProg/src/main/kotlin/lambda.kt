
//클릭했을 때 같이 넘겨준 람다를 실행시키고, 버튼 색 세팅하는 함수

class Button(var color:String="", var width:Int=0, var height:Int=0) {
    var action:(()->Unit)? = null
}

fun setBtn(button: Button, color:String, width: Int, height: Int): Button {
    return button.apply {
        this.width = width
        this.color = color
        this.height = height

    }
}
fun clickBtn(button:Button, block:()->Unit) {
    button.action = block
    //test
}

fun main() {
    var btn = Button("pink", 100, 50)
    setBtn(btn, "blue", 100, 30)
    clickBtn(btn) {
        println("클릭했어용")
    }
    btn.action?.invoke()
}