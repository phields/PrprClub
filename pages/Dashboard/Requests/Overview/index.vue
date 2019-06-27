<template>
  <div>
    <h1>Overview</h1>
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
