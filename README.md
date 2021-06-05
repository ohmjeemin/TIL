# TIL

## 코틀린으로 쇼핑몰 앱 만들기 (21/06/03 ~)
## 1. 함수와 변수
### 함수
코틀린에서 함수를 선언하는 방법에는 두 가지가 있다
- 일반적인 선언 방법<br>
``` 
fun sum(a: Int, b: Int): Int {
return a+b
}
```
- 표현식이 본문인 함수
``` fun sum(a: Int, b: Int) = a+b ```
함수명과 파라미터까지는 일반적인 선언 방법과 다를 것이 없지만 중괄호가 없이 표현식이 들어간다.

### 변수
```
var c:Int = 3
var d = 4
```
변수 선언은 val과 var로 시작하며, 변수명: 타입 순서로 이루어진다. 변수 선언과 동시에 값을 초기화하는 경우 타입을 생략할 수 있다. 값을 초기화하지 않는 경우 타입을 반드시 명시해주어야 한다. 
- 가변 변수와 불변 변수 <br>
**var** <br>초기화 이후에도 값을 변경할 수 있다.
**val** <br>한 번 초기화되면 이후 값을 변경할 수 없다.
## 2. 제어문
### if-else문
코틀린의 if-else문은 각 분기의 마지막 표현식의 결과값을 반환한다.
```
val dollor = 4
val class = if(dollor>=4) {
  "부자"
} else {
  "안부자"
}
```
### when문
코틀린의 when은 자바의 switch보다 좀 더 유용하다.
```
val english = "blue"
val korean : String

when(english) {
 "blue"-> korean = "파랑"
 "red"-> korean = "빨강"
 "pink"-> korean = "분홍"
 else -> korean = "없음"
}
println(korean) 
```
when에서는 객체의 비교 또한 가능하다.
```
data class Person(val name:String, val age:Int) // 생성자

val person = Person("Jeemin", 27)
when(person){
  Person("Irene", 20) -> print("The name is Irene")
  Person("Jeemin", 27) -> print("The name is Jeemin")
}
```
when에 아무 인자도 주어지지 않는 경우 if-else if 체인을 대체해 훨씬 깔끔한 코드를 만들 수 있다.
```
val x = 2
when {
 x.isOdd() -> print("x is odd")
 x.isEven() -> print("x is even")
 else -> print("x is funny")
}
```
when 또한 값을 반환한다
```
val x = (1..10).random()
val y - when {
 x in 1..5 -> x*2
 x in 6..10 -> x+100
 else -> 0
}
print(y)
```
### 예외
코틀린에서 모든 예외 클래스는 Throwable을 상속받는다. 예외를 던지기 위해서는 throw 구문을 사용하면 된다.
예외 처리를 위해서는 자바와 마찬가지로 try 구문을 사용한다.
catch 블록은 예외의 타입에 따라 여러 개를 사용할 수 있으며, finally 블록은 생략이 가능하다.
코틀린의 try 구문이 자바와 다른점은 각 블록의 마지막 표현식의 결과값을 반환한다는 것이다.
```val a:Int?= try { parseInt(input) }catch (e:NumberException) {null}```

코틀린에서는 checkedExcepion이 존재하지 않는다. 코틀린의 throw 구문은 표현식이기 때문에 엘비스 연산자를 뒤에 사용할 수 있다.
```val s = person.name ?: throw IllegalArgumentException("Name require")```

## 3. 널 안정성
코틀린에서는 널값을 가질 수 있는 객체와 널값을 가질 수 없는 객체의 타입이 분리되어 있다. 다음은 코틀린에서 NullPointerException 오류가 나는 상황이다.
- 명시적으로 throw NullPointerException() 호출
- !!연산자를 시용해 강제로 변환하는 경우
- 그 외 상속 관계에서의 특수한 경우 일부
- 자바와 혼용하는 경우

- 세이프콜
일반적으로 코틀린에서 널값을 가질 수 없지만, 널값을 가질 수 있는 객체를 선언하기 위해서는 타입 뒤에 ?를 붙여주면 된다.
```var b:String? =  "Kotlin"```
- !!연산자
!!연산자는 널값을 가질 수 있는 타입의 객체를 강제로 널값을 가질 수 없는 타입으로 변환해준다. 그 객체의 값이 널이엇다면 NPE를 발생시킨다.
```
val b:String?=null
val l = b!!.length //여기서 NPE발생
```
## 4. 범위 함수
let, apply, run, also, with 다섯 가지가 있다.
- let : 컨텍스트객체는 묵시적으로 it이 되며 마지막 표현식의 결과를 반환한다. it대신 명시적인 변수명을 사용할 수 있다
- apply: 컨텍스트 객체는 this가 되며 컨텍스트 객체 자신을 반환한다.
- run: 컨텍스트 객체는 this가 되며 마지막 표현식의 결과를 반환한다.
- also : 컨텍스트 객체는 it이 되며 컨텍스트 객체 자신을 반환한다.
- with : 컨텍스트 객체는 this가 되며 마지막 표현식의 결과를 반환한다. 함수의 인자로 객체가 필요하다는 점에서 run과 다르다.
```
Person("Alice", 20).let {
 println(it)
 it.moveTo("London")
 it.incrementAge()
 println(it)
}
```

### 5. 클래스와 프로퍼티
클래스 내부에 선언한 name이라는 변수는 자바에서 멤버변수라고 부르는 것과 달리 프로퍼티라고 부른다.
프로퍼티는 실제 값을 가지는 필드와 get, set 등의 접근자 함수로 이루어져 있다. 접근자 함수는 프로퍼티 선언 시 기본적으로 제공되며, 원하는 경우 커스텀 접근자 함수를 선언할 수 있다.
클래스에 함수가 없이 값만 필요한 경우 중괄호를 생략할 수도 있으며, 값만 가지는 클래스를 value object라고 부른다. 코틀린에서는 value object를 위한 키워드 data가 존재한다. 
클래스에 data를 붙이면 
- equals()
- toString()
- componentN() 

### 6. companion object
코틀린에서는 static 키워드가 존재하지 않는다. 대신 companion object {...} 블록 안에 정적 멤버들을 추가할 수 있다.

### 7. 싱글톤
싱글톤 객체를 만드는 방법은 private 생성자를 만들고 companion object에 객체를 반환하는 정적 함수를 만들어 사용하는 전통적인 방법도 있지만 코틀린에는 object 키워드를 이용하는 보다 간단한 방법이 존재한다.
object로 선언한 클래스는 선언과 함께 객체가 생성된다.

### 8. 고차함수와 람다
