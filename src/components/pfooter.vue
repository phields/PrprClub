<template>
<el-container>
  <el-main class="footer">
    <el-divider></el-divider>
    <el-row type="flex" justify="space-around">
      <el-col :span="6">
        <div>
          <router-link to="/discover/about" class="link">关于我们</router-link>
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
