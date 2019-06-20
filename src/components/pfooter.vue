<template>
<el-container>
  <el-main class="footer">
    <el-divider></el-divider>
    <el-row type="flex" justify="space-around">
      <el-col :span="6">
        <div>
          <el-link @click="GotoAbout" class="link">关于我们</el-link>
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
  name: 'pfooter',
  methods: {
    GotoAbout : function () {
      this.$router.push('/discover/about')
    }
  }
}
</script>
