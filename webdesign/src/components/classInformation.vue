<template>
  <el-table :data="tableData" border style="width: 100%">
    <el-table-column prop="academy" label="学院" width="180" ></el-table-column>
    <el-table-column prop="id" label="id" width="180" ></el-table-column>
    <el-table-column prop="major" label="专业" width="180" ></el-table-column>
    <el-table-column prop="name" label="班级" width="180" ></el-table-column>
  </el-table>
</template>

<script>
export default {
  name: "classInformation",
  data(){
    return {
      tableData:[]
    }
  },
  mounted() {
    this.getData()
  },
  methods:{
    getData(){
      this.$ajax.post("/classinformation",sessionStorage.getItem('no')).then(responed=>{
        console.log(responed.data);
        this.tableData=responed.data;
      }).catch(error=>{
        console.log(error);
      })
    }
  }
}
</script>

<style scoped>

</style>