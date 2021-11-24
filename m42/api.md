### 복잡한 api 구현 - feat 이사님 

**커먼 엔티티, 제이슨, 서비스 함수 리스트까지 만든 상태에서**

1. **컨트롤러**부터 만들어 놓는다

- 파일업로드 부분이라 아래와 같은 코드가 필요하다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4fc089f2-c034-4dfb-908d-c6e4f47577ed/Untitled.png)

- 멀티 파트에서는 data로도 보낼 수 있고, 파일도 보낼 수 있다.
- 우리는 data에 {} 빈 객체를 보낼 것이고, upfile에 파일을 올릴 것이다.
- `R.file("upfile")` 하면 upfile 키에 맞는 데이터를 가져온다.
- file내에 문자열을 읽기 위해 `String(file.bytes, StandardCharsets.UTF_8)` 이라는 코드를 사용하였다.
- json을 맵핑할 entity를 만들었다.
- `eEntity.parse(request, json)` json을 가지고 엔티티에 담았다.

1. 여기서 내가 헷갈렸던 부분인데, **컨트롤러가 작동하는지를 먼저 만든다**.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a49135c1-39bf-4295-b284-5423fcee584c/Untitled.png)

1. 난 파일업로드를 하기위해 json을 적은 파일을 하나 만들었다. 그리고 postman 에서 테스트를 해보았다. 포스트맨에서 파일업로드 테스트를 하기 위한 방법은 다음과 같다.

   - 평소 raw에 직접 key, value값을 적어서 send 했다면
   - 파일업로드는 form-data라는 걸 클릭해서 내가 아까 받기로한 data와 upfile을 키에 담는다.
   - data는 빈 객체를 주기로 했고, upfile은 file을 받는 키이다. type을 file로 받았다.

   ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/88240cb1-a50d-4eb7-b404-8647c0415dd4/Untitled.png)

2. 결과가 제대로 왔으면 이제 서비스 함수를 짜면 된다.

   ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6852c55b-6e54-4828-9bfb-9a6eacca86a7/Untitled.png)

3. 서비스 함수를 짜기 전에, 복잡한 로직이기 때문에 무엇을 체크할지를 생각하는게 좋다.

   - clientName이 유효한지
   - companyName이 유효한지
   - billingId가 유효한지
   - deliveryServiceR이 유효한지
   - 날짜 범위가 startDate < endDate 인지

4. 그리고 최대한 있는 서비스 함수를 만든다.

   나는 companyR과 companyBillingR이 필요해서 각각 eQuery로 만들었는데, 이사님은 최대한 있는걸 쓰고, 없다면 서비스 함수를 만들어서 쓰라고 하셨다.

5. 그리고 여러 테이블에 삽입할 것이기 때문에, 트랜잭션을 이용해서 쓴다.

   ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8db07249-188c-4ab1-bac6-3af5e5c93ae6/Untitled.png)

   - 삽입 전에 같은 게 있는지 체크한다.
