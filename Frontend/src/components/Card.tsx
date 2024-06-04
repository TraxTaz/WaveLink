import { ReactNode } from "react";

type CardProps = {
    children: ReactNode;
}

function Card({children} : CardProps){
    return (
        <>
        <div className="bg-white shadow-sm shadow-gray-500 rounded-md p-4 mb-5">
            {children}
        </div>
        </>
    )
}

export default Card;