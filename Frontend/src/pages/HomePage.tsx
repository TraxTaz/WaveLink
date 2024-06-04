import { useEffect, useState } from "react"
import GetUserApi from "../API/GetUserAPI"
import TokenManager from "../API/TokenManager"
import NavBar from "../components/NavBar"
import Post from "../components/Post"
import PostFormCreation from "../components/PostFormCreation"
import ProfileCard from "../components/ProfileCard"

function HomePage(){
    
    const [claims, setClaims] = useState(TokenManager.getClaims());
    const [userDetails, setUserDetails] = useState(null);

    
    const getUserDetails = () =>{
        const claims = TokenManager.getClaims();
        if (claims?.role === 'user' && claims?.userID){
            console.log("Id", claims.userID);
            
            GetUserApi.getUser(claims.userID)
            .then(user => {
                setUserDetails(user)
            })
            .catch(error => console.log(error));
        }
    }

    const logout = () =>{
        location.href = "/";
        TokenManager.clear();
        setClaims(null);
        setUserDetails(null);
    }

    useEffect(() => {
        getUserDetails();
      }, [claims]);
      

    return <>
    {claims ? (
        <>
            <NavBar logout={logout} />
            <div className="grid h-screen gap-4 grid-cols-3">
                <div className="my-3">
                    <ProfileCard userDetails={userDetails}/>
                </div>
                <div className="grow my-4">
                    <PostFormCreation />
                    <Post />
                </div>
                <div className="bg-purple-500">

                </div>
            </div>
        </>
    ) : (
        <div className="flex flex-col justify-center items-center h-screen">
            <h1 className="text-4xl">Access denied</h1>
        </div>
    )}
</>
}

export default HomePage