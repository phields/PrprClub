<template>
  <div>
    <h1>大家好，我是练习时长两年半的偶像练习生，“个人中心”页面。</h1>
    <el-button style="margin: 10px;"
               @click="$store.commit('setToken', ''); $router.push('/'); $cookies.remove('token')">安全退出</el-button>
  </div>
</template>

<style lang="scss" scoped>
@import "~/assets/pink.scss";
</style>
