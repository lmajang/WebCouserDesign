<template>
  <div class="container">
  <div class="qrhead">
  <el-text class="mx-1" size="large" type="warning">我的健康码</el-text>
  </div>
  <div class="QRcode" id="QRcode">
    <qrcode-vue :value="'学号：'+data.no+' 姓名：'+data.name" :size="data.size" level="H" :foreground="data.qrColor" :style="{border:borderColor}"/>
  </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import QrcodeVue from 'qrcode.vue'
let color=sessionStorage.getItem('QrColor');
let borderColor=null;
if(color==null) color='grey';
if(color==='blue'){
   borderColor='5px solid gold';
}
const data=reactive<{
  no: string,
  name: string,
  size: number,
  qrColor:string
}>({
  no:sessionStorage.getItem('no'),
  name:'李四',
  size:256,
  qrColor:color,
})
</script>

<style scoped>
.QRcode {
  display: inline-block;
  padding: 5px;
}
.qrhead{
  position: absolute;
  left: 50%;
  top: -10%;
  transform: translate(-50%);
}

.container{
  position: absolute;
  top:50%;
  left:50%;
  transform: translate(-50%, -50%);
}
</style>