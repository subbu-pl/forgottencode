interface IBank{
    show():void
}

interface IEmp{
    showDetails():void
}

class Company{
    constructor(){
        console.log("I am Company Super Class")
    }
    Cname(){
        console.log("Company: Subbu")
    }
}

class Emp extends Company implements IBank,IEmp{
    constructor(public ename:string,public salary:number){
        super()
        this.ename=ename
        this.salary=salary
    }
    show(){
        console.log("I am Verizon") 
    }
    showDetails(){
        super.Cname()
        console.log("Name: "+this.ename+",Salary: "+this.salary)
        this.show()
    }
}

var emp:IEmp=new Emp("Subbu",7000)
emp.showDetails()