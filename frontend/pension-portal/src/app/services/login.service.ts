import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  url="http://gateway844744-env.eba-enwpqv8r.us-east-1.elasticbeanstalk.com";
  constructor(private http:HttpClient) { }

  generateToken(credentials:any){
        
    return this.http.post(`${this.url}/login`,credentials);
  }


  loginUser(token,userName){
    
    localStorage.setItem("token",token);
    localStorage.setItem("userName",userName);
    return true;
  }

  isLoggedIn(){
    let token=localStorage.getItem("token");
    if(token!=null && token!=undefined && token!=''){
      return true;
    }else{
      return false;
    }
  }

  logOut(){
    localStorage.removeItem("token");
    localStorage.removeItem("userName");
    return true;
  }

  getToken(){
    return localStorage.getItem("token");
  }
  
  getUserName(){
    return localStorage.getItem("userName");
  }
}
