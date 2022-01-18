### 1. 리덕스

- 하나의 객체에 프로그램의 전체 상탯값을 저장한다

리덕스를 사용하면 하나의 객체를 직렬화(serialize)해서 서버와 클라이언트가 프로그램의 전체 상탯값을 서로 주고받을 수 있다.

- 상탯값을 불변 객체로 관리한다

상탯값은 오직 액션에 의해서만 변경되어야 한다

```jsx
const incrementAction = {
	type: 'INCREMENT',    //액션 객체는 type 속성값이 존재해야 한다. 
		                  //type 속성값으로 액션 객체를 구분한다
	amount: 123    //type 속성값을 제외한 나머지는 상탯값을 수정하기 위해 사용되는 정보
};
const conditionalIncrementAction = { 
	type: 'CONDITIONAL_INCREMENT',
	amount: 2,
	gt: 10,
	lt: 100
};
store.dispatch(incrementAction);    //액션 객체와 함께 dispatch 메서드를 호출하면 상태값이 변경된다.
store.dispatch(conditionIncrementAction);
```

리덕스의 상탯값을 수정하는 방법 → 액션 객체와 함께 dispatch 메서드를 호출하는 것이다.

상탯값은 dispatch 메서드가 호출된 순서대로 리덕스 내부에서 변경됨.

- 오직 순수 함수에 의해서만 상탯값을 변경해야 한다.

리덕스에서 상탯값을 변경하는 함수를 리듀서(reducer)라고 부른다

리듀서의 구조 `(state, action)=>nextState`

리듀서는 이전 상탯값과 액션 객체를 입력으로 받아서 새로운 상탯값을 만드는 순수 함수다.

순수 함수는 부수 효과를 발생시키지 않아야 한다.



#### 리덕스의 주요 개념 이해하기

1. 액션

   - 액션(action)은 type 속성값을 가진 자바스크립트 객체다.
   - 액션 객체에는 type 속성값 외에도 원하는 속성값을 얼마든지 넣을 수 있다.
   - 각 액션은 고유한 type 속성값을 사용해야한다.
   - 속성값을 강제하기 위해 dispatch 메서드를 호출할 때 직접 액션 객체를 입력하는 방법을 사용하지 않는게 좋다.

   🍅 **액션 생성자 함수 사용하여 속성값 강제화**

   ```jsx
   export const ADD = 'todo/ADD'; //액션 타입은 변수로 만들어 관리한다
   function addTodo({title, priority}) {
   	return { type: ADD, title, priority };
   }
   store.dispatch(addTodo({ title: '영화 보기', priority: 'high' }));
   ```

