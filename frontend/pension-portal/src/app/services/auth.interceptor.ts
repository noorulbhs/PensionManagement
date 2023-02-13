import { HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor{
    constructor(private loginService:LoginService){}
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let newreq=req;
        let token=this.loginService.getToken();
         if(token!=null){
            
            newreq.clone({headers:new HttpHeaders({'Authorization':`Bearer ${token}`})})
            console.log(newreq);
            
        }
        return next.handle(newreq);
    }
    
}