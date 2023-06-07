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
      <el-menu-item index="0">LOGO</el-menu-item>
      <div class="flex-grow" />
      <el-menu-item index="1">Processing Center</el-menu-item>
      <el-sub-menu index="2">
        <template #title>Workspace</template>
        <el-menu-item index="2-1">item one</el-menu-item>
        <el-menu-item index="2-2">item two</el-menu-item>
        <el-menu-item index="2-3">item three</el-menu-item>
        <el-sub-menu index="2-4">
          <template #title>item four</template>
          <el-menu-item index="2-4-1">item one</el-menu-item>
          <el-menu-item index="2-4-2">item two</el-menu-item>
          <el-menu-item index="2-4-3">item three</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
      <el-sub-menu index="3" class="user" >
        <template #title><el-avatar> user </el-avatar></template>
        <el-menu-item index="/personPage">个人中心</el-menu-item>
        <el-menu-item index="/">登出</el-menu-item>
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
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b" style="height: 100%" router>
<!--账号管理 -->
        <el-sub-menu index="1" v-if="role ==='100'">
          <template #title>
            <i class="el-icon-location"></i>
            <span>账号管理</span>
          </template>
            <el-menu-item index="/TeacherAccount">教师账号</el-menu-item>
        </el-sub-menu>

        <!--信息管理 -->
        <el-sub-menu index="2">
          <template #title>
            <i class="el-icon-location"></i>
            <span>信息管理</span>
          </template>
          <el-menu-item index="/Teacherinformation">教师</el-menu-item>
          <el-menu-item index="/Studentinformation">学生</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="/echarts">信息统计</el-menu-item>
        <el-menu-item index="/applicationForm">
          <i class="el-icon-setting"></i>
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
export default {
  name: "Home",

  data(){
    return{
      role:localStorage.getItem('role'),
    };
  },
  methods:{
  }
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