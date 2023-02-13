import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';
import { UserServiceService } from 'src/app/services/user-service.service';


export interface PeriodicElement {
  name: string;
  adhaarNumber: number;
  panNumber: number;
  dateOfBirth: Date;
  salaryEarned:number;
  allowances:number;
  sumOfFamilyPension:string;
  bankName:string;
  accountNumber:number;
  bankType:string;
}


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  displayedColumns: string[] = ['AdhaarNumber', 'Name', 'DOB', 'PanNumber','SalaryEarned','Allowances','SumOfFamilyPension','BankName','AccountNumber','BankType'];
  dataSource:PeriodicElement[]= [];
  isDataPresent=false;
  adhaarNumber:number=null;
  errorMessage:String=null;
  isModalShow=false;
  isShowDetail=false;
  isError=false;

  isSaveModal=false;
  saveMessage:String=null;

  
  loading=false;

  processPensionDetail={
    bankServiceCharge:null,
    pensionAmount:null
  }


  constructor(private userService:UserServiceService, private loginService:LoginService) { }

  ngOnInit(): void {
    let expiryTime=30*60*1000;
        setTimeout(()=>{          
          this.loginService.logOut();
          window.location.href="/login"
        },expiryTime);
  }

  async getPensionerDetail(){
    await this.userService.getPensionerDetail(this.adhaarNumber).subscribe(
      (users:any)=>{
        this.loading=false;
        this.dataSource=[];
        this.isDataPresent=true;
        this.dataSource=[users.content];
      },
      error=>{
        this.loading=false;
       
        
      }
    )
  }
  

  async getDetail(){
    this.loading=true;
  await  this.userService.getProcessPension(this.adhaarNumber).subscribe(
      (res:any)=>{

        if(res.content!=null && res.content!=undefined){

          this.isError = false;

           this.isModalShow=true;

           this.processPensionDetail = res.content;

        }

        if(res.error_msg!=null && res.error_msg!=undefined){

          this.isError = true;
          this.errorMessage = res.error_msg;

        }


        this.loading=false;
        
      },
      err=>{

        this.loading=false;
        this.isError=true;
 

      }
    )
  }

  showDetail(){
    this.loading=true;
    this.getPensionerDetail();
    this.isShowDetail=true;

  }


  async saveDetail(){
    this.loading=true;
    await this.userService.saveDetail(this.adhaarNumber).subscribe(
      res=>{
        this.loading=false;
        this.saveMessage="Detail save Successfully";
        this.isSaveModal=true;
      },
      err=>{
        // console.log(err);
        this.loading=false;
        this.saveMessage="Detail save Successfully";
        this.isSaveModal=true;
      }
    )
  }

  closeModal(){
    this.isModalShow=false;
    this.adhaarNumber=null;
  }

  closeDetail(){
    this.isShowDetail=false;
  }
  
  closeSaveModal(){
    this.isModalShow=false;
    this.adhaarNumber=null;
    this.isSaveModal=false;
  }

  closeError(){
    this.isError=false;
  }

}
