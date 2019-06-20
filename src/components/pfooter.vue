<template>
<el-container>
  <el-main class="footer">
    <el-divider></el-divider>
    <el-row type="flex" justify="space-around">
      <el-col :span="6">
        <div>
          <router-link to="/about" class="link">关于我们</router-link>
        </div>
      </el-col>
      <el-col :span="6">
        <div>
          Copyright 2019
        </div>
      </el-col>
    </el-row>
  </el-main>
</el-container>
</template>

<script>
export default {
  name: 'pfooter'
}
</script>

<style scoped>
.el-main {
  padding: 0;
}

.link {
  font-size: 14px;
  color: #333;
  text-decoration: none;
}

.footer {
  margin-bottom: 96px;
}
</style>
