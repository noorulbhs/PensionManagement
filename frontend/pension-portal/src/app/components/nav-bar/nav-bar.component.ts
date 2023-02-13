import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit{
  public isLoggedIn=false;

  constructor(private loginService:LoginService,private router:Router) { }

  ngOnInit(): void {
    this.isLoggedIn=this.loginService.isLoggedIn();
  }

  logOutUser(){
    this.loginService.logOut();
    window.location.href="/login";
  }

}
