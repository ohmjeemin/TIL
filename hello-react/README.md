# 1. Error

### 1. 문제: 첫 화면 다음에 질문지 페이지가 나와야 하는데 안나오고 바로 다음 페이지로 이동함..

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bd2380d6-0718-48e7-9186-56621412d272/Untitled.png)

첫 화면

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/acaa25ce-fec1-4f7f-8f33-9551b779c806/Untitled.png)

결과 화면

콘솔창에 다음과 같은 에러가 떴다.

→ 컴포넌트를 업데이트 할수 없다. 다른 컴포넌트('Research')를 렌더링하면서. . setState() 호출을 'Research' 안에 위치하기 위해서는, 다음 무슨무슨 링크에 있는 걸 확인해라.. 대충 이런.. 내용일까?

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2a816e63-78ae-442a-b70b-0d8d40ccfc7e/Untitled.png)

### 2. 원인: 컴포넌트 렌더링 하는 동안 함수를 호출했기 때문

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6969a626-0e48-422b-83e1-d656de10d76b/Untitled.png)

### 3. 해결방안: 화살표 함수를 통해 parameter를 지나가게 해라..

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/08e4be8c-657f-4f61-8c33-65c699e9c790/Untitled.png)

---

### 참고한 공식 문서

[Passing Functions to Components - React](https://reactjs.org/docs/faq-functions.html#why-is-my-function-being-called-every-time-the-component-renders)
