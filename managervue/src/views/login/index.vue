<template>
    <h1>{{ title }}</h1>
    <div v-if="noLogin">账号：<input v-model="username" type="text"/></div>
    <div v-if="noLogin">密码：<input v-model="password" type="password"/></div>
    <div v-on:click="click" style="border-radius: 30px;width: 100px;margin: 20px auto;color: white;background-color: blue;">
        {{ buttonTitle }}
    </div>
    <input type="checkbox" v-model="checkbox"/>
    <p>{{ checkbox }}</p>

</template>
<script lang="ts">

    export default{
        name: 'Login',
        data:()=>({
            title:'欢迎您，未登录',
            username:'',
            password:'',
            buttonTitle:'登陆',
            noLogin:true,
            checkbox:true,
        }),
        methods:{
           click(){
            if(this.noLogin){
                this.login()
            }else{
                this.logout()
            }
           },
           login(){
            alert('登陆成功');
            this.title = '欢迎您'+this.username
            this.noLogin = false;
            this.buttonTitle = '退出登陆';
           },
           logout(){
            this.noLogin = true;
            this.title = '欢迎您，未登录'
            this.buttonTitle = '登陆'
           }
        },
    
        
    }

    
</script>