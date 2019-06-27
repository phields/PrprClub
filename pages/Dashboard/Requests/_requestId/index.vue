<template>
  <el-main>
    <el-row>
      <h1>新申请</h1>
    </el-row>
    <el-row>
      <el-steps :active="2"
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
  beforeCreate () {
    // 如果此申请的表单信息尚未填写完整
    this.$router.push('/dashboard/requests/' + this.$route.params.requestId + '/detail')
  }
}
</script>

<style>
el-row {
  margin: 20px;
}
</style>
