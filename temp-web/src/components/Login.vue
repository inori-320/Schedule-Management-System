<script setup>

  import { ref, reactive } from 'vue';

  let loginUser = reactive({
    username: "",
    userPwd: ""
  });

  let usernameMsg = ref("");
  let userPwdMsg = ref("");

  function checkUsername(){
    let usernameReg = /^[a-zA-Z0-9]{5,10}$/;
    if(!usernameReg.test(loginUser.username)){
        usernameMsg.value = "格式必须是5-10位数字或字母";
        return false;
    }
    usernameMsg.value = "√";
    return true;
  }
  
  function checkUserPwd(){
    let userPwdReg = /^[0-9]{6}$/;
    if(!userPwdReg.test(loginUser.userPwd)){
        userPwdMsg.value = "密码必须是6位数字";
        return false;
    }
    userPwdMsg.value = "√";
    return true;
  }

</script>

<template>
  <div>
    <h3 class="ht">请登录</h3>
        <table class="tab" cellspacing="0px">
            <tr class="ltr">
                <td class="td_text">请输入账号</td>
                <td>
                    <input class="ipt" 
                    type="text" 
                    v-model="loginUser.username"
                    @blur="checkUsername()">
                    <span id="usernameMsg" v-text="usernameMsg"></span>
                </td>
            </tr>
            <tr class="ltr">
                <td class="td_text">请输入密码</td>
                <td>
                    <input class="ipt" 
                    type="password" 
                    v-model="loginUser.userPwd"
                    @blur="checkUserPwd()">
                    <span id="userPwdMsg" v-text="userPwdMsg"></span>
                </td>
            </tr>
            <tr class="ltr">
                <td colspan="2" class="buttonContainer">
                    <input class="btn1" type="button" value="登录">
                    <input class="btn1" type="button" value="重置">
                    <router-link to="/register">
                      <button class="btn1">去注册</button>
                    </router-link>
                </td>
            </tr>
        </table>
  </div>
</template>

<style scoped>
    
    .ht{
        text-align: center;
        color: brown;
        font-family: 幼圆;
        font-weight: bold;
    }
    
    .tab{
        width: 600px;
        border: 5px solid cadetblue;
        margin: 0px auto;
        border-radius: 5px;
        font-family: 幼圆;
    }

    .ltr td{
        border: 1px solid  powderblue;
        font-family: 宋体;
        font-weight: bold;
    }

    .ipt{
        border: 0px;
        width: 50%;
    }

    .btn1{
        border: 2px solid powderblue;
        border-radius: 4px;
        width:60px;
        background-color: antiquewhite;
    }

    #usernameMsg , #userPwdMsg {
        color: rgba(37, 223, 237, 0.9);
    }

    .buttonContainer{
        text-align: center;
    }

    .td_text{
        width: 100px;
    }

</style>