// 단축 속성명
// const name = 'mike';
// const age = 21;
// console.log('name=', name, 'age=', age);
// console.log({name, age})

//개선된 속성명
function makeObject1(key, value) {
    const obj = {};
    obj[key] = value;
    return obj;
}
function makeObject2(key, value) {
    return { [key]: value };
}

//ㅁ전개 연산자
//1. 동적으로 매개변수 전달
Math.max(1,3,7,9); // 동적으로 매개변수를 전달할 수 없다.

const numbers = [1,3,7,9]; // 이렇게 매개변수 수가 증가해도 사용 가능하다.
Math.max(...numbers);

//apply를 통해서도 동적으로 함수의 매개변수를 입력할 수 있다
const numbs = [-1, 5, 11, 3];
Math.max.apply(null, numbers);
//===========================================
//2. 전개 연산자를 이용해서 배열과 객체를 복사하기
// const arr1 = [1,2,3];
// const obj1 = {age:23, name:'mike'};
// const arr2 = [...arr1];
// const obj2 = {...obj1};
// arr2.push(4);
// obj2.age = 80;
//===========================================
//3. 전개 연산자를 이용해서 두 객체를 병합하기
const obj1 = {age:21, name:'mike'};
const obj2 = {hobby:'soccer'};
const obj3 = {...obj1, ...obj2};
console.log(obj3);
// 중복 속성명이 허용된다.

//ㅁ배열 비구조화
//배열의 여러 속성값을 변수로 쉽게 할당할 수 있는 문법
//2-28:배열 비구조화의 간단한 예
// const arr = [1,2];
// const [a,b] = arr;
// console.log(a);
// console.log(b);
//2-29:배열 비구조화로 이미 존재하는 변수에 값을 할당하기
// let a,b;
// [a,b] = [1,2];
//2-33: 나머지 값을 별도의 배열로 만들기
const arr = [1,2,3];
const [first, ...rest1] = arr;
console.log(rest1);
const [a,b,c, ...rest2] = arr;
console.log(rest2);

//ㅁ객체 비구조화
//객체의 여러 속성값을 변수로 쉽게 할당할 수 있는 문법
//2-34: 객체 비구조화의 간단한 예
// const obj = {age:21, name:'mike'}
// const {age, name} = obj;
// console.log(age);
// console.log(name);
//2-37: 객체 비구조화에서의 기본값
// const obj = { age: undefined, name: null, grade: 'A'};
// const { age = 0, name = 'noName', grade = 'F' } = obj;
// console.log(age);
// console.log(name); //속성값이 null이면 기본값이 들어가지 않는다!!
// console.log(grade);
//2-38: 기본값과 별칭 동시에 사용하기
// const obj = { age: undefined, name: 'mike' };
// const { age: theAge = 0, name } = obj;
// console.log(theAge);
//2-39: 기본값으로 함수의 반환값을 넣을 수 있다.
// function getDefaultAge() {
//     console.log('hello');
//     return 0;
// }
// const obj = { age: 21, grade: 'A' };
// const { age = getDefaultAge(), grade } = obj;
// console.log(age);
//2-40: 객체 비구조화에서 나머지 속성들을 별도의 객체로 생성하기
// const obj = { age: 21, name: 'mike', grade: 'A' };
// const { age, ...rest } = obj;
// console.log(rest);
//2-41: for문에서 객체 비구조화를 활용한 예
const people = [{ age:21, name: 'mike' }, { age: 51, name: 'sara' }];
for (const { age, name } of people) {
    console.log(age, name);
}
//ㅁ 비구조화에서 기본값의 정의는 변수로 한정되지 않는다.
//2-43: 기본값은 변수 단위가 아니라 패턴 단위로 적용된다
const [{ prop: x } = { prop: 123  }] = [];
console.log(x);
const [{ prop: x } = { prop: 123 }] = [{}];
console.log(x);