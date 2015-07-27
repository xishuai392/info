var user = {
    userName : "ddddddd",
    pwd : "123243242"
};
var userName = "我是全局名称";
function outer(outerArg0) {
    var outerVar = 10;
    with (user) {
        function inner(innerArg0) {
            var innerVar = 20;
            alert(userName + "-----" + this.userName + "-----" + pwd);
            alert(outerArg0 + "-----" + outerVar + "-----" + innerVar);
        }
    }
    inner(2);
    alert(outerVar);
}
outer(11);