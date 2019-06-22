<template>
  <el-container>
    <el-main>
      <el-menu :default-active="activeIndex" mode="horizontal" router class="menu">
        <el-menu-item index="/discover/home">
          <svgicon iconClass="logoBlue" width="134.34" height="60"/>
        </el-menu-item>
        <!-- <el-menu-item index="/discover/home">发现</el-menu-item> -->
        <el-menu-item index="/discover/dynamics">动态</el-menu-item>
        <el-menu-item index="/discover/drawing">立绘</el-menu-item>
        <el-menu-item index="/discover/live2d">Live2D</el-menu-item>
        <el-menu-item index="/discover/model">3D模型</el-menu-item>
        <el-menu-item index="/discover/project">企划</el-menu-item>
        <el-menu-item index="/discover/space">创作者</el-menu-item>
        <el-menu-item index="/discover/adoption">领养</el-menu-item>
        <!-- <el-menu-item index="/discover/about">关于我们</el-menu-item> -->
        <el-menu-item index="/dashboard/me" style="float: right;">仪表板</el-menu-item>
      </el-menu>
      <nuxt-child/>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'discover',
  components: {},
  mounted: function() {
    // this.activeIndex = this.$route.path
    this.switchNav(this.$route.path)
  },
  methods: {
    switchNav(p) {
      try {
        p.split('/').forEach(element => {
          let finished = true
          switch (element) {
            case 'home':
              this.activeIndex = '/discover/home'
              break
            case 'dynamics':
              this.activeIndex = '/discover/dynamics'
              break
            case 'drawing':
              this.activeIndex = '/discover/drawing'
              break
            case 'live2d':
              this.activeIndex = '/discover/live2d'
              break
            case 'model':
              this.activeIndex = '/discover/model'
              break
            case 'project':
              this.activeIndex = '/discover/project'
              break
            case 'space':
              this.activeIndex = '/discover/space'
              break
            case 'adoption':
              this.activeIndex = '/discover/adoption'
              break
            default:
              this.activeIndex = '/discover/home'
              finished = false
              break
          }
          if (finished) {
            throw new Error('***THIS IS NOT A ERROR***SwitchNav() Complete. ')
          }
        })
      } catch (e) {}
    }
  },
  data: function() {
    return {
      activeIndex: '/discover/home'
    }
  },
  watch: {
    $route(to, from) {
      this.switchNav(to.path)
    }
  }
}
</script>
