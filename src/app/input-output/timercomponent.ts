import { Component }      from '@angular/core';

@Component({
    selector: 'timer-comp',
    template: `
    <h2 style='background-color:black;color:yellow'>
    {{time}}
    </h2>
    `     
})

export class TimerComponent {
    time:any;   
    constructor() {
        window.setInterval(() => {
                this.time=new Date().toString();
        },1000);
    }
}