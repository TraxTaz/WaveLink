import { useState, useEffect } from 'react';
import LoginApi from '../API/loginAPI';
import LoginUser from "../components/login"
import TokenManager from '../API/TokenManager';

function LoginPage(){

    const [claims, setClaims] = useState(TokenManager.getClaims());

    const handleLogin = async (username : string, password : string) => {
        try {
            const claims = await LoginApi.login(username, password);
            setClaims(claims);
            location.href = "/Home";
          } catch (error) {
            alert("Login Failed!");
            console.error(error);
          }
    }

    return <LoginUser login={handleLogin} />
}


export default LoginPage;