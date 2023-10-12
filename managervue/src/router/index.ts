
import Layout from "@/layouts/index.vue";
import path from "path";
import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";

export const constantRoutes: RouteRecordRaw[] = [
    {
        path: "/login",
        name: "登录",
        component:()=> import("@/views/login/index.vue"),
        meta: {
            hidden: true
        }
    },
    {
        path: "",
        component:Layout,
        redirect:"/index",
        children:[
            {
                path: "/index",
                component: ()=> import("@/views/home/index.vue"),
                name: "Index",
                meta: {title: "首页", icon: "dashboard", affix: true},
            },
        ]
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes: constantRoutes,
  });
  
export default router;