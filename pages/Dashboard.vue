<template>
  <el-container>
    <el-main>
      <el-row>
        <el-col :span="4">

          <el-menu :default-active="activeIndex"
                   class="el-menu-vertical-demo menu"
                   router>
            <!-- <el-menu-item index="/dashboard/me">
              <svgicon iconClass="logoPink"
                       width="134.34"
                       height="60" />
            </el-menu-item>-->
            <!-- <el-menu-item index="/dashboard/me">我</el-menu-item> -->
            <el-menu-item index="/dashboard/me"><i class="el-icon-s-home"></i>个人中心</el-menu-item>
            <el-menu-item index="/dashboard/works"><i class="el-icon-picture-outline-round"></i>作品</el-menu-item>
            <el-menu-item index="/dashboard/projects"><i class="el-icon-s-order"></i>企划</el-menu-item>
            <el-menu-item index="/dashboard/messages"><i class="el-icon-chat-line-round"></i>消息</el-menu-item>
            <el-submenu index="/dashboard/settings">
              <template slot="title"><i class="el-icon-setting"></i><span>设置</span></template>
              <el-menu-item-group>
                <el-menu-item index="/dashboard/settings/userdetail">个人资料</el-menu-item>
                <el-menu-item index="/dashboard/settings/image">更改头像</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-col>
        <el-col :span="20">
          <nuxt-child />
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'discover',
  components: {},
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
    '$route' (to, from) {
      this.activeIndex = to.path
    }
  },
  created: function () {
    this.$router.push('/dashboard/me')
  }
}
</script>
<style lang="scss" scoped>
@import "~/assets/pink.scss";
</style>
