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

  

### 095  확장 함수의 리시버 타입이 상속 관계에 있을 때

```kotlin
open class AA
class BB:AA()

//AA, BB에 확장함수 hello 주입
fun AA.hello() = println("AAA")
fun BB.hello() = println("BBB")

fun main(args:Array<String>){
    //타입은AA이나 실제로 BB를 가리키는 test 참조변수 선언
    val test:AA = BB()
    test.hello() // 확장함수는 참조변수의 타입을 그대로 따른다.
}
```

확장 함수는 멤버 함수와는 다르게 참조 변수가 실제로 가리키는 객체의 타입을 따르지 않고, 참조 변수의 타입을 그대로 따른다.



### 099 중첩 클래스(nested class)

클래스 안에는 또 다른 클래스를 선언할 수 있다.

```kotlin
class Outer {
    class Nested {
        fun hello() = println("중첩된 클래스")
    }
}

fun main(args:Array<String>) {
    val instance:Outer.Nested = Outer.Nested()
    instance.hello()
}
```

- 중첩 클래스는 타입 이름이 {바깥 클래스}.{중첩 클래스}로 만들어진다. 생성자 이름도 마찬가지이다. 
- Nested 클래스는 Nested라는 식별자만 Outer 클래스에 속해있을 뿐, 실제로 완전히 분리된 장소에 있다. 따라서 Nested 클래스의 멤버 함수는 Outer 클래스의 프로퍼티나 멤버 함수에 접근할 수 없다.

### 100 내부 클래스 (Inner class)

중첩 클래스는 단순히 식별자만 바깥 클래스에 속해있는 것이라면, 내부 클래스는 인스턴스가 바깥 클래스의 인스턴스에 완전히 소속된다.

```kotlin
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
```

