<template>
  <el-container>
    <el-main>
      <el-menu :default-active="activeIndex" mode="horizontal" router class="menu">
        <el-menu-item index="/discover/home">
          <svgicon iconClass="logoBlue" width="134.34" height="60"/>
        </el-menu-item>
        <!-- <el-menu-item index="/discover/home">发现</el-menu-item> -->
        <el-menu-item index="/discover/dynamics">动态</el-menu-item>
        <el-menu-item index="/discover/adoption">领养</el-menu-item>
        <el-menu-item index="/discover/about">关于我们</el-menu-item>
        <el-menu-item index="/dashboard/me" style="float: right;">仪表板</el-menu-item>
      </el-menu>
      <nuxt-child/>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'discover',
  components: {
  },
  mounted: function () {
    this.activeIndex = this.$route.path
  },
  methods: {},
  data: function () {
    return {
      activeIndex: '/discover/home'
    }
  },
  watch: {
    $route (to, from) {
      this.activeIndex = to.path
    }
  }
}
</script>