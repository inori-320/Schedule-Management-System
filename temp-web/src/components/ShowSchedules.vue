<script setup>

    import { defineUser } from '../store/userStore';
    import { defineSchedule } from '../store/scheduleStore';
    import { ref, reactive, onMounted, onUpdated } from 'vue';
    import request from '../utils/request';

    let sysUser = defineUser();
    let schedule = defineSchedule();

    onMounted(
        async () => {
            showSchedules();
        }
    );
    
    async function showSchedules(){
        let {data} = await request.get('schedule/showInfo', {params: {"uid": sysUser.uid}});
        schedule.itemList = data.data.schedules;
    }

    async function addNewSchedule(){
        let{data} = await request.get('schedule/addDefaultSchedule', {params: {"uid": sysUser.uid}});;
        if(data.code === 200){
            showSchedules();
        } else {
            alert("增加失败");
        }
    }

    async function updateSchedule(index){
        let {data} = await request.post('schedule/updateSchedule', schedule.itemList[index]);
        if(data.code === 200){
            alert("保存成功");
            showSchedules();
        } else {
            alert("修改失败");
        }
    }

    async function dropSchedule(index){
        let sid = schedule.itemList[index].sid;
        let {data} = await request.get('schedule/dropSchedule', {params: {"sid": sid}});
        if(data.code === 200){
            alert("删除成功");
            showSchedules();
        } else {
            alert("删除失败");
        }
    }

</script>

<template>
  <div>
    <h3 class="ht">您的日程如下</h3>
<table class="tab" cellspacing="0px">
    <tr class="ltr">
        <th>编号</th>
        <th>内容</th>
        <th>进度</th>
        <th>操作</th>
    </tr>
    <tr class="ltr" v-for="item, index in schedule.itemList" :key="index">
        <td v-text="index + 1"></td>
        <td>
            <input type="text" v-model="item.title">
        </td>
        <td>
            <input type="radio" value="1" v-model="item.completed"> 已完成
            <input type="radio" value="0" v-model="item.completed"> 未完成
        </td>
        <td class="buttonContainer">
             <button class="btn1" @click="dropSchedule(index)">删除</button>
            <button class="btn1" @click="updateSchedule(index)">保存修改</button>
        </td>
    </tr>
    <tr class="ltr buttonContainer" >
        <td colspan="4">
            <button class="btn1" @click="addNewSchedule()">新增日程</button>
        </td>

    </tr>
</table>
  </div>
</template>

<style scoped>

    .ht{
        text-align: center;
        color: cadetblue;
        font-family: 幼圆;
    }
    
    .tab{
        width: 80%;
        border: 5px solid cadetblue;
        margin: 0px auto;
        border-radius: 5px;
        font-family: 幼圆;
    }

    .ltr td{
        border: 1px solid  powderblue;
    }

    .ipt{
        border: 0px;
        width: 50%;
    }

    .btn1{
        border: 2px solid powderblue;
        border-radius: 4px;
        width:100px;
        background-color: antiquewhite;
    }

    #usernameMsg , #userPwdMsg {
        color: gold;
    }

    .buttonContainer{
        text-align: center;
    }

</style>