import { Component, ViewChild } from '@angular/core';
import { ViewChildComponent } from './child.component';

@Component({
    selector: 'app-viewchild',
    template:`
    <div>
        <h1>Parent Component</h1>
            <button (click)="showHideText()">
            Show/Hide Child Component Test
        </button>
        <div class="container" style="background:yellow">
            <child-component></child-component>
        </div>
    </div>
    `
})
export class ParentComponent{
   @ViewChild(ViewChildComponent) private cc:ViewChildComponent;

   showHideText(){
       this.cc.toggleVisibility('Parent Component');
   }
}