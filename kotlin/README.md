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





###### companion object (210707)

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



###### inline 함수 (210708)

```kotlin
fun doSomething(body: () -> Unit) {
	body()
} 
fun callFunction(){
    doSomething{ print("문자열 출력") }
}
```

이 함수를 자바로 표현한다면

```java
public void doSomething(Function body) {
	body.invoke();
}
public void callFunction(){
	doSomething(System.out.println("문자열 출력"));
}
```

위 코드는 아래와 같이 변환하게 된다.

```java
public void callFunction() {
	doSomething(new Function() {
		@Override
		public void invoke() {
			System.out.println("문자열 출력")
		}
	});
}
```

문제는 위 sum이나 minus처럼 조합하는 함수가 많아질수록 계속 N개만큼 function 오브젝트가 생성된다. 이럴 때 사용하는 것이 **inline** 키워드이다. 

```kotlin
inline fun doSomething(body: ()-> Unit) {
	body()
}
fun callFunction() {
	doSomething{ print("문자열 출력!") }
}
```

위 코드는 아래와 같이 변환된다.

```java
public void callingFuntion() {
	System.out.print("문자열 출력")
}
```

위와 같이 Function 인스턴스를 만들지 않고 callingFuntion 내부에 삽입되어 바로 선언되게 된다. 때문에 람다 함수와 1급 함수가 호출된 곳에서 해당 함수를 가지게 된다. 하지만 inline 함수는 주의할 점이 있는데 private 키워드를 사용해 함수를 정의할 수 없다. 다신 다른 접근 제한자인 internal을 사용해야 한다.



#### object와 class 키워드 (210702)

코틀린에서 클래스 키워드를 정의하는 키워드는 class이다. 간혹 object 키워드로 클래스를 정의하는 경우도 있다. object 클래스를 정의하면 Singleton 패턴이 적용되어 객체가 한번만 생성되도록 한다.  자바에서는 Singleton 패턴을 적용하기 위해 형식적인 코드(boilerplate)를 작성해야 했다. 싱글턴을 사용하는 방법 외에도, object는 익명객체를 생성할 때도 사용된다.

**object 키워드 사용하는 경우**

- Singleton 클래스로 만들 때
- 익명 클래스 객체를 만들 때



**1. Singleton으로 사용하는 경우**

```kotlin
object CarFactory {
	val cars = mutableListOf<Car>()
	fun makeCar(horsepowers:Int):Car {
		val car = Car(horsepowers)
		cars.add(car)
		return car
	}
}

class Car(power:Int) {}
```

우리는 이제 `CarFactory.makeCar`에 접근하여 Car 객체를 생성할 수도 있고, `CarFactory.cars`처럼 직접 변수에 접근할 수도 있다. CarFactory 객체는 Singleton으로 구현이 되었기 때문에 여러번 호출해도 CarFactory 객체는 한번만 생성이 된다.

마치 static 메소드를 호출하는 것 처럼 보이지만, 자바로 어떻게 변환되는 지를 확인하면 싱글턴이 내부적으로 어떻게 구현되는 지 이해할 수 있다.



**java로 변환된 코드**

```java
public final static CarFactory {
    private static final List cars;
    public static final CarFactory INSTANCE; //생성
    public final List getCars(){ 
        return cars; 
    }
    public final Car makeCar(int horsepowers) {
        Car car = new Car(horsepowers);
        cars.add(car);
        return car;
    }
    static {
        CarFactory var0 = new CarFactory();
        INSTANCE = var0;
        cars = (List)(new ArrayList());
    }
}
public static final void main(@NotNull String[] args) {
   Intrinsics.checkParameterIsNotNull(args, "args");
   Car car = CarFactory.INSTANCE.makeCar(150);  // 여기!!! INSTANCE를 통해 접근
   int var2 = CarFactory.INSTANCE.getCars().size();
   System.out.println(var2);
}
```

CarFactory.INSTANCE는 static으로 생성되기 때문에 프로그램이 로딩될 때 생성이 된다. 그래서 쓰레드 안전성이 보장되지만, 내부적으로는 공유자원을 사용하는 경우 쓰레드 안전성이 보장되지 않기 때문에 동기화 코드를 작성해야 한다.

클래스 안에 Factory 패턴을 정의하고 싶다면, Factory를 companion object로 정의해주면 된다. 사실 **Car.Factory.makeCar()**로 호출해주는 것이 명시적으로 정확한 표현이지만, 코틀린은 편의를 위해 Factory를 생략할 수 있다.

![image-20210712233022407](C:\Users\ohmje\AppData\Roaming\Typora\typora-user-images\image-20210712233022407.png)



**2. 익명객체로 사용한 예**

익명객체는 이름이 없는 객체로, 한번만 사용되고 재사용되지 않을 때 사용한다. 

```kotlin
interface Vehicle {
	fun drive(): String
}
fun start(vehicle:Vehicle) = println(vehicle.drive())
```

```kotlin
start(object:Vehicle {
	override fun drive() = "Driving really fast"
})
```

-> start() 인자로 전달되는 object: Vehicle {...}은 익명객체이다. 이 익명객체는 Vehicle 인터페이스를 상속받은 클래스를 객체로 생성된 것을 의미한다. 익명객체이기 때문에 클래스 이름은 없고 구현부는 {...} 안에 정의해야 한다.



#### lateinit, lazy (210703)

lateinit 키워드는 늦은 초기화라고 부른다. var 키워드를 사용한 경우에만 lateinit을 사용할 수 있다. 그리고 primitive type에는 적용할 수 없다. 또한 getter&setter를 정의할 수 없다.

lazy 키워드는 var를 사용할 수 없고, val을 사용하는 경우에만 가능하다. val 선언 뒤 by lazy 블록에서 초기화에 필요한 코드를 작성한다. 호출 시점에서 최초 1회 초기화가 된다. 



#### 405 error (210704)

http 메소드가 잘못돼서 나는 오류이다. 나는 POSTmapping이 필요했는데 서버에서 @GetMapping 어노테이션을 사용하고 있었다.



#### 함수의 매개변수가 람다식 (210715)

람다식을 인자나 반환 값으로 사용할 수 있는데, 이 개념을 고차 함수라고 한다. 아래는 selectWarehouseOpen 함수의 매개변수로 blockAdd 함수를 받고 있다. 그 람다는 warehouse를 인자로 받고 있고 리턴이 없는 함수이다. 

```kotlin
suspend fun selectWarehouseOpen(blockAdd:(warehouse:EntApiWarehouseResult.Warehouse)->Unit) {
	selectWarehouseEV.entity(EntOpen().also {
        it.blockAddd = blockAdd
    })
}
```

내가 프로젝트에서 진행하고 있는 창고 선택 모달 오픈하는 함수인데, selectWarehouseOpen하면서 blockAdd 람다를 인자로 받고, selectWarehouseEV 뷰에 EntOpen()이라는 엔티티에 받은 blockAdd를 넣어서 보낸다. 그럼 뷰 안에 addEntityHook에서 해당 모달이 오픈할 때 필요한 로직들을 적어주면 된다.

![image-20210715235716281](C:\Users\ohmje\AppData\Roaming\Typora\typora-user-images\image-20210715235716281.png)
