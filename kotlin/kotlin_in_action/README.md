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



