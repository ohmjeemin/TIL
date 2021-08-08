//2-64: Promise를 생성하는 방법
// const p1 = new Promise((resolve, reject) => {
//     resolve(data)
//     //or reject('error message
// });
// const p2 = Promise.reject('error message');
// const p3 = Promise.resolve(param);


//2-65: Promise.resolve의 반환값
const p1 = Promise.resolve(123);
console.log(p1 !== 123); //true

const p2 = new Promise(resolve => setTimeout(() => resolve(10),1));
console.log(Promise.resolve(p2) === p2);

//2-66: then메서드를 사용한 간단한 코드
requestData().then(onResolve, onReject);
Promise.resolve(123).then(data => console.log(date)); // 123
Promise.reject('err').then(null, error => console.log(error)); //에러 발생

//2-69: 같은 기능을 하는 then 메서드와 catch 메서드
Promise.reject(1).then(null, error => {
    console.log(error);
});
Promise.reject(1).catch(error => {
    console.log(error);
});

//2-76: 병렬로 실행되는 코드
requestData1().then(data => console.log(data));
requestData2().then(data => console.log(data));
//2-77: Promise.all을 사용하는 코드
Promise.all([requestData1(), requestData2()]).then(([data1, data2]) => {
  console.log(data1, data2);
});