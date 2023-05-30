import './assets/main.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { createApp } from 'vue'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from "axios"
import App from './App.vue'
import VueRouter from 'vue-router'
import VueResource from 'vue-resource'
createApp(App).use(ElementPlus).mount('#app')
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    createApp(App).component(key, component)
}
createApp(App).use(VueResource)
createApp(App).use(VueRouter)