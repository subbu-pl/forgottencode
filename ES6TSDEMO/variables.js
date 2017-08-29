var Demo = (function () {
    function Demo() {
        this.num_val = 13;
        this.age = 30;
    }
    Demo.prototype.storNum = function () {
        var local_num = 14;
    };
    Demo.prototype.getAge = function () { console.log(this.age); };
    Demo.sval = 10;
    return Demo;
}());
console.log("Staic dta " + Demo.sval);
var obj = new Demo();
console.log("Instance value of num: " + obj.num_val);
obj.getAge();
