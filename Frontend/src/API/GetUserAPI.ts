import axios from "axios";
import TokenManager from "./TokenManager";

const GetUserApi = {
    getUser: (userID : any) => axios.get(`http://localhost:8080/users/${userID}`,
    {
        headers: { Authorization: `Bearer ${TokenManager.getAccessToken()}`}
    })
    .then(response => response.data)
}

export default GetUserApi;

