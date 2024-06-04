import userApi from '../API/userAPI'
import AccountSignIn from '../components/accountSignup'


function SignUpPage(){

    const adduser = (userName: any, password: any) =>{
        userApi.post(userName, password)
        .then(result => alert("Account created successfully"))
        .catch(error => {
            console.log(error)
            console.log(error.response.data)
            if (error.response.status == 400 || error.response.status == 401){
                alert("Username already exists")
            }
            else{
                alert("something went wrong")
            }
        })
    }

    return (
        <AccountSignIn adduser = {adduser} />
    )

}


export default SignUpPage;