import React, { useState, useEffect } from 'react';

export function MyComponent() {
    const [count, setCount] = useState(0);
    useEffect(() => {
        document.title = `업데이트 횟수:${count}`;
    });
    return <button onClick={() => setCount(count +1)}>increase</button>
}

function MyComponent2() {
    const [count1, setCount1] = useState(0);
    const [count2, setCount2] = useState(0);
    function onClick() {
        setCount1(count1 + 1);
        setCount2(count2 + 1);
    }
    const result = count1 >= count2;
}

export function Profile() {
    const [state, setState] = useState({ name: '', age: '' });
    return (
        <div>
            <p>{`name is ${state.name}`}</p>
            <p>{`age is ${state.age}`}</p>
            <input type="text"
                   value={state.name}
                   onChange={e => setState({name: e.target.value })}
            />
            <input type="text"
                   value={state.age}
                   onChange={e => setState({age: e.target.value })}
            />
        </div>
    );
}

function Profile2({ userId }) {
    const [user, setUser] = useState(null);
    useEffect(
        () => {
            getUserApi(userId).then(data => setUser(data));
        },
        [userId],
    );
    return (
        <div>
            {!user && <p>사용자 정보를 가져오는 중...</p>}
            {user && (
                <>
                    <p>{`name is ${user.name}`}</p>
                    <p>{`age is ${user.age}`}</p>
                </>
            )}
        </div>
    );
}
