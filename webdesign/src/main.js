import './assets/main.css'
import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from "axios"
import router from './router/index'
import * as echarts from 'echarts'
import QrcodeVue from 'qrcode.vue'
const app=createApp(App)
app.config.globalProperties.$echarts = echarts
axios.defaults.baseURL='http://localhost:8080'
app.config.globalProperties.$ajax=axios
app.use(ElementPlus).use(router).mount('#app')
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}

