var userName = "ddddddd";
function outer(outerArg0) {
    var outerVar = 10;
    function inner(innerArg0) {
        var innerVar = 20;
        alert(outerArg0 + "-----" + outerVar + "-----" + innerVar + "-----" + this.userName);
    }
    inner(2);
    alert(outerVar);
}
outer(11);