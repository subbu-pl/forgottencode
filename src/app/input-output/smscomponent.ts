import {Component,Input} from '@angular/core';

@Component({
    selector:'sms-text',
    template:`
    <h3 class="bg-success">     
      Stock Information from child SMS component</h3>
    <h2 class="text-success container">
        Sent SMS about {{stockSymbol}} 
    </h2>
    `
})
export class SMSComponent{
    private _stockSymbol:string;
    @Input()
    set stockSymbol(value:string){
       this._stockSymbol=value;
    }
    get stockSymbol():string{
       return this._stockSymbol;
    }
}