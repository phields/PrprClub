<template>
  <el-main>
    <el-row>
      <h1>新申请</h1>
    </el-row>
    <el-row>
      <el-col :span="18"
              :offset="3">
        <el-steps :active="status"
                  finish-status="success">
          <el-step title="创建申请"></el-step>
          <el-step title="等待许可"></el-step>
        </el-steps>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
export default {
  data () {
    return {
      status: 1
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~/assets/pink.scss";
</style>
