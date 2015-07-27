//函数总是在定义它的作用域中运行的，而不是在执行它们的作用域里运行
var name = "global";
function testName() {
    alert(name);
    alert(this.name);
    alert(window.name);
    alert("分割");
    var name = "local";
    alert(name);
    alert(this.name);
    alert(window.name);
}
testName();