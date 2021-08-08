// 2.3.1 매개변수에 추가된 기능
// 매개변수 기본값을 줄 수 있다.
//2-46: 함수 매개변수에 기본값을 줄 수 있다
// function printLog(a=1) {
//     console.log({a});
// }
// printLog();
//2-47: 매개변수 기본값으로 함수 호출 사용
// function getDefault() {
//     return 1;
// }
// function printLog(a=getDefault()) {
//     console.log({a});
// }
// printLog();
//=====================
//나머지 매개변수
//2-49: 나머지 매개변수를 사용한 코드
function printLog(a, ...rest) {
    console.log({a, rest});
}
printLog(1, 2, 3);
