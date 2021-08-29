import React, {useState, useEffect} from 'react';

// 각 기능을 커스텀 훅으로 분리!
function Profile({ userId }) {
    const user = useUser(userId);
    const width = useWindowWidth();
}
// 커스텀 훅1
function useUser(userId) {
    const [user, setUser] = useState(null);
    useEffect(() => {
        getUserApi(userId).then(data => setUser(data));
    }, [userId]);
    return user;
}
// 커스텀 훅2
function useWindowWidth() {
    const [width, setWidth] = useState(window.innerWidth);
    useEffect(() => {
        const onResize = () => setWidth(window.innerWidth);
        window.addEventListener("resize", onResize);
        return () => {
            window.removeEventListener("resize", onResize);
        };
    }, []);
    return width;
}