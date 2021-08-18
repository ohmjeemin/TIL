import React from 'react';

export function Todo({ title, desc}) { // Todo 컴포넌트는 Title 컴포넌트를 자식으로 사용
    const [priority, setPriority] = useState("high");
    function onClick() {
        setPriority(priority === "high" ? "low" : "high"); // 버튼을 클릭하면 priority 상태값이 변경되고 화면을 다시 그린다.
    }
    return (
        <div>
            <Title title={title} />
            <p>{desc}</p>
            <p>{priority === "high" ? "우선순위 높음" : "우선순위 낮음"}</p>
            <button onClick={onClick}>우선순위 변경</button>
        </div>
    );
}

const Title = React.memo(({ title }) => { // React.memo로 만들어진 Title 컴포넌트는 속성값이 변경될 때만 호출한다.
    return <p style={{ color: "blue" }}>{title}</p>
});

// ReactDOM.render (
//     <Todo title="리액트 공부하기" desc="실전 리액트 프로그래밍을 열심히 읽는다"/>
//     document.getElementById("root");
// )


