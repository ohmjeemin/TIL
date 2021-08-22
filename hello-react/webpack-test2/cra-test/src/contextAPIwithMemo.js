import React, { useState } from 'react';
const UserContext = React.createContext('');

export function User() {
    const [username, setUsername]= useState("");
    return (
        <div>
            <UserContext.Provider value={username}>
                <Profile/>
            </UserContext.Provider>
            <input
                type="text"
                value={username}
                onChange={e => setUsername(e.target.value)}
            />
        </div>
    );
}
export const Profile = React.memo(() => {
    return (
        <div>
            <Greeting/>
        </div>
    );
});

export function Greeting() {
    return (
        <UserContext.Consumer>
            {username => <p>{`${username}님 안녕하세요~~`}</p>}
        </UserContext.Consumer>
        );
}
