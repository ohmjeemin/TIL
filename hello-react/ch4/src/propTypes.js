import React from 'react';
import PropTypes from 'prop-types';

User.propTypes = {
    male: PropTypes.bool.isRequired,
    age: PropTypes.number,
    type: PropTypes.oneOf(["gold", "silver", "bronze"]),
    onChangeName: PropTypes.func,
    onChangeTitle: PropTypes.func.isRequired
}

function User({type, age, male, onChangeName, onChangeTitle}) {
    function onClick1() {
        const msg = `type: ${type}, age: ${age ? age : "알 수 없음"}`;
        log(msg, {color: type==="gold"? "red" : "black"});
    }
    function onClick2() {
        if(onChangeName) {
            onChangeName(name);
        }
        onChangeTitle(title);
        male? goMalePage(): goFemalePage();
    }
}

MyComponent.propTypes= {
    age: function(props, propName, componentName) {
        const value = props[propName];
        if(value < 10 || value > 20) {
            return new Error(
                `Invalid prop ${propName} supplied to ${componentName}
                It must be 10 <= value <=20`
            );
        }
    }
};
