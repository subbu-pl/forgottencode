import { Component } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';

@Component({
    selector: 'app-DI',
    //providers:[ProductService],
    templateUrl: './product.component.html',
    styles:[`
        .one {background-color:orange}
        .tab {padding:10px; margin:15px;cursor:pointer}
        .panel {background-color:lightgreen}
    `]
})
export class ProductComponent{
    product: Product;
    constructor(ps:ProductService){
        console.log("Service is injected")
        this.product = ps.getProduct();
    }
}