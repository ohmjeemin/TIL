// 속성값의 타입 정의
MyComponent.protoTypes = {
    //...
}

// 컴포넌트 함수의 매개변수는 명명된 매개변수로 정의하기
export default function MyComponent({prop1, prop2}) {
    //...
}

// 컴포넌트 바깥의 변수와 함수
const COLUMNS = [
    { id:1, name: 'phoneNumber', width: 200, color: 'white' },
    { id:1, name: 'phoneNumber', width: 200, color: 'white' }
    //...
];
const URL_PRODUCT_LIST = '/api/products';
function getTotalPrice({ price, total }) {
    //...
}

