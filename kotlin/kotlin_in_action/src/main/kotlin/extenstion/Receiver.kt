package extenstion

/*
* Car 클래스 내에 멤버 함수를 추가하지 않고, 확장 함수를 사용해서 getInfo() 함수 추가.
* 수신 객체는 Car
* */
class Car(var brand:String, var price:Int) {
}

fun Car.getInfo():String {
    return "${this.brand}, $price"
}