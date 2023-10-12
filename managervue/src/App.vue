<template>
  <el-config-provider :locale="zhCn" :size="size">
    <router-view/> 
  </el-config-provider> 
</template>

<script setup lang="ts">
import { ElConfigProvider } from 'element-plus';
import zhCn from 'element-plus/es/locale/lang/zh-cn';
const size = 'large';



</script>
