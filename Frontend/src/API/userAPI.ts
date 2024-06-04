import axios from 'axios'

const userApi = {
    post: (userName : string , password : string) => axios.post("http://localhost:8080/users", {userName, password}),
    get: () => axios.get("http://localhost:8080/users")
    .then(response => response.data.users)
}

export default userApi;