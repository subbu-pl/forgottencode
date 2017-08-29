import {Component} from '@angular/core'

@Component({
    selector: 'app-stock',
    template: `<div class="text-left">
    <h1 class="bg-info">Stock Exchange</h1>
    <input type="text"
    placeholder="Enter stock(e.g: Verizon"
    (change)="onInputEvent($event)">
    <br/>
    <order-processor [stockSymbol]="stock" quantity="100">
    </order-processor>
    </div>
    <timer-comp></timer-comp>
    `
})

export class StockComponent{
    stock:string;
    onInputEvent({target}:any):void{
        this.stock=target.value;
    }
}