import { createApp } from 'vue'
import './style.css'
import SvgIcon from "@/components/SvgIcon/index.vue";
import ElementPlus from "element-plus";
import * as ElementPlusIconsVue from "@element-plus/icons-vue";
import router from "@/router";
import App from './App.vue'

const app = createApp(App);

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component);
}
app.use(router);
app.component("svg-icon", SvgIcon);
app.use(ElementPlus);
app.mount("#app");
