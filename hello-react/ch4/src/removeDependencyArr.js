import React, {useState, useEffect} from 'react';

//간단한 조건부 렌더링
function Profile({ userId }) {
    const [user, setUser] = useState();
    async function fetchAndSetUser(needDetail) {
        const data = await fetchUser(userId, needDetail);
        setUser(data);
    }
    useEffect(() => {
        
    })
}