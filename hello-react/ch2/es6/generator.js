function* f1() {
    yield 10;
    yield 20;
    return 'finished';
}
// const gen = f1();

//2-109 제너레이터 객체의 return 메서드 호출하기
// const gen = f1();
// console.log(gen.next());
// console.log(gen.return('abc')); // return  메서드를 호출하면 데이터 객체의 done 속성은 참이 된다
// console.log(gen.next());

//2-110 제너레이터 객체의 throw 메서드 호출하기
function* f2() {
    try {
        console.log('f1-1');
        yield 10;
        console.log('f1-2');
        yield 20;
    }catch(e) {
        console.log('f1-catch', e);
    }
}
const gen2 = f2();
// console.log(gen2.next());
// console.log(gen2.throw('some error'));

//2-112 제너레이터 객체는 반복 가능한 객체다
console.log(gen2[Symbol.iterator]() === gen2);

//2-113 반복 가능한 객체를 이용하는 코드
function* f3() {
    yield 10;
    yield 20;
    yield 30;
}
for (const v of f3()) {
    console.log(v);
}
const arr = [...f1()];
console.log(arr);

//2-114
function* map(iter, mapper) {
    for(const v of iter) {
        yield mapper(v);
    }
}
