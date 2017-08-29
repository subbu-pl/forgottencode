class Demo{
    num_val:any=13;
    private age:number=30;
    static sval:number=10;
    storNum():void{
        var local_num:number=14;
    }
    getAge():void{console.log(this.age)}
    }

    console.log("Staic dta "+Demo.sval);
    var obj = new Demo();
    console.log("Instance value of num: "+obj.num_val);
    obj.getAge();