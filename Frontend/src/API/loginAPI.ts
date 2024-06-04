import axios from 'axios'
import { LoginResponse } from '../Types/LoginResponse'
import TokenManager from './TokenManager';

class LoginApi {
    async login(username: string, password: string): Promise<LoginResponse> {
        const response = await axios.post<LoginResponse>("http://localhost:8080/tokens", { username, password });
        
        const accessToken = response.data.token;
        TokenManager.setAccessToken(accessToken);
        
        return response.data;
    }
  }

export default new LoginApi();