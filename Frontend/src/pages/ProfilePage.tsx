import {useEffect, useState} from 'react'
import NavBar from "../components/NavBar";
import ProfilePageCard from "../components/ProfilePageCard";
import TokenManager from '../API/TokenManager';
import GetUserApi from '../API/GetUserAPI';

function ProfilePage(){
    
    const [claims, setClaims] = useState(TokenManager.getClaims());
    const [userDetails, setUserDetails] = useState();

    
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
    useEffect(() => {
        getUserDetails();
      }, [claims]);


    console.log(userDetails);

    return (
        <>
        <body className="bg-gray-300">
        <NavBar />
        <div className="grid h-screen grid-cols-3">
            <div></div>

            <div className="my-5">
                <ProfilePageCard userDetails={userDetails}/>
            </div>
        </div>
        </body>
        </>
    )
}

export default ProfilePage;