import React, {useEffect, useState} from 'react';


//부수효과 함수를 async await 함수로 만든 것
function Profile({ userId }) {
    const [user, setUser] = useState();
    useEffect(async()=>{
        const data = await fetchUser(userId);
        setUser(data);
    }, [userId]);
}

//useEffect 훅에서 async await 함수 사용하가
function Profile2({ userId }) {
    const [user, setUser] = useState();
    useEffect(() => {
      async function fetchAndSetUser() {
          const data = await fetchUser(userId);
          setUser(data);
      }
      fetchAndSetUser();
    }, [userId]) ;
}