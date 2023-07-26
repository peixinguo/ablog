<template>
    <div>
        <el-form ref="ruleFormRef" :model="loginForm">
            <h3>ABlog后台管理系统</h3>
            <el-form-item prop="username">
                <el-input v-model="loginForm.username" type="text" size="large" placeholder="账号">
                    <template #prefix><svg-icon icon-class="user"></svg-icon></template>
                </el-input>
            </el-form-item>
            
        </el-form>
    </div>
    
</template>
<script setup lang="ts">
import { FormInstance } from 'element-plus';
import { reactive,ref } from 'vue';

const ruleFormRef = ref<FormInstance>();
const loginForm = reactive({
    username:"admin@qq.com",
    password:"123456"
})

    
</script>