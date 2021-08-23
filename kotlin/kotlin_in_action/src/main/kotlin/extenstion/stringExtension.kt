package extenstion

fun String.isNumber():Boolean {
    var i = 0
    while(i<this.length) {
        if(!(this[i] in '0'..'9')) return false
        i += 1
    }
    return true
}

fun main(args:Array<String>) {
    println("12330130".isNumber())
    println("500원".isNumber())
}