<template>
  <div>
    <h1>Overview</h1>
    <el-button type="primary"
               @click="$router.push('/dashboard/requests/new')">创建新申请</el-button>
    <el-button @click="$router.push('/dashboard/requests/123')"
               style="margin: 20px">前往申请123</el-button>
  </div>
</template>

<script>
export default {
  head () {
    return {
      title: '申请概览 —— PrprClub'
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~/assets/pink.scss";
</style>
