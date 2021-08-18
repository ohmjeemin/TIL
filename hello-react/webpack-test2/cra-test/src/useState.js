import React,  { useState } from 'react';
function MyComponent() {
    const [count, setCount] = useState({ value: 0 });
    function onClick() {
        setCount({ value: count.value + 1 });
        setCount({ value: count.value + 1 });
    }
    console.log("render called");
    return (
        <div>
            <h2>{count.value}</h2>
            <button onClick={onClick}>증가</button>
        </div>
    );
}