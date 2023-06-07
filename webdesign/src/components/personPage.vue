<template>
  <div class="QRcode">
    <qrcode-vue :value="'学号：'+data.no+' 姓名：'+data.name" :size="data.size" level="H" :foreground="data.qrColor"/>
  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import QrcodeVue from 'qrcode.vue'

const data=reactive<{
  no: string,
  name: string,
  size: number,
  qrColor:string
}>({
  no:sessionStorage.getItem('no'),
  name:'李四',
  size:256,
  qrColor:sessionStorage.getItem('QrColor'),
})
</script>

<style scoped>
.QRcode {
  display: inline-block;
  padding: 5px;
  border: 2px solid gold;
}
</style>