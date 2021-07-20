package type

fun main() {
    getArgs("지민", "지현", "규섭", "기율")
}

fun checkArg(x: Any) {
    if(x is String) {
        println("x is string")
    }
    if(x is Int) {
        println("x is Int")
    }
}

fun getArgs(vararg names:String){
    for(name in names){
        print(name)
    }
    print(names is Array<*> )
}