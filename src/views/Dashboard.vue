<template>
<el-container>
  <el-main>
    <el-menu :default-active="activeIndex" mode="horizontal" router class="menu">
      <el-menu-item index="/dashboard/me">我</el-menu-item>
      <el-menu-item index="/dashboard/works">作品</el-menu-item>
      <el-menu-item index="/dashboard/projects">企划</el-menu-item>
      <el-menu-item index="/dashboard/messages">消息</el-menu-item>
      <el-menu-item index="/dashboard/settings">设置</el-menu-item>
      <span></span>
      <el-menu-item index="/discover">发现</el-menu-item>
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
    this.activeIndex = this.$route.path;
    this.chTheme()
  },
  methods: { chTheme: function () {
    ChangeTheme('#ff48cb', '#409eff')
  }
  },
  data: function () {
    return {
      activeIndex: '/discover/home'
    }
  }
}
</script>
