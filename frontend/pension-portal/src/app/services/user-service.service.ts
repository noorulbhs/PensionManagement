import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  baseUrl="http://gateway844744-env.eba-enwpqv8r.us-east-1.elasticbeanstalk.com";
  baseUrlProcess="http://gateway844744-env.eba-enwpqv8r.us-east-1.elasticbeanstalk.com";
  constructor(private http:HttpClient) { }

  getPensionerDetail(adhaarNumber:number){
   let token=localStorage.getItem('token');
   return this.http.get(`${this.baseUrl}/pensioner-detail/${adhaarNumber}`,
                      {headers:new HttpHeaders({'Authorization':`Bearer ${token}`})}
                      );

  }


  getProcessPension(adhaarNumber:number){
    let token=localStorage.getItem('token');
    
    return this.http.post(`${this.baseUrlProcess}/process-pension`,adhaarNumber,
    {headers:new HttpHeaders({'Authorization':`Bearer ${token}`,'Content-Type':'application/json'})});
  }

  saveDetail(adhaarNumber:number){
    let token=localStorage.getItem('token');
    return this.http.get(`${this.baseUrlProcess}/process-pension/${adhaarNumber}/save`,
                              {headers:new HttpHeaders({'Authorization':`Bearer ${token}`})}
                          );
  }

}
