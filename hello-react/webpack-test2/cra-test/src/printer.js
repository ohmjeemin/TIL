import React, { useEffect, useState } from 'react';

function WidthPrinter() {
    const [width, setWidth] = useState(window.innerWidth);
    useEffect(() => {
        const onResize = () => setWidth(window.innerWidth);
        window.addEventListener('resize', onResize);
        return() => {
            window.removeEventListener('resize', onResize);
        };
    }, []);
    return <div>{`{width is ${width}`}</div>;
}