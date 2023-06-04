import './assets/main.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { createApp } from 'vue'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from "axios"
import App from './App.vue'
import router from './router/index'
/*import VueRouter from 'vue-router'*/
const app=createApp(App)
axios.defaults.baseURL='http://localhost:8080'
app.config.globalProperties.$ajax=axios
app.use(ElementPlus).use(router).mount('#app')
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

