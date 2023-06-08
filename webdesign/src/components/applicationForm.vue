<template>
  <el-form
      :model="HealthyForm"
      :rules="rules"
      label-position="top"
      label-width="120px"
      class="demo-ruleForm Healthy-form"
      status-icon
      ref="HealthyForm"
  >
<!--个人信息-->
    <el-form-item label="姓名" prop="name"><!--个人信息，包括姓名、身份证号、工号或学号、手机号，-->
      <el-input v-model="HealthyForm.name" disabled/>
    </el-form-item>
    <el-form-item label="身份证号" prop="idCard">
      <el-input v-model="HealthyForm.idCard" disabled/>
    </el-form-item>
    <el-form-item label="工号或学号" prop="number">
      <el-input v-model="HealthyForm.no" disabled/>
    </el-form-item>
    <el-form-item label="手机号" prop="pnumber">
      <el-input v-model="HealthyForm.pnumber" />
    </el-form-item>

    <el-form-item label="本人近期（14天内）是否去过重点疫区" prop="goAffect" >
      <el-radio-group v-model="HealthyForm.goAffect">
        <el-radio label="1" name="type" >是</el-radio>
        <el-radio label="0" name="type" >否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="本人近期（14天内）是否去过国外？" prop="goAbroad">
      <el-radio-group v-model="HealthyForm.goAbroad">
        <el-radio label="1" name="type" >是</el-radio>
        <el-radio label="0" name="type" >否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="本人近期（14天内）是否接触过新冠确诊病人或疑似病人" prop="isContact" >
      <el-radio-group v-model="HealthyForm.isContact">
        <el-radio label="1" name="type" >是</el-radio>
        <el-radio label="0" name="type" >否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例" prop="isSicken" >
      <el-radio-group v-model="HealthyForm.isSicken">
        <el-radio label="1" name="type" >是</el-radio>
        <el-radio label="0" name="type" >否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="本人是否打过新冠疫苗" prop="isInjection" >
      <el-radio-group v-model="HealthyForm.isInjection">
        <el-radio label="0"  >未打过</el-radio>
        <el-radio label="1"  >已打1针</el-radio>
        <el-radio label="2"  >已打2针</el-radio>
        <el-radio label="3"  >已打3针</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="当前健康状况" prop="isHealthy" >
      <el-radio-group v-model="HealthyForm.isHealthy">
        <el-radio label="1" name="type" value="1">无异常</el-radio>
        <el-radio label="0" name="type" value="0">异常</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item key="contional" v-if="HealthyForm.isHealthy==='0'" label="症状" prop="healthy">
      <el-checkbox-group v-model="HealthyForm.healthyCondition">
        <el-checkbox label="0" >发烧（≥37.3℃）</el-checkbox>
        <el-checkbox label="1" >乏力</el-checkbox>
        <el-checkbox label="2" >干咳</el-checkbox>
        <el-checkbox label="3" >鼻塞</el-checkbox>
        <el-checkbox label="4" >流涕</el-checkbox>
        <el-checkbox label="5" >咽痛</el-checkbox>
        <el-checkbox label="6" >腹泻</el-checkbox>
      </el-checkbox-group>
    </el-form-item>
    <el-form-item prop="mustdata">
      <el-checkbox-group v-model="HealthyForm.mustdata">
      <el-checkbox label="1"   >本人郑重承诺：填报信息真实，愿意承担相应的法律责任。</el-checkbox>
      </el-checkbox-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitEvent()">
        提交
      </el-button>
      <el-button @click="resetForm()">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  name: "applicationForm",

  data(){
    return {
      HealthyForm: {
        name: '',
        idCard: '',
        no: sessionStorage.getItem('no'),
        pnumber: '',
        goAffect: '',
        goAbroad: '',
        isContact: '',
        isSicken: '',
        isInjection: '',
        isHealthy: '',
        healthyCondition: [],
        mustdata:[],
      },
        rules: {
          pnumber: [
            {required: true,message: '请输入电话号码', trigger: 'blur'},
            {pattern:/^((0\d{2,3}-\d{7,8})|(1[34578]\d{9}))$/,message: '请输入正确的电话号码',trigger: 'blur'}
          ],
          goAffect: [
            { required: true,message: '该项不能为空',trigger: 'change'}
          ],
          goAbroad:[
            {required: true,message: '该项不能为空',trigger: 'change'}
          ],
          isContact:[
            {required: true,message: '该项不能为空',trigger: 'change'}
          ],
          isSicken:[
              {required: true,message: '该项不能为空',trigger: 'change'}
          ],
          isInjection: [
            {required: true,message: '该项不能为空',trigger: 'change'}
          ],
          isHealthy: [
            {required: true,message: '该项不能为空',trigger: 'change'}
          ],
          healthyCondition:[
            {required: true,message: '该项不能为空',trigger: 'change'}
          ],
          mustdata:[
            {required: true,message: '该项不能为空',trigger: 'change'}
          ],
        }
      };
    },
  mounted() {
    this.getData()
  },
  methods:{
    submitEvent(){
    this.$refs.HealthyForm.validate((valid)=>{
      if(valid){
        this.$ajax.post('/'+sessionStorage.getItem('identity')+'healthget',this.HealthyForm).then(successRespond=>{
          console.log(successRespond.data)
          sessionStorage.setItem('QrColor',successRespond.data.health)
          this.$notify({
            title: '提示',
            message: '提交成功',
            type: 'success'
          })
        }).catch(errorRespond=>{
          this.$notify({
            title: '提示',
            message: '提交失败',
            type: 'error'
          })
        })
      }
      else {console.log('Error');
      console.log(this.healthyCondition)}
      })
    },
    validateCheckbox() {
      this.$refs.HealthyForm.validateField('mustdata'); // 执行表单校验
    },
    resetForm(){
      this.$refs.HealthyForm.resetFields();
    },
    getData(){
      this.$ajax.post('/'+sessionStorage.getItem('identity')+'health',this.HealthyForm.no).then(response=>{
        console.log(response.data)
        if(sessionStorage.getItem('identity')==='Teacher')
        {
          this.HealthyForm.name=response.data.tname;
          this.HealthyForm.idCard=response.data.tidcard;
        }
        else if(sessionStorage.getItem('identity')==='Student'){
          this.HealthyForm.name=response.data.sname;
          this.HealthyForm.idCard=response.data.sidcard;
        }
      })
          .catch(error=>{
            console.error('error:',error);
          })
    },

  }


}

</script>

<style scoped>
.Healthy-form{
  padding:15px;
}
.el-input{
  width:50%;
}
</style>