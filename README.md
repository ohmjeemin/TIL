# TIL

### 코틀린으로 쇼핑몰 앱 만들기 (21/06/03 ~)
<ol> 함수와 변수</ol>
**함수**<br>
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

**변수**
```
var c:Int = 3
var d = 4
```
변수 선언은 val과 var로 시작하며, 변수명: 타입 순서로 이루어진다. 변수 선언과 동시에 값을 초기화하는 경우 타입을 생략할 수 있다. 값을 초기화하지 않는 경우 타입을 반드시 명시해주어야 한다. 
- 가변 변수와 불변 변수 <br>
**var** <br>초기화 이후에도 값을 변경할 수 있다.
**val** <br>한 번 초기화되면 이후 값을 변경할 수 없다.

**if-else문**
<br>
코틀린의 if-else문은 각 분기의 마지막 표현식의 결과값을 반환한다.
```
val dollor = 4
val class = if(dollor>=4) {
  "부자"
} else {
  "안부자"
}
```
**when문**
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

```


