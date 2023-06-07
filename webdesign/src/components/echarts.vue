<template>
  <div
      ref="myChart"
      id="myChart"
      :style="{ width: '800px', height: '400px' }"
  ></div>
</template>

<script>
import {getCurrentInstance, onMounted, ref} from "vue";
import QrcodeVue from 'qrcode.vue'
export default {
  name: "echarts",
  data(){
    return {
      QRcodeColor:{
        red:"",
        green:"",
        blue:"",
      },
      dailyclock:{
        alreadyC:"",
        noC:"",
      }
    }
},
  methods: {
    getData() {
      this.$ajax.post('data').then(response =>{

      })
    }
  },
  mounted(){
  },
  setup() {
    // 通过 internalInstance.appContext.config.globalProperties 获取全局属性或方法
    let internalInstance = getCurrentInstance();
    let echarts = internalInstance.appContext.config.globalProperties.$echarts;

    onMounted(() => {
      const dom = document.getElementById('myChart');
      const myChart = echarts.init(dom); // 初始化echarts实例
      const option = {
        series: [
          {
            type:'pie',
            data: [
              {
                value: 335,
                name: 'A'
              },
              {
                value: 234,
                name: 'B'
              },
              {
                value: 1548,
                name: 'C'
              }
            ],
            radius: ['40%', '70%']
          }
        ]
      };
      // 设置实例参数
      myChart.setOption(option);
    });
    return {};
  }

}
</script>

<style scoped>

</style>