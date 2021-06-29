#### 확장함수

코틀린에서는 변경 불가능한 클래스를 확장하여 새로운 함수를 추가할 수 있다. 상속과는 다른 느낌으로 원래 그 클래스가 제공하는 것 처럼 사용 가능하다.

#### 생성자

코틀린에는 하나의 주생성자를 가질 수 있고,  여러 개의 부생성자가 있다. 아래와 같이 클래스 선언 옆에서 해주면 주생성자이다. constructor가 어노테이션이나 접근 제한자를 가지고 있지 않다면 constructor를 생략할 수 있다. 

```kotlin
class Person(val name:String, val age:Int) // 가능
class Person constructor(val name:String, val age:Int) // 가능
```



- 코틀린 생성자에 constructor 키워드를 생략할 수 없는 경우

![image-20210629235552631](C:\Users\ohmje\AppData\Roaming\Typora\typora-user-images\image-20210629235552631.png)

생성자가 private이 붙으니 에러가 나는 것을 볼 수 있다. 이 때 접근 제한자 뒤에 constructor를 붙이면 에러가 사라지는 것을 확인할 수 있다.

![image-20210629235730544](C:\Users\ohmje\AppData\Roaming\Typora\typora-user-images\image-20210629235730544.png)





코틀린은 두번째 생성자도 가질 수 있다. 이 때 사용되는 키워드는 constructor이고, primary constructor와 다르게 생략할 수 없다. Animal 이라는 클래스 안에 부 생성자를 만들어 보았다. 근데 생성자에 val이 불가하다는 에러가 난다.

![image-20210629234947061](C:\Users\ohmje\AppData\Roaming\Typora\typora-user-images\image-20210629234947061.png)

