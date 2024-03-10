function checkUsername(){
    let usernameReg = /^[a-zA-Z0-9]{5,10}$/;
    let usernameInput = document.getElementById("usernameInput");
    let username = usernameInput.value;
    let usernameMsg = document.getElementById("usernameMsg");
    if(!usernameReg.test(username)){
        usernameMsg.innerText = "格式必须是5-10位数字或字母";
        return false;
    }
    let request = new XMLHttpRequest();
    request.onreadystatechange = function(){
        if(request.readyState === 4 && request.status === 200){
            let result = JSON.parse(request.responseText);
            if(result.code === 200){
                usernameMsg.innerText = "√";
            } else if(result.code === 504){
                usernameMsg.innerText = "用户名已被使用";
            }
        }
    }
    request.open("GET", "/user/checkUsernameUsed?username=" + username);
    request.send();
}

function checkUserPwd(){
    let userPwdReg = /^[0-9]{9,12}$/;
    let userPwdInput = document.getElementById("userPwdInput");
    let userPwd = userPwdInput.value;
    let userPwdMsg = document.getElementById("userPwdMsg");
    if(!userPwdReg.test(userPwd)){
        userPwdMsg.innerText = "格式必须是9-12位数字";
        return false;
    }
    userPwdMsg.innerText = "√";
    return true;
}

function checkPwdAgain(){
    let userPwdInput = document.getElementById("userPwdInput");
    let userPwdInputAgain = document.getElementById("userPwdInputAgain");
    let userPwd = userPwdInput.value;
    let userPwdAgain = userPwdInputAgain.value;
    let userPwdAgainMsg = document.getElementById("userPwdAgainMsg");
    if(userPwd !== userPwdAgain){
        userPwdAgainMsg.innerText = "两次输入的密码不同";
        return false;
    }
    userPwdAgainMsg.innerText = "√";
    return true;
}

function checkForm() {
    let f1 = checkUsername();
    let f2 = checkUserPwd();
    let f3 = checkPwdAgain();
    return f1 && f2 && f3;
}