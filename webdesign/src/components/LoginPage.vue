<template>

  <div class="Login-container">
    <div class="Login-box">
      <div class="loginText">登录</div>
      <div class="avatar_box">
        <img src="../assets/logo.svg" alt="avatar">
      </div>

    <el-form :model="LoginForm" :rules="LoginFormRules" label-width="0px" class="LoginForm" ref="LoginFormRef">
      <el-form-item prop="AccountInput" >
      <span class="svg-container">
        <svg-icon icon-class="el-icon-date" />
      </span>
        <el-input :prefix-icon="UserFilled" ref="AccountInput" v-model="LoginForm.AccountInput" placeholder="请输入账号"></el-input>
      </el-form-item>

      <el-form-item prop="PasswordInput" >
      <span class="svg-container">
        <svg-icon icon-class="password" />
      </span>
        <el-input :prefix-icon="Lock" ref="PasswordInput" placeholder="请输入密码" v-model="LoginForm.PasswordInput" show-password></el-input>
      </el-form-item>
      <div class="btns">
      <el-form-item class="">
        <el-button type="primary" @click="LoginEvent()">登录</el-button>
        <el-button type="info" @click="resetForm('LoginFormRef')">重置</el-button>
      </el-form-item>
      </div>
    </el-form>
    </div>
  </div>
</template>

<script>
import {Lock,UserFilled} from "@element-plus/icons";
import {createRouter as $router} from "vue-router";

export default {

  computed: {
    UserFilled() {
      return UserFilled
    },
    Lock() {
      return Lock
    }
  },
  name: "LoginPage",
  data() {
    return {
      LoginForm: {
        AccountInput: "",
        PasswordInput: ""
      },

      LoginFormRules:{
        AccountInput: [
          { required: true, message: '请输入账号', trigger: 'blur' }
        ],
        PasswordInput: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ]
      },

    };
  },
  methods:{
    resetForm(LoginForm){
      this.$refs[LoginForm].resetFields();
    },

    /*登录预验证*/
    LoginEvent() {
      this.$refs.LoginFormRef.validate((valid) => {
        if (valid) {
          this.$http.post('login',this.LoginForm).then(successRespond=>{
            $router.push('/Home')
            }, errorRespond=>{
            this.$notify({
              title: '提示',
              message: '账号或密码错误',
              type: 'error'
            })
          })
        }
        else {
          this.$notify({
            title: '提示',
            message: '账号或密码不能为空',
            type: 'error'
          })
        }
      });
    },


  }
}

</script>

<style scoped>
.Login-container{
  height: 100%;
  background-color: white;
}
.Login-box{
  height:300px;
  width: 300px;
  background-color: #f6f8fa;
  border-radius: 3px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.avatar_box{
  height: 50px;
  width: 50px;
  border-radius: 50%;
  border: 1px solid #eee;
  padding: 2px;
  box-shadow: 0 0 1px #ddd;
  position: absolute;
  left: 50%;
  top: 25%;
  transform: translate(-50%);
}
.loginText{
  font-size: 30px;
  color: #333;
  position: absolute;
  left: 50%;
  top:5%;
  transform: translate(-50%);
  font-family:微软雅黑
}
.avatar_box> img {
  width: 100%;
  height: 100%;
  border-radius: 50%;
}
.LoginForm{
  position:absolute;
  bottom:0;
  width: 100%;
  padding: 0 40px;
  box-sizing: border-box;
}

.btns{
  display:flex;
  justify-content: center;
}
</style>