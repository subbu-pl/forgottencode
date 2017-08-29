import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})
export class StartComponent implements OnInit {
  time:any;
  name:string="Subbu";
  buttonStatus:boolean=false;
  titleStyle='red';

  constructor() {
    window.setInterval(()=>{
      this.time=new Date().toString()
    },1000)
   }

  ngOnInit() {
    console.log("start component is initialized")
  }

  Save(event:any){
    console.log("saved the details")
    this.buttonStatus=true;
    this.titleStyle='';
  }

}
