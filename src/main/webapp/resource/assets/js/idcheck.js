
    let req = new XMLHttpRequest();
    req.onload = () => {
    let obj = JSON.parse(req.responseText);
    console.log(obj.toString())
    let txt = "중복된 아이디";
    if(obj.flag){
    txt = "사용가능한 아이디";
    }
    document.getElementById("res").innerHTML = txt;
    console.log("작동");
}
    const a = () => {
    console.log("작동2");
    let username = document.getElementById("username").value;
    req.open("get", "/signup/idcheck.do?username="+username);
    req.send();
}