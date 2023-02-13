import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loading =false;
  credentials={
    username:'',
    password:''
  }

  constructor(private loginService:LoginService, private router:Router) { }

  errorMessage:String=null;
  isError=false;
  isDisabled=false;

  ngOnInit(): void {

  }



  async onSubmit(){
    if((this.credentials.username!=null && this.credentials.password!=null)&& (this.credentials.username!='' && this.credentials.password!='')){
      
      this.loading=true;
      await this.loginService.generateToken(this.credentials).subscribe(
        (response:any)=>{
          
          this.loading=false;
          this.loginService.loginUser(response.token,response.userName);
          
          window.location.href="/dashboard";
        },
        error=>{
         
          this.loading=false;
          this.isError=true;
          this.errorMessage="Invalid Username Or Password";
        }
      );
      
    }
    else{
   
    }
  }

  closeError(){
    this.isError=false;
  }

}
