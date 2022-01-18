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



2.미들웨어

미들웨어(middleware)는 리듀서가 액션을 처리하기 전에 실행되는 함수

디버깅 목적의 로그 출력, 리듀서에서 발생한 예외를 서버에 전송하는 등 목적으로 미들웨어 활용할 수 있다.

리덕스 사용 시 특별히 미들웨어를 설정하지 않았다면 발생한 액션을 곧바로 리듀서로 보내진다.

**미들웨어의 기본 구조**

`const myMiddleware = store => next => action => next(action);`

→ 미들웨어는 함수 세 개가 중첩된 구조로 되어 있다.

```jsx
const myMiddleware = function(store) {
	return function(next) {
		return function(action) {
			return next(action);
		};
	};
};
```



리듀서(reducer)는 액션이 발생했을 때 새로운 상탯값을 만드는 함수

**리듀서의 구조**

```
(state, action) => nextState
```

리듀서 함수의 작성 예

```jsx
function reducer(state = INITIAL_STATE, action) {
	switch(action.type) {
		....
		case REMOVE_ALL:
			return {
				...state, // 전개연산자를 사용하여 상탯값을 불변 객체로 관리
				todos: [],
			};
		case REMOVE:
			return {
				...state,
				todos: [],
			};
		default: return state;
	}
}

const INITIAL_STATE = { todos: [] };
```



3. 리덕스

리덕스는 스토어를 생성할 때 상탯값이 없는 상태로 리듀서를 호출하기 때문에 매개변수의 기본값을 사용해서 초기 상탯값을 정의한다. `INITIAL_STATE`

각 액션 타입별로 case문을 만들어서 처리한다.

상탯값은 불변 객체로 관리해야 하므로, 수정할 때마다 새로운 객체를 생성한다. 전개 연산자를 사용하면 상탯값을 불변 객체로 관리할 수 있다.

[전개 연산자](https://www.notion.so/a970c6a4b8ec4b05b2b94f39f520b612)

처리할 액션이 없다면 상탯값을 변경하지 않는다.

자바스크립트에서 불변 객체를 관리할 목적으로 나온 패키지중 하나인 **이머 패키지**

- 이머를 사용해서 리듀서 작성하기

→ 이머를 사용해서 불변 객체를 관리하는 예

```jsx
import produce from 'immer';

const person =  { name: 'mike', age: 22 }
const newPerson = produce(person, draft => {
	draft.age = 32;
});
```

draft 매개변수는 person 객체라고 생각하고 코드를 작성하면된다.

draft.age를 수정해도 person 객체의 값은 변경되지 않는다!

draft 객체를 수정하면 produce 함수가 새로운 객체를 반환한다.

이머를 사용해서 리듀서 함수 작성하기

```jsx
function reducer(state = INITIIAL_STATE, action){
	return produce(state, draft => {  //스위치문 전체를 produce로 감싼다
		switch(action.type) {
			case ADD:
				draft.todos.push(action.todo);  
		//이머를 사용했기 때문에 배열의 push 메서드를 사용해도 기존 상탯값은 수정되지 않고
		//새로운 객체가 생성된다.
				break;
			case REMOVE_ALL:
				draft.todos = [];
				break;
			case REMOVE:
				draft.todos = draft.todos.filter(todo => todo.id !== action.id);
				break;
		}
	});
}
```

리듀서 작성 시 주의할 점 : 순수함수



4. 스토어

스토어는 리덕스의 상탯값을 가지는 객체다.

액션의 발생은 스토어의 dispatch 메서드로 시작된다.

스토어는 액션이 발생하면 미드웨어 함수를 실행하고, 리듀서를 실행해서 상탯값을 새로운 값으로 변경한다.

그리고 사전에 등록된 모든 이벤트 처리 함수에게 액션의 처리가 끝났음을 알린다.

스토어는 하나만 만드는 게 좋다.

