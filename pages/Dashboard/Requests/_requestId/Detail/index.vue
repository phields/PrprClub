<template>
  <el-main>
    <el-row>
      <h1>新申请</h1>
    </el-row>
    <el-row>
      <el-steps :active="1"
                finish-status="success">
        <el-step title="创建申请"></el-step>
        <el-step title="填写信息"></el-step>
        <el-step title="等待许可"></el-step>
      </el-steps>
    </el-row>
  </el-main>
</template>

<script>
export default {
  head () {
    return {
      title: '创建新申请 —— PrprClub'
    }
  }
}
</script>

<style>
el-row {
  margin: 20px;
}
</style>
