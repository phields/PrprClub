<template>
  <el-container>
    <el-main>
        <img src="@/assets/bvtb.jpeg" class="headPic">
        <el-menu default-active="/discover/home" mode="horizontal" router class="menu">
          <el-menu-item index="/discover/home">发现</el-menu-item>
          <el-menu-item index="/discover/dynamics">动态</el-menu-item>
          <el-menu-item index="/discover/adoption">领养</el-menu-item>
          <el-menu-item index="/discover/about">关于我们</el-menu-item>
          <span></span>
          <el-menu-item index="/dashboard">仪表板</el-menu-item>
        </el-menu>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
import { ChangeTheme } from '../ThemePicker'
export default {
  name: 'discover',
  mounted: function () {
    this.chTheme()
  },
  methods: {
    chTheme: function () {
      ChangeTheme('#409eff', '#ff48cb')
    }
  }
}
</script>
