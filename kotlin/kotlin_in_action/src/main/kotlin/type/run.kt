package type

class OverTen(val value:Int){
    init {
        if(value<=10) throw Exception("error")
    }
}

fun plus(a: OverTen, b: OverTen):Int{
   return a.value + b.value
}

fun main(){
    print(plus(OverTen(150), OverTen(50)))
}