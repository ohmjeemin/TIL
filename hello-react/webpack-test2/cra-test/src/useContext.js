import React from 'react';

const UserContext = React.createContext();
const user = { name: 'mike', age: 23 };

function ParentComponent() {
    return (
        <UserContext.Provider value={user}>
            <ChildComponent/>
        </UserContext.Provider>
    );
}
function ParentComponent2() {
    return (
        <UserContext.Provider value={user}>
            <ChildComponent/>
        </UserContext.Provider>
    );
}
function ChildComponent() {
    return (
        <div>
            <UserContext.Consumer>
                {user => (
                    <>
                    <p>{`name is ${user.name}`}</p>
                    <p>{`name is ${user.name}`}</p>
                    </>
                )}
            </UserContext.Consumer>
        </div>
    );
}