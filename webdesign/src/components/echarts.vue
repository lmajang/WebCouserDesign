<template>
  <div class="container">
  <div
      ref="ColorChart"
      id="ColorChart"
      :style="{ width: '800px', height: '300px' }"
  ></div>
  <div
      ref="DailyChart"
      id="DailyChart"
      :style="{ width: '800px', height: '300px' }"
  ></div>
  </div>
</template>

<script>
import {getCurrentInstance, onMounted, ref} from "vue";
import QrcodeVue from 'qrcode.vue'
export default {
  name: "echarts",
  data(){
    return {
      QRcodeColor:{
        blue:"",
        green:"",
        grey:"",
        red:"",
        yellow:"",
      },
      dailyclock:{
        yes:"",
        no:"",
      }
    }
},
  methods: {
     getColorData() {
      this.$ajax.post('/healthstatistic',sessionStorage.getItem('no')).then(response =>{
        this.QRcodeColor=response.data;
        this.setColorEcharts();
        console.log(this.QRcodeColor)
      }).catch(error =>{
        console.log(error)
      })
    },
    getClockData(){
      this.$ajax.post('/dailystatistic',sessionStorage.getItem('no')).then(response =>{
        console.log(response.data)
        this.dailyclock=response.data;
        this.setDailyChart();
      }).catch(error =>{
        console.log(error)
      })
    },
    setColorEcharts(){
     let myChart=this.$echarts.init(document.getElementById("ColorChart"),null,{
       width:800,height:400});
      const option = {
        title: {
          text: '健康码情况',
          left: 'center',
        },
        xAxis:{
          data:['蓝码','绿码','灰码','红码','黄码']
        },
        yAxis:{
        },
        series: [
          {
            type:'bar',
            data: [
                Number(this.QRcodeColor.blue),
                Number(this.QRcodeColor.green),
                Number(this.QRcodeColor.grey),
                Number(this.QRcodeColor.red),
                Number(this.QRcodeColor.yellow),
            ],
          }
        ]
      };
      // 设置实例参数
      myChart.setOption(option);
    },
    setDailyChart(){
      let myChart=this.$echarts.init(document.getElementById("DailyChart"),null,{
        width:800,height:380});
      const option = {
        title: {
          text: '今日打卡情况',
          left: 'center',
          top: 'center'
        },
        series: [
          {
            type:'pie',
            data: [
              {
                value: Number(this.dailyclock.yes),
                name: '已打卡'
              },
              {
                value: Number(this.dailyclock.no),
                name: '未打卡'
              },
            ],
            radius: ['40%', '70%']
          }
        ]
      };
      // 设置实例参数
      myChart.setOption(option);
    },
  },
  mounted(){
    this.getColorData();
    this.getClockData();
  },
}
</script>

<style scoped>
.container{
  position: absolute;
  left:50%;
  transform:translate(-50%);
}
</style>