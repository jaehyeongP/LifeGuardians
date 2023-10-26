let req = new XMLHttpRequest();
req.onload = () => {
    let obj = JSON.parse(req.responseText);
    let txt = "중복된 아이디";
    if (obj.flag) {
        txt = "사용가능한 아이디";
    }
    document.getElementById("res").innerHTML = txt;
}
const checkDuplicate = () => {
    let username = document.getElementById("username").value;
    req.open("get", "/api/signup/hospital/idcheck.do?username=" + username);
    req.send();
}