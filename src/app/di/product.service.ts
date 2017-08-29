import {Injectable} from '@angular/core';
import {Product} from './product';

@Injectable()
export class ProductService{
    getProduct():Product{
        return new Product(
            1,"Iphone 8",1248.99,"Iphone phone"
        );
    }
}