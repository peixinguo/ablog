import "@/assets/styles/index.scss";
import { createApp } from 'vue'
import { createPinia } from "pinia";
import SvgIcon from "@/components/SvgIcon/index.vue";
import ElementPlus from "element-plus";
import * as ElementPlusIconsVue from "@element-plus/icons-vue";
import router from "@/router";
import VueViewer from "v-viewer";
import App from './App.vue'

const app = createApp(App);
const pinia = createPinia();

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component);
}
app.use(pinia);
app.use(router);
app.use(VueViewer);
app.component("svg-icon", SvgIcon);
app.use(ElementPlus);
app.mount("#app");
