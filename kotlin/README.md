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



#### 리스트 더하기...(210716)

코틀린은 list끼리 더하기가 된다.

```kotlin
fun main() {
   val list1 = listOf("지민", "지현")
   val list2 = listOf("규섭", "기율")
   val listResult = list1  + list2   
    listResult.forEach{li ->
    	print("$li ") // 결과 : 지민 지현 규섭 기율
    }
}
```



### 자료형

#### 값 비교 vs 참조 비교

이중 등호는 참조에 상관 없이 값이 동일하면 true, 값이 다르면 false를 반환한다. 삼중 등호는 값과 상관없이 참조가 동일하면 true를 반환한다. 값이 동일하더라도 참조 주소가 다르면 false를 반환한다. Int형으로 선언한 변수 a, b를 같은 값을 넣어 비교하니 true가 나온다. **코틀린 컴파일러가 기본형으로 변환하여 저장한다.** 참조 주소까지 달라지는 것은 null을 허용한 변수가 된다. 

```kotlin
val a:Int = 128
val b:Int? = 128
println(a==b) //true
println(a===b) //false
```

그 이유는 Int형으로 선언된 a는 기본형으로 변환되어 스택에 128이라는 값 자체를 저장한다. 하지만 Int?형으로 선언된 b는 참조형으로 저장되므로 b에는 128이 저장된 힙의 참조 주소가 저장되어 있다. 그래서 a와 b를 삼중 등호로 비교하면 false가 나온다. 

c와 d는 a에 들어 있는 값인 128이 저장되는 것이 아니라 서로 다른 128을 가리키고 있는 주소A1과 주소A2가 저장된다. 두 변수가 가리키는 값은 같으니 이중 등호로 비교하면 true가 나온다. 삼중 등호로 비교하면 두 변수의 참조 주소가 달라 false가 나온다. 

![image-20210718184736591](C:\Users\ohmje\AppData\Roaming\Typora\typora-user-images\image-20210718184736591.png)

(출처:do it kotlin)



#### 스마트 캐스트: Number

어떤 값이 정수일 수도 있고 실수일 수도 있다면, 컴파일러가 자동으로 형 변환을 하는 스마트 캐스트를 사용하면 더 편리하다. Number형이 대표적인 스마트 캐스트 자료형이다.  Number형으로 정의된 변수에는 저장되는 값에 따라 정수형이나 실수형 등으로 자료형이 변환된다. 

```kotlin
fun main(){
	var test: Number = 12.2
	println("$test")
	
	test = 12 //Int
	test = 120L //Long
	test += 12.0f //Float
}
```



#### 자료형 검사: is

변수의 자료형을 알아내는 방법에는 is 키워드가 있다. is는 왼쪽 항의 변수가 오른쪽 항의 자료형과 같으면 true를 아니면 false를 반환한다. 

```kotlin
fun main() {
	val num = 256
	if(num is Int) {
		println(num)
	}else if(num !is Int) {
		println("Not a Int")
	}
}
```



#### 자료형을 나중에 결정하는: Any 형 (210719)

Any형은 코틀린의 최상위 기본 클래스로 어떤 자료형이라도 될 수 있는 특수한 자료형이다. 이때 is를 사용하여 검사하면 검사한 자료형으로 **스마트 캐스트**된다.

```kotlin
val x: Any
x = "Hello"
if(x is String) {
	print(x.length)
}
```

```kotlin
fun main() {
    var a:Any = 1
    a = 20L
    println("a: $a type: ${a.javaClass}")
}
```

초기화할 때 1로 한거지 Any 타입이기 때문에 20L을 대입했을 때 Long이 된다. 

#### 가변 인자를 위한: vararg

```kotlin
fun getArgs(vararg names:String){
    for(name in names){
        print(name)
    }
}

fun main() {
    getArgs("지민", "지현", "규섭", "기율")
}
```



#### 함수형 프로그래밍

코틀린은 함수형 프로그래밍과 객체 지향 프로그래밍을 모두 지원하는 언어이다. 함수형 프로그래밍이란 순수 함수를 작성하여 프로그램의 부작용을 줄이는 프로그래밍 기법이다. 함수형 프로그래밍에서는람다식과 고차 함수를 사용한다. 

**순수함수** : 같은 인자에 대하여 항상 같은 결과를 반환하고, 함수 외부의 어떤 상태도 바꾸지 않는 함수

