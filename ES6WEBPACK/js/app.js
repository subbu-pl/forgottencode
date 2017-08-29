/* let company='Verizon'
console.log('Welcome to '+ company)
////////////////////////////////////////////////
var x=10;
function show(){
    var y=20;
    if(true){
        var z=30;
    }
    console.log(z);
}
show();
////////////////////////////////////////////////
let a=10
function show(){
    let b=20
    if(true){
        let c=30
    }
    console.log(c)
}
show()
////////////////////////////////////////////////
const x=10
const x='subbu'
let sum=(x,y)=>{
    return(x+y)
}
console.log(sum(5,6))*/
////////////////////////////////////////////////
/* let company='Verizon'
let template=`
    <h1 style="backgroud-color:black;color:yellow">
Welcome to ${company}
</h1>
`
document.write(template) */
class Student{
    constructor(name,age){
        this.name =name;
        this._age=age;
    }
    
    ShowName(){
        return this.name;
    }
    assignName(name){
        this.name =name;
    }
    set age(value){
        console.log("Somebody spoiled age")
        this._age = value;
    }
    get age(){
        return this._age;
    }
}
    let s1=new Student('subbu',70)
    console.log(s1.ShowName())
    s1.age = 30
    console.log(s1.age)

    class Person extends Student{
        constructor(name,age,citizen){
            super(name,age)
            this.citizen =citizen;
        }
       getCitizen(){
           return this.citizen
       } 
       showName(){
       return "sub Class - "+ super.ShowName()
       }
    }
    let p1=new Person('subbu1',60,'Indian')
    let s2=new Student('subbu2',80)
    s2.age=20
    console.log(s2.age);
    console.log(p1.showName());