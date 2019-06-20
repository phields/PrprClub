<template>
  <el-container>
    <el-main>
      <img src="@/assets/bvtb.jpeg" class="headPic">
      <el-menu :default-active="activeIndex" mode="horizontal" router class="menu">
        <el-menu-item>
          <svg-icon iconClass="logoBlue" width="134.34" height="60"/>
        </el-menu-item>
        <el-menu-item index="/discover/home">发现</el-menu-item>
        <el-menu-item index="/discover/dynamics">动态</el-menu-item>
        <el-menu-item index="/discover/adoption">领养</el-menu-item>
        <el-menu-item index="/discover/about">关于我们</el-menu-item>
        <el-menu-item index="/dashboard" style="float: right;">仪表板</el-menu-item>
      </el-menu>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
import { ChangeTheme } from '../ThemePicker'
export default {
  name: 'discover',
  components: {
  },
  mounted: function () {
    this.activeIndex = this.$route.path
    this.chTheme()
  },
  methods: {
    chTheme: function () {
      ChangeTheme('#409eff', '#ff48cb')
    }
  },
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

<style>
.headPic {
  width: 100%;
}
</style>