**람다 식** : 함수형 프로그래밍의 람다식은 다른 함수의 인자로 넘기는 함수, 함수의 결괏값으로 반환하는 함수, 변수에 저장하는 함수를 말한다. 

**일급객체** : 함수형 프로그래밍에서는 함수를 일급 객체로 생각한다. 람다식 역시 일급 객체의 특징을 가지고 있다. 일급 객체란

- 함수의 인자로 전달할 수 있다
- 함수의 반환값에 사용할 수 있다
- 변수에 담을 수 있다

만약 함수가 일급 객체면 일급 함수이다.

**고차함수** : 다른 함수를 인자로 사용하거나 함수를 결괏값으로 반환하는 함수

#### 람다식

코틀린에서 값에 의한 호출은 함수가 또 다른 함수의 인자로 전달될 경우 람다식 함수는 값으로 처리되어 그 즉시 함수가 수행된 후 값을 전달한다. 

```kotlin
fun main() {
    val result = callByValue(lambda())
    println(result)
}
fun callByValue(b:Boolean): Boolean {
    println("callByValue function")
    return b
}

val lambda: () -> Boolean = {
    println("lambda function")
    true
}
```

난 callByValue function -> lambda funtiton -> true일 줄 알았는데, 인자에 있는 람다식 함수는 값으로 처리되어 그 즉시 함수가 수행된 후 값을 전달한다. 그래서 lambda function 먼저 출력된다.

#### 람다식이 아닌 일반 함수를 또 다른 함수의 인자에서 호출하는 방법 ::



##### 회사 Factory 코드

template을 사용할 때 `Factory.html(template)` 으로 호출한다. Factory를 살펴보면 object로 되어있다. 어떻게 그렇게 호출이 가능하냐면 object로 클래스를 선언하면 싱글톤 객체로 만들기 때문에 실제로 INTSTANCE라는 static 변수를 만들어 자기 자신을 생성해서 넣는다. 그치만 INSTANCE는 생략이 가능하기 때문에 Factory.INSTANCE.html("".."") 을 Factory.html("...")로 object 안에 있는 메소드를 호출할 수 있다.

```kotlin
object Factory {
	fun html(v:String):suspend()->HTMLElement = { elementFromHTML(v) }
}
```



회사 eView 

```kotlin
class eView<T> protected constructor(internal val factory:(suspend:(suspend ()->T)?){

}))
```



### entity에서 데이터 함수 만들기

내가 필요한 값은 주문 품목을 출력하면서 해당 originalItem의 state와(여러개를 주문했다면 states)와 그에 해당하는 qty이다. 

작성된 함수는 data.originalItems를 돌면서 저 함수를 호출하도록 한다. 함수의 결과값은 String과 Int로 이루어진 Pair의 리스트이다. 여기서 String은 state가 될 것이며 qty는 해당 상태에 속하는 수량이 될 것 이다. 

groups를 돌면서 group하나씩의 items의 orderRowId가 일치하는 item을 갖고 있는  group을 모두 찾는다. 

위에서 필터링된 groups를 map에서 EnumOrderGroupCat.values() 하면 orderGroupCat 리스트를 만든다. 이 리스트 중에서 r이랑 방금 필터링된 group의 orderGroupCatRowid를 찾고 그것의 titleKor를 뽑는다. 그리고 groupd의 items을 count하는데 it.orderOrginalItemRowid랑 originalItem.orderOriginalItemRowid가 같은 걸 센다!!!!!! 

```kotlin
fun originItemState(originItem:EntOriginalItem):List<Pair<String?, Int>>{
    return groups.filter {group->
        group.items.any { gItem->
            gItem.orderOriginalItemRowid == originItem.orderOriginalItemRowid
        }
    }.map{group->
        (EnumOrderGroupCat.values().find{group.orderGroupCatRowid == it.r}?.titleKor) to
                group.items.count { it.orderOriginalItemRowid == originItem.orderOriginalItemRowid }
    }
}
```

### 리스트 내의 요소들을 꺼내서 사용할 때
*를 통해 해당 리스트를 꺼낸 후, toTypedArray() 메소드를 사용한다.
![image](https://user-images.githubusercontent.com/44112843/139089464-79bfbe9e-6afa-4c03-82f9-6549d8a0ad6a.png)


