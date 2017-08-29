import {Component, Input} from '@angular/core'

@Component({
    selector: 'order-processor',
    template: `<div class="text-left">
    <h2 class="bg-primary">Stock Information</h2>
    <h2 class="text-danger container">
    Buying {{quantity}} shares of {{stockSymbol}}
    </h2>
    <sms-text [stockSymbol]="stockSymbol"></sms-text>
    `
})
export class OrderComponent {
    @Input() quantity:number
    private _stockSymbol:string
    
    @Input()
    set stockSymbol(value: string){
        this._stockSymbol = value
        if(this._stockSymbol != undefined){
            (`Sending a Buy Order to NASDAQ:
             ${this._stockSymbol} ${this.quantity}
             `)
        }
    }

    get stockSymbol(): string{
        return this._stockSymbol;
    }

}