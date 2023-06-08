import {createRouter, createWebHistory} from "vue-router";
import LoginPage from "@/components/LoginPage.vue";
import Home from "@/components/Home.vue";
import applicationForm from "@/components/applicationForm.vue";
import TeacherAccount from "@/components/TeacherAccount.vue";
import TeacherInformation from "@/components/TeacherInformation.vue";
import StudentInformation from "@/components/StudentInformation.vue";
import echarts from "@/components/echarts.vue";
import personPage from "@/components/personPage.vue";
import classInformation from "@/components/classInformation.vue";
import collegeInformation from "@/components/collegeInformation.vue";
import majorInformation from "@/components/majorInformation.vue";
const routes =[
    {
        path:"/",
        component:LoginPage
    },
    {
        path:"/home",
        component: Home,
        redirect:"/applicationForm",
        children: [
            {
                path:"/applicationForm",
                component:applicationForm
            },
            {
                path:"/TeacherAccount",
                component:TeacherAccount
            },
            {
                path:"/TeacherInformation",
                component:TeacherInformation
            },
            {
                path:"/StudentInformation",
                component:StudentInformation
            },
            {
                path:"/echarts",
                component:echarts
            },
            {
              path:"/personPage",
              component: personPage
            },
            {
                path:"/classinformation",
                component:classInformation
            },
            {
                path:"/majorInformation",
                component:majorInformation
            },
            {
                path:"/collegeInformation",
                component:collegeInformation
            }
        ]
    },

]
/*权限路由*/
export const asyncRoute=[
    {

    }
]
const router = createRouter({
    history:createWebHistory(),
    routes,
})

/*router.beforeEach((to,from,next) =>{
    let token=localStorage.getItem("token");
    if(token||to.path==="/"){
        next();
    }
    else{
        next("/login")
    }
})*/

export default router
