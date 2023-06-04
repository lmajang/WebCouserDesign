<template>
  <el-form
      :model="ruleForm"
      :rules="rules"
      label-position="top"
      label-width="120px"
      class="demo-ruleForm Healthy-form"
      :size="formSize"
      status-icon
  >
<!--个人信息-->

    <el-form-item label="姓名" prop="name"><!--个人信息，包括姓名、身份证号、工号或学号、手机号，-->
      <el-input v-model="ruleForm.name" disabled/>
    </el-form-item>
    <el-form-item label="身份证号" prop="idCard">
      <el-input v-model="ruleForm.idCard" disabled/>
    </el-form-item>
    <el-form-item label="工号或学号" prop="number">
      <el-input v-model="ruleForm.number" disabled/>
    </el-form-item>
    <el-form-item label="手机号" prop="pnumber">
      <el-input v-model="ruleForm.pnumber" />
    </el-form-item>

    <el-form-item label="本人近期（14天内）是否去过重点疫区" prop="goAffect" >
      <el-radio-group v-model="ruleForm.goAffect">
        <el-radio label="1" name="type" >是</el-radio>
        <el-radio label="0" name="type" >否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="本人近期（14天内）是否去过国外？" prop="goAbroad">
      <el-radio-group v-model="ruleForm.goAbroad">
        <el-radio label="1" name="type" >是</el-radio>
        <el-radio label="0" name="type" >否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="本人近期（14天内）是否接触过新冠确诊病人或疑似病人" prop="isContact" >
      <el-radio-group v-model="ruleForm.isContact">
        <el-radio label="1" name="type" >是</el-radio>
        <el-radio label="0" name="type" >否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例" prop="isSicken" >
      <el-radio-group v-model="ruleForm.isSicken">
        <el-radio label="1" name="type" >是</el-radio>
        <el-radio label="0" name="type" >否</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="本人是否打过新冠疫苗" prop="isInjection" >
      <el-radio-group v-model="ruleForm.isInjection">
        <el-radio label="0"  >未打过</el-radio>
        <el-radio label="1"  >已打1针</el-radio>
        <el-radio label="2"  >已打2针</el-radio>
        <el-radio label="3"  >已打3针</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item label="当前健康状况" prop="isHealthy" >
      <el-radio-group v-model="ruleForm.isHealthy">
        <el-radio label="1" name="type" value="1">无异常</el-radio>
        <el-radio label="0" name="type" value="0">异常</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item v-if="ruleForm.isHealthy==='0'" label="症状" prop="healthy" >
      <el-checkbox-group v-model="ruleForm.healthyCondition">
        <el-checkbox label="0" >发烧（≥37.3℃）</el-checkbox>
        <el-checkbox label="1" >乏力</el-checkbox>
        <el-checkbox label="2" >干咳</el-checkbox>
        <el-checkbox label="3" >鼻塞</el-checkbox>
        <el-checkbox label="4" >流涕</el-checkbox>
        <el-checkbox label="5" >咽痛</el-checkbox>
        <el-checkbox label="6" >腹泻</el-checkbox>
      </el-checkbox-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm(ruleFormRef)">
        提交
      </el-button>
      <el-button @click="resetForm(ruleFormRef)">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
  name: '1',
  idCard: '1',
  number: '1',
  pnumber: '',
  goAffect:'',
  goAbroad:'',
  isContact:'',
  isSicken:'',
  isInjection:'',
  isHealthy:'',
  healthyCondition:[],
})

const rules = reactive<FormRules>({
  name: [
    { required: true, message: 'Please input Activity name', trigger: 'blur' },
    { min: 3, max: 5, message: 'Length should be 3 to 5', trigger: 'blur' },
  ],
  region: [
    {
      required: true,
      message: 'Please select Activity zone',
      trigger: 'change',
    },
  ],
  count: [
    {
      required: true,
      message: 'Please select Activity count',
      trigger: 'change',
    },
  ],
  date1: [
    {
      type: 'date',
      required: true,
      message: 'Please pick a date',
      trigger: 'change',
    },
  ],
  date2: [
    {
      type: 'date',
      required: true,
      message: 'Please pick a time',
      trigger: 'change',
    },
  ],
  type: [
    {
      type: 'array',
      required: true,
      message: 'Please select at least one activity type',
      trigger: 'change',
    },
  ],
  resource: [
    {
      required: true,
      message: 'Please select activity resource',
      trigger: 'change',
    },
  ],
  desc: [
    { required: true, message: 'Please input activity form', trigger: 'blur' },
  ],
})

const submitForm = async (formEl: FormInstance | undefined) => {
  if (!formEl) return
  await formEl.validate((valid, fields) => {
    if (valid) {
      console.log('submit!')
    } else {
      console.log('error submit!', fields)
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}

const options = Array.from({ length: 10000 }).map((_, idx) => ({
  value: `${idx + 1}`,
  label: `${idx + 1}`,
}))
/*export default {
  name: "applicationForm"
}*/

</script>

<style scoped>
.Healthy-form{
  padding:15px;
}
.el-input{
  width:50%;
}
</style>