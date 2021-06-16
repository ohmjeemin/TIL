##### 회원 엔티티

@Entity 애노테이션은 이 클래스가 데이터베이스 테이블에 맵핑된 정보를 가지고 있음을 의미한다.

@Id 애노테이션은 해당 필드가 이 테이블의 PK라는 것을 명시해준다.

@GeneratedValue(strategy = GenerationType.IDENTITY) 애노테이션은 MySQL에 PK 생성을 위임해 테이블에 새 데이터가 저장될 때 해당 필드가 자동으로 1씩 증가하여 유니크한 값을 넣어주도록 한다.

@PrePersist가 붙은 함수는 데이터베이스에 새 데이터가 저장되기 전에 자동으로 호출된다.

@PreUpdate 애노테이션은 **하이버네이트**가 자동으로 데이터베이스 테이블을 생성해주게 된다.



##### 레파지토리

Spring Data JPA는 Repository라는 레이어를 제공해 자바나 코틀린 문법으로 데이터베이스 쿼리를 수행할 수 있는 기능을 제공한다.

@Repository 애노테이션은 이 인터페이스가 스프링이 관리하는 레파지토리 빈으로서 동작한다는 것을 표시한다. 

JpaRepository를 상속받으면 레파지토리를 JPA 스펙에 맞게 확장하면서 기본적인 CRUD 함수를 제공할 수 있게 된다.



##### 회원가입 로직구현

SignupService.kt 생성

@Service 애노테이션은 이 클래스가 스프링이 관리하는 빈 클래스임을 나타내며 그 중에서도 비즈니스 로직을 처리하는 클래스라는 것을 표시한다.

@Autowired 애노테이션은 빈 클래스를 자동으로 주입받겠다는 것을 의미한다. 



##### Spring Data JPA 쿼리

Spring Data JPA에서는 레파지토리 인터페이스에 규칙에 맞는 간단한 함수를 정의하는 것만으로 쿼리를 대신해준다. 

- 일반적인 쿼리 함수 명명 규칙은 findBy + 필드명 + And + 필드명 형태이다.

- 각 필드명은 대문자로 시작해야 한다.

- 파라미터들은 필드와 동일한 타입으로 순서에 맞게 정의해준다.

- 함수의 반환타입은 검색했을 때 반환될 것으로 예상되는 데이터의 수에 따라 단일 엔티티나 엔티티 리스트를 기입해준다.

  

#### 회원가입 UI (Android)

##### MVVM 아키텍처 패턴

- UI를 조작하고 데이터를 가져오며 비즈니스 로직을 수행하는 코드의 복잡도를 줄임

- 역할을 분리해 유지보수성을 높임



##### MVVM 템플릿 라이브러리 - AnkoMVVM 사용

1. build.gradle에 추가

   ```
   allproject {
   	repositories {
   		google()
   		jcenter()
   		maven { url 'https://jitpack.io' }
   	}
   }
   ```

2. 안드로이드 라이프사이클 아키텍처 컴포넌트에서 코루틴을 사용할 수 있도록 ext {...} 블록에 해당 라이브러리의 버전을 선언해주고 의존성도 추가해주기

   ```
   ext {
   	arch_version = '2.2.0-alpha01'
   }
   dependecy {
   	...
   }
   ```



##### 기본 구성 클래스

AnkoMVVM 템플릿은 기본적으로 **Activity(Fragment)**, **ViewModel+UI** 의 구성을 한 세트로 가지고 있다.

1. BaseViewModel을 상속받은  SignupViewModel을 만들어 준다. 뷰모델은 뷰와 모델 간의 연결고리 역할을 한다. 
   MVVM에서는 뷰와 뷰모델이 가진 데이터의 바인딩을 자동화하기 위해 대부분의 데이터를 **Observable**이나 **LiveData** 등으로 선언하게 된다.
2. BaseActivity를 상속받는 SignupActivity를 생성해준다.



##### API 호출 준비

서버에서 개발해두었던 회원 가입 API 스펙에 맞게 파라미터로 쓰일 SignupRequest를 추가하고 ParayoApi에 API 함수를 선언한다.

```kotlin
@POST("/api/v1/users")
suspend fun signup(@Body signupRequest: SignupRequest) : ApiResponse<Void>
```

- @POST("/api/v1/users")는 해당하는 경로로 HTTP의 POST 메서드를 호출함을 의미한다.
- @BODY 애노테이션은 파라미텅의 값을 HTTP의 요청 본문에 쓰도록 지시한다. 이렇게 설정된 파라미터는 URI에 노출되지 않응므로 HTTPS를 이용한 암호화 통신을 통해 보안을 강화할 수 있다.

