<template>
    <div class="login">
        <el-form ref="ruleFormRef" :model="loginForm" :rules="rules" class="login-form">
            <h3 class="title">ABlog后台管理系统</h3>
            <el-form-item prop="username">
                <el-input v-model="loginForm.username" type="text" size="large" placeholder="账号">
                    <template #prefix><svg-icon icon-class="user"></svg-icon></template>
                </el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input v-model="loginForm.password" placeholder="密码" show-password size="large" type="password" @key.enter="">
                    <template #prefix><svg-icon icon-class="password"></svg-icon></template>
                </el-input>
            </el-form-item>
            <el-form-item>
                <el-button :loading="loading" type="primary"  @click.prevent="" style="width: 100%;">
                    <span v-if="!loading">登陆</span>
                    <span v-else>登陆中...</span>
                </el-button>
            </el-form-item>
        </el-form>
        <!--底部-->
        <div class="el-login-footer">
            <span>Copyright © 2023 - {{ new Date().getFullYear }} By kuopeihsin</span>
        </div>
    </div>
    
</template>
<script setup lang="ts">
import { FormInstance, FormRules} from 'element-plus';
import { reactive,ref } from 'vue';

const ruleFormRef = ref<FormInstance>();
const loading = ref(false);
const loginForm = reactive({
    username:"admin@qq.com",
    password:"123456"
})

const rules = reactive<FormRules>({
    username: [{ required: true, message: "请输入用户名", trigger: "blur" }],
    password: [{ required: true, message: "请输入密码", trigger: "blur" }, { min: 6, message: "密码不能少于6位", trigger: "blur" }],
});

    
</script>
<style lang="scss" scoped>
.login {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    background-image: url("https://static.ttkwsd.top/config/0d7d8d691e644989b72ddda5f695aca2.jpg");
    background-size: cover;
}

.title {
    margin: 0px auto 30px auto;
    text-align: center;
    color: #707070;
}

.login-form {
    border-radius: 6px;
    background: #ffffff;
    width: 400px;
    padding: 25px 25px 5px 25px;
}

.login-tip {
    font-size: 13px;
    text-align: center;
    color: #bfbfbf;
}

.el-login-footer {
    height: 40px;
    line-height: 40px;
    position: fixed;
    bottom: 0;
    width: 100%;
    text-align: center;
    color: #fff;
    font-family: Arial;
    font-size: 12px;
    letter-spacing: 1px;
}
</style>