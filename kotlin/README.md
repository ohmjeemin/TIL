#### 코틀린

---

##### 코틀린 프로퍼티(210623)

```kotlin
public class Person {
	private final String name;
	private boolean isMarried;
	
	public Person(String name, boolean isMarried) {
		this.name = name;
		this.isMarried = isMarried;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setIsMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
}
```



**코틀린의 생성자**

자바에서는 데이터를 필드(field)에 저장한다. name과 isMarried라는 데이터를 Person 클래스의 필드에 저장한 것이다. 그리고 각 데이터마다 getter와 setter를 접근자라고 부른다. 이 접근자를 통해서 가시성이 private인 데이터들에 접근할 수 있다. 코틀린에서는 위의 코드가 많이 깨끗해진다.		

```kotlin
class Person(val name:String, var isMarried:Boolean)	
```



**코틀린의 접근자**

코틀린 클래스를 만들 때 생성자에 넣어준 데이터들에 대하여 get()과 set()이 숨겨져 있으므로, 아래처럼 명시적으로 적어줄 수 있다.

```kotlin
class Person {
	val name: Int
		get() {
			return this.age
		}
    var isMarried: Boolean
    	get() {
    		return this.isMarried
    	}
    	set() {
    		this.isMarried = isMarried
    	}
}
```



**생성자 val, var의 유무 차이 **

```kotlin
class Person(val name:String)
class Person(name:String)
```

val과 var가 있는 경우, 멤버변수로 변환된다. 즉 class Person(val name:String)의 경우, 아래 자바 코드로 변환된다.

```kotlin
public final class Person {
	private final String name;
	public final String getName() {
		return this.name;
	}
	public Person(String name){
		super();
		this.name = name;
	}
}
```



반면 class Person(name:String) 의 경우 아래의 자바 코드와 같다.

```kotlin
public final class Person {
	public Person(String name) {
		super();
	}
}
```



**주의할 점**

디컴파일한 자바 코드에서 필드가 private이라고 하여 코틀린의 프로퍼티도 private은 아니다. 즉, **필드와 프로퍼티를 다르게 인식할 줄 알아야 한다.** 자바는 기본적으로 필드를 다루고, 코틀린은 프로퍼티(필드+접근자)를 기본적으로 다룬다.

```kotlin
class Person(var name: String)
```

위 코드는 아래 코드가 된다.

```java
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

}
```

자바 필드인 name 자체만 보면 private 키워드가 붙어있으므로 private은 맞지만, 프로퍼티 전체를 보면 다르다. 필드는 private이지만 getter와 setter로 접근이 모두 가능하기 때문에 프로퍼티는 private하다고 볼 수 없다. 위의 코드에서 name 프로퍼티가 private이기 위해서는 아래와 같은 코틀린 코드가 필요하다.

```kotlin
class Person(private var name:String)
```

name 앞에 private이 붙었다. private이 붙지 않은 상태였어도 디컴파일한 자바 코드의 필드에는 private이 붙지만, 코틀린은 기본적으로 필드가 아닌 프로퍼티를 다루기 때문에 프로퍼티 전체가 private이 된다.     디컴파일된 자바 코드는 아래와 같다.

```java
public final class Property {
   private String name;

   public Property(@NotNull String name) {
      Intrinsics.checkParameterIsNotNull(name, "name");
      super();
      this.name = name;
   }
}
```

getter와 setter가 없어서 프로퍼티가 private라고 볼 수 있다.

- 코틀린에서 속성을 선언하면 자동으로 getter, setter 생성된다.

##### 표준 함수와 파일 입출력

let(), also(), apply(), run(), with(), use() 등을 사용할 수 있다. 그리고 람다식과 함수를 이용하면 사용자가 직접 정의한 언어인 DSL을 만들 수 있다.

- 람다식

  람다식은 항상 중괄호가 묶여 있으며 중과롷 안에 매개변수는 화살표 왼쪽에 배치되고 오른쪽에는 그에 따른 식을 구성한다.

  매개변숫가 1개인 경우, 매개변수를 생략하고 it으로 표기할 수 있다.

  만일 추론된 반환 자료형이 Unit이 아닌 경우에는 본문의 마지막 표현식이



210707

#### companion object 

companion object 안에 함수나 변수는 static 처럼 보이게 쓸 수 있다.

```kotlin
class Person {
    companion object {
        const val MAX_AGE: Int = 500
    }
}

fun main() {
    printf(Person.MAX_AGE)
}
```

class Person 내부에 companion object 라는 구문이 존재하고 해당 객체 내에 const val이 붙은 변수가 존재하게 된다. **const**가 붙은 이유는, MAX_AGE는 런타임이 아니라 **컴파일 타임**에 500이란 값으로 초기화되기 때문이다.

companion object도 하나의 객체이기 때문에 이름을 붙일 수가 있다. 

또한 companion object도 엄연히 하나의 객체이기 때문에 interface를 구현할 수 있다.

```kotlin
class Person {
	companion object:Movable {
		override fun move() {
			println("움직여")
		}
	}
}
fun main() {
	Person.move()
}
```



