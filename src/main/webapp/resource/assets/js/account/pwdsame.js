function isSame(){
    var password = document.getElementById("password").value;
    if(password.length < 6 || password.length > 16){
        window.alert('비밀번호는 6글자 이상, 16글자 이하만 이용 가능합니다.');
        document.getElementById('password').value=document.getElementById('pwCheck').value='';
        document.getElementById('same').innerHTML='';
    }
    if(document.getElementById('password').value!='' && document.getElementById('pwCheck').value!=''){
        if(document.getElementById('password').value== document.getElementById('pwCheck').value){
            document.getElementById('same').innerHTML= '비밀번호가 일치합니다.';
            document.getElementById('same').style.color = 'blue';
        } else {
            document.getElementById('same').innerHTML = '비밀번호가 일치하지 않습니다.';
            document.getElementById('same').style.color = 'red' ;
        }

    }
}