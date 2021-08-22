import React, { useState } from 'react';
const UserContext = React.createContext({ username:"", helloCount:0 });
const SetUserContext = React.createContext('dark');

export function User() {
    return (
        <div>
            <ThemeContext.Provier value="light">
                <UserContext.Provider value="jimni">
                    <div>상단 메뉴</div>
                    <Profile/>
                    <div>하단 메뉴</div>
                </UserContext.Provider>
            </ThemeContext.Provier>
        </div>
    );
}
function Profile() {
    return (
        <div>
            <Greeting/>
        </div>
    );
}

export function Greeting() {
    return (
        <ThemeContext.Consumer>
            {theme => (
                <UserContext.Consumer>
                    {username => (
                        <p
                        style={{ color: theme === 'dark' ? 'gray' : 'green' }}
                        >{`${username}님 안녕하세요`}</p>
                    )}
                </UserContext.Consumer>
                )}
        </ThemeContext.Consumer>
        );
}
