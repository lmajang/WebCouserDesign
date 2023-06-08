<template>
  <el-container class="home-container">

  <el-header class="home-header">
    <el-menu
        default-active="this.$route.path"
        class="el-menu-demo"
        mode="horizontal"
        :ellipsis="false"
        @select="handleSelect"
        router
    >
      <el-menu-item index="/home">师生健康码管理系统</el-menu-item>
      <div class="flex-grow" />
      <el-sub-menu index="3" class="user" >
        <template #title><el-avatar> user </el-avatar></template>
        <el-menu-item index="/personPage">个人中心</el-menu-item>
        <el-menu-item @click="signout()">登出</el-menu-item>
      </el-sub-menu>
    </el-menu>
  </el-header>

<el-container>

  <el-aside style="width: 150px">
  <el-row class="tac">
    <el-col :span="24">
      <el-menu
          default-active="this.$route.path"
          class="el-menu-vertical-demo"
          @mouseenter="handleMouseEnter"
          @mouseleave="handleMouseLeave"
          :collapse="menuExpanded"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b" style="height: 100%" router ref="menu">
<!--账号管理 -->
        <el-sub-menu index="1" v-if="role ==='100'||role ==='200'" >
          <template #title>
            <el-icon><User /></el-icon>
            <span slot="title">账号管理</span>
          </template>
            <el-menu-item index="/TeacherAccount">教师账号</el-menu-item>
        </el-sub-menu>
        <!--信息管理 -->
        <el-sub-menu index="2" v-if="role==='100'||role==='200'||role==='300'">
          <template #title>
            <el-icon><Tickets/></el-icon>
            <span slot="title">信息管理</span>
          </template>
          <el-menu-item index="/classinformation">班级信息</el-menu-item>
          <el-menu-item index="/collegeInformation" v-if="role==='100'||role==='200'">学院信息</el-menu-item>
          <el-menu-item index="/majorInformation">专业信息</el-menu-item>
          <el-menu-item index="/Teacherinformation" v-if="role==='100'||role==='200'">教师信息</el-menu-item>
          <el-menu-item index="/Studentinformation">学生信息</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="/echarts" v-if="role==='100'||role==='200'||role==='300'">
          <el-icon><DataAnalysis /></el-icon>
          <span slot="title">信息统计</span>
        </el-menu-item>


        <el-menu-item index="/applicationForm">
          <el-icon><document /></el-icon>
          <span slot="title">健康码申报</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
  </el-aside>

  <el-main>
<router-view></router-view>
  </el-main>
</el-container>
  </el-container>
</template>

<script>
import router from "@/router";
import {List} from "echarts";
import method from "vue-resource/src/http/interceptor/method";
import {ref} from "vue";

export default {
  name: "Home",
  computed: {
    List() {
      return List
    }
  },

  data() {
    return {
      role: localStorage.getItem('role'),
      menuExpanded: true,
    };
  },
  methods: {
    signout() {
      sessionStorage.clear();
      localStorage.clear();
      router.push('/');
    },
    handleMouseEnter(){
      this.menuExpanded=false;
    },
    handleMouseLeave(){
      this.menuExpanded=true;
    }
  },
}
</script>

<style scoped>
.home-container{
  position: absolute;
  left: 0;
  top: 0;
  height:100%;
  width: 100%;
}
.user{
  position: absolute;
  right: 0;
  top: 14%;
}
.tac{
  height:100%;
  width:150px;
}
</style>