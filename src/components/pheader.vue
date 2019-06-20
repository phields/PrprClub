<template>
<el-container>
  <el-main>
    <img src="@/assets/bvtb.jpeg" class="headPic">
    <el-menu :default-active="activeIndex" mode="horizontal" router class="menu">
      <el-menu-item index="/">首页</el-menu-item>
      <el-menu-item index="/about">关于我们</el-menu-item>
    </el-menu>
  </el-main>
</el-container>
</template>

<script>
export default {
  name: 'pheader',
  computed: {
    activeIndex() {
      return this.$route.path
    }
  }
}
</script>

<style scoped>
.headPic {
  width: 100%;
}

.el-main {
  padding: 0;
}

.menu {
  margin: 0 20px;
}
</style>
