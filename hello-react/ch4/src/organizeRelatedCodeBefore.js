import React, {useState, useEffect} from 'react';

function Profile({ userId }) {
    // 모든 상탯값을 함수 상단에서 정의하고 있다
    const [user, setUser] = useState(null);
    const [width, setWidth] = useState(window.innerWidth);
    // 모든 useEffect훅을 상탯값 코드 밑에 정의하고 있다.
    useEffect(() => {
        getUserApi(userId).then(data => setUser(data));
    }, [userId]);
    useEffect(() => {
        const onResize = () => setWidth(window.innerWidth);
        window.addEventListener("resize", onResize);
        return () => {
            window.removeEventListener("resize", onResize);
        };
    }, []);
    //...
}