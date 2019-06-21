<template>
<el-container>
  <el-main>
    <el-menu :default-active="activeIndex" mode="horizontal" router class="menu">
        <el-menu-item index="/dashboard/me">
          <svgicon iconClass="logoPink" width="134.34" height="60"/>
        </el-menu-item>
      <!-- <el-menu-item index="/dashboard/me">我</el-menu-item> -->
      <el-menu-item index="/dashboard/works">作品</el-menu-item>
      <el-menu-item index="/dashboard/projects">企划</el-menu-item>
      <el-menu-item index="/dashboard/messages">消息</el-menu-item>
      <el-menu-item index="/dashboard/settings">设置</el-menu-item>
      <el-menu-item index="/discover/home" style="float: right;">发现</el-menu-item>
    </el-menu>
    <nuxt-child/>
  </el-main>
</el-container>
</template>

<script>
import { ChangeTheme } from '../utils/ThemePicker'
export default {
  name: 'discover',
  components: {
  },
  mounted: function () {
    this.activeIndex = this.$route.path
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
  },
  watch: {
    '$route' (to, from) {
      this.activeIndex = to.path
    }
  }
}
</script>
