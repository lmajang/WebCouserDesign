<script setup>
/*import LoginPage  from './components/LoginPage.vue';*/
</script>

<template>
<router-view></router-view>
  <router-view v-if="isRouterAlive" />
</template>
<script>
export default {
  name: 'App',
  provide() { // 父组件中返回要传给下级的数据
    return {
      reload: this.reload
    }
  },
  data() {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload() {
      this.isRouterAlive = false
      this.$nextTick(function() {
        this.isRouterAlive = true
      })
    }
  }
}
</script>

<style scoped>

</style>
