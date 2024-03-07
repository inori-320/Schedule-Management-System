function checkUsername(){
    let usernameReg = /^[a-zA-Z0-9]{5,10}$/;
    let usernameInput = document.getElementById("usernameInput");
    let username = usernameInput.value;
    let usernameMsg = document.getElementById("usernameMsg");
    if(!usernameReg.test(username)){
        usernameMsg.innerText = "格式必须是5-10位数字或字母";
        return false;
    }
    usernameMsg.innerText = "√";
    return true;
}

function checkUserPwd(){
    let userPwdReg = /^[0-9]{9,12}$/;
    let userPwdInput = document.getElementById("userPwdInput");
    let userPwd = userPwdInput.value;
    let userPwdMsg = document.getElementById("userPwdMsg");
    if(!userPwdReg.test(userPwd)){
        userPwdMsg.innerText = "密码必须是9-12位数字";
        return false;
    }
    userPwdMsg.innerText = "√";
    return true;
}

function checkForm(){
    let f1 = checkUsername();
    let f2 = checkUserPwd();
    return f1 && f2;
}