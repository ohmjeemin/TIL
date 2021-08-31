## 091 const

val 변수 앞에 const 키워드를 붙이면 변수에 접근하는 코드를 변수에 저장된 값으로 대체시킨다.

const 키워드는 전역 변수, 오브젝트의 프로퍼티 등에 붙을 수 있다. const가 붙은 변수에는 리터럴로 이루어진 표현식만 저장이 가능하다.

```kotlin
const val hello  = "Hello" + "World!"

object Foo {
    const val bar = "bar"
}

fun main(args:Array<String>) {
    println(hello)
    println(Foo.bar)
    println(hello)
    println(Foo.bar)
}
```

위 코드는 컴파일 되면 이렇게 대체된다.

```kotlin
println("Hello World!")
println("bar")
println("Hello World!")
println("bar")
```



### 상수와 리터럴

상수는 값을 한번만 저장할 수 있는 공간, 리터럴은 그 자체로 값을 의미

## 092 lateinit

클래스의 프로퍼티는 선언과 동시에 초기화하거나 init블록 안에서 반드시 초기화해주어야 한다.

Int나 String이라면 0이나 ""로 초기화하면 되지만, 사용자 정의 클래스라면 lateinit 키워드를 통해 나중에 초기화할 수 있다. 

lateinit 키워드는 var프로퍼티에만 붙을 수 있다.

## 093 Nullable 리시버

확장 함수를 응용하면, 참조 변수에 null이 지정되어 있어도 함수 호출이 가능하게 할 수 있다.

- ?. 연산자 = nullable

```kotlin
fun String?.isNumber() {
    if(this==null){
        println("문자열이 null입니다")
    }
}
```

```kotlin
fun main(args:Array<String>){
    val empty:String?=null
    empty.isNumber()
}
```



## 094 companion object의 확장함수

확장 함수를 companion object에도 추가할 수 있다.

```kotlin
fun 클래스 이름.Companion.함수이름() { ... }
```

```kotlin
class Member { companion object }
fun Member.Companion.create() = Member()

fun main(args:Array<String>) {
    Member.create()
} 
```

- 동반자 객체도 내용이 비어있으면 중괄호를 생략할 수 있다.
