import {createRouter, createWebHistory} from "vue-router";
import LoginPage from "@/components/LoginPage.vue";
import Home from "@/components/Home.vue";
import applicationForm from "@/components/applicationForm.vue";
const routes =[
    {
        path:"/",
        component:LoginPage
    },
    {
        path:"/home",
        component: Home,
        children: [
            {
                path:"/applicationForm",
                component:applicationForm
            }
        ]
    },

]

const router = createRouter({
    history:createWebHistory(),
    routes,
})
export default router
