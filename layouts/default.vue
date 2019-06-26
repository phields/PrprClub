<template>
  <div id="app">
    <el-menu :default-active="activeIndex"
             mode="horizontal"
             router
             class="menu">
      <el-menu-item index="/"
                    @click="checkReload('/')">
        <svgicon iconClass="logoBlue"
                 width="134.34"
                 height="60" />
      </el-menu-item>
      <!-- <el-menu-item index="/">发现</el-menu-item> -->
      <el-menu-item index="/dynamics"
                    @click="checkReload('/dynamics')"><i class="el-icon-s-promotion"></i>动态</el-menu-item>
      <el-menu-item index="/drawing"
                    @click="checkReload('/drawing')"><i class="el-icon-picture-outline-round"></i>立绘</el-menu-item>
      <el-menu-item index="/live2d"
                    @click="checkReload('/live2d')"><i class="el-icon-help"></i>Live2D</el-menu-item>
      <el-menu-item index="/model"
                    @click="checkReload('/model')"><i class="el-icon-video-camera"></i>3D模型</el-menu-item>
      <el-menu-item index="/project"
                    @click="checkReload('/project')"><i class="el-icon-s-order"></i>企划</el-menu-item>
      <el-menu-item index="/space"
                    @click="checkReload('/space')"><i class="el-icon-s-custom"></i>创作者</el-menu-item>
      <el-menu-item index="/adoption"
                    @click="checkReload('/adoption')"><i class="el-icon-circle-plus-outline"></i>领养</el-menu-item>
      <!-- <el-menu-item index="/about">关于我们</el-menu-item> -->
      <el-menu-item index="/submit"
                    @click="checkReload('/submit')"
                    style="float: right;"><i class="el-icon-upload2"></i></el-menu-item>
      <el-menu-item index="/dashboard/me"
                    class="icon_img_div"
                    @click="checkReload('/dashboard/me')"
                    style="float: right;"><img :src="icon"
             class="icon_img"
             height="60px"
             width="60px" /></el-menu-item>
      <!-- <el-menu-item index="/dashboard/me"
                      style="float: right;"><i class="el-icon-set-up"></i>仪表板</el-menu-item> -->
    </el-menu>
    <nuxt v-if="isRouterAlive" />
    <el-divider></el-divider>
    <el-row type="flex"
            justify="space-around">
      <el-col :span="6">
        <div>
          <el-link @click="GotoAbout"
                   class="link"><i class="el-icon-office-building
"></i>关于我们</el-link>
        </div>
      </el-col>
      <el-col :span="6">
        <div>
          Copyright PrprClub 2019
        </div>
      </el-col>
    </el-row>
    <el-row style="height: 24px;"></el-row>
  </div>
</template>

<script>
const reload = Symbol(1)

export default {
  name: 'app',
  mounted: function () {
    // this.activeIndex = this.$route.path
    this.switchNav(this.$route.path)
  },
  provide () {
    return {
      [reload]: this.reload
    }
  },
  methods: {
    checkReload (i) {
      if (i === this.$route.path) this.reload()
    },
    reload () {
      this.isRouterAlive = false
      this.$nextTick(function () {
        this.isRouterAlive = true
      })
    },
    GotoAbout: function () {
      this.$router.push('/about')
    },
    switchNav (p) {
      try {
        p.split('/').forEach(element => {
          let finished = true
          switch (element) {
            case 'home':
              this.activeIndex = '/'
              break
            case 'dynamics':
              this.activeIndex = '/dynamics'
              break
            case 'drawing':
              this.activeIndex = '/drawing'
              break
            case 'live2d':
              this.activeIndex = '/live2d'
              break
            case 'model':
              this.activeIndex = '/model'
              break
            case 'project':
              this.activeIndex = '/project'
              break
            case 'space':
              this.activeIndex = '/space'
              break
            case 'adoption':
              this.activeIndex = '/adoption'
              break
            case 'submit':
              this.activeIndex = '/submit'
              break
            default:
              this.activeIndex = '/'
              finished = false
              break
          }
          if (finished) {
            throw new Error('***THIS IS NOT A ERROR***SwitchNav() Complete. ')
          }
        })
      } catch (e) { }
      if (p.indexOf('dashboard') >= 0 || 
      p.indexOf('login') >= 0 || 
      p.indexOf('register') >= 0) this.activeIndex = '/dashboard/me'
    }
  },
  data: function () {
    return {
      activeIndex: '/',
      icon: 'https://static.hdslb.com/images/member/noface.gif',
      isRouterAlive: true
    }
  },
  watch: {
    '$route' (to, from) {
      // this.activeIndex = to.path
      this.switchNav(to.path)
    }
  }
}
</script>
