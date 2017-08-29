import {
    Component,
    Input,
    OnInit,OnChanges,DoCheck,OnDestroy
} from '@angular/core';

@Component({
    selector: 'app-lifecycle',
    template:`
    <h1 class="container">Google Search:
    <input type="text" [(ngModel)]="search">
    </h1>
    <child [search]="search"></child>
    `
})
export class CompLifeCycleComponent{
    search: string="Computers";
}

//child Component
@Component({
    selector: 'child',
    template:`
    <h1 class="text-danger container">Search Text</h1>
    <div class="well"> 
    <h3 class="text-primary">{{search}}</h3>
    </div>
    `
})
export class ChildComponent implements OnInit,OnChanges,DoCheck,OnDestroy{
    @Input() search: string;
    //Search isnt initialized yet
    constructor(){
        console.log(`constructor:${this.search}`);
    }
    ngOnInit(){
        console.log(`ngOnInit:${this.search}`);
    }
    ngOnChanges(){
        console.log(`ngOnChange:${this.search}`);
    }
    ngDoCheck(){
        //write custom change
        console.log("ngDoCheck- Change detection strategy");
    }
    ngOnDestroy(){
        //Remove the Component state here
        console.log("Component Destroy");
    }
}