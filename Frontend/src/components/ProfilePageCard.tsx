import Card from "../components/Card";
import ProfileAvatar from "../components/ProfileAvatar";
import { Link } from "react-router-dom";
import Post from "./Post";
import { useEffect, useState } from "react";

function ProfilePageCard({userDetails}){

    const [username, setUsername] = useState(' ');
    const [bio, setBio] = useState('');
    useEffect(() =>{
        if (userDetails && userDetails.userName){
            setUsername(userDetails.userName);
        }
        else if(userDetails && userDetails.bio){
            setBio(userDetails.bio);
        }
    })

    if (bio == ""){
        setBio("No bio")
    }


    return (
        <>
        <Card>
            <div className="relative">
                <div className="absolute top-2 left-2">
                    <ProfileAvatar />
                </div>
                <div className="p-4 pb-0">
                    <div className="ml-12">
                        <h1 className="ml-4 text-3xl font-bold">{username}</h1>
                        <div className="ml-4 text-gray-500 leading-4">
                            {bio}
                        </div>
                    </div>
                    <div className="mt-10 flex gap-1">
                        <Link to={"#"} className="flex gap-1 px-4 py-1 items-center border-blue-500 border-b-4 text-blue-800 font-bold text-blue-500">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" className="w-6 h-6">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M19.5 14.25v-2.625a3.375 3.375 0 00-3.375-3.375h-1.5A1.125 1.125 0 0113.5 7.125v-1.5a3.375 3.375 0 00-3.375-3.375H8.25m0 12.75h7.5m-7.5 3H12M10.5 2.25H5.625c-.621 0-1.125.504-1.125 1.125v17.25c0 .621.504 1.125 1.125 1.125h12.75c.621 0 1.125-.504 1.125-1.125V11.25a9 9 0 00-9-9z" />
                        </svg>
                            Posts
                        </Link>
                        <Link to={"#"} className="flex gap-1 px-4 py-1 items-center border-b-4 border-b-white">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-6 h-6">
                        <path fillRule="evenodd" d="M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12zm8.706-1.442c1.146-.573 2.437.463 2.126 1.706l-.709 2.836.042-.02a.75.75 0 01.67 1.34l-.04.022c-1.147.573-2.438-.463-2.127-1.706l.71-2.836-.042.02a.75.75 0 11-.671-1.34l.041-.022zM12 9a.75.75 0 100-1.5.75.75 0 000 1.5z" clipRule="evenodd" />
                        </svg>
                            About
                        </Link>
                        <Link to={"#"} className="flex gap-1 px-4 py-1 items-center border-b-4 border-b-white">
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="w-6 h-6">
                        <path d="M4.5 6.375a4.125 4.125 0 118.25 0 4.125 4.125 0 01-8.25 0zM14.25 8.625a3.375 3.375 0 116.75 0 3.375 3.375 0 01-6.75 0zM1.5 19.125a7.125 7.125 0 0114.25 0v.003l-.001.119a.75.75 0 01-.363.63 13.067 13.067 0 01-6.761 1.873c-2.472 0-4.786-.684-6.76-1.873a.75.75 0 01-.364-.63l-.001-.122zM17.25 19.128l-.001.144a2.25 2.25 0 01-.233.96 10.088 10.088 0 005.06-1.01.75.75 0 00.42-.643 4.875 4.875 0 00-6.957-4.611 8.586 8.586 0 011.71 5.157v.003z" />
                        </svg>
                            Followers
                        </Link>
                    </div>
                </div>
            </div>
        </Card>
        <div>
            <Post />
        </div>
        </>
    )
}

export default ProfilePageCard;