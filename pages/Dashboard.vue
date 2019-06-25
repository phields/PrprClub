<template>
  <el-container>
    <el-main>
      <el-row>
        <el-col :span="4">
          <!-- <el-radio-group v-model="isCollapse"
                          style="margin: 20px;">
            <el-radio-button :label="false">展开</el-radio-button>
            <el-radio-button :label="true">收起</el-radio-button>
          </el-radio-group> -->
          <el-menu :default-active="activeIndex"
                   class="el-menu-vertical-demo menu"
                   router
                   :collapse="isCollapse">
            <!-- <el-menu-item index="/dashboard/me">
              <svgicon iconClass="logoPink"
                       width="134.34"
                       height="60" />
            </el-menu-item>-->
            <!-- <el-menu-item index="/dashboard/me">我</el-menu-item> -->
            <el-menu-item @click="isCollapse = !isCollapse"><i :class="iconName"></i></el-menu-item>
            <el-menu-item index="/dashboard/me"><i class="el-icon-s-home"></i><template slot="title">个人中心</template></el-menu-item>
            <el-menu-item index="/dashboard/works"><i class="el-icon-picture-outline-round"></i><template slot="title">作品</template></el-menu-item>
            <el-menu-item index="/dashboard/projects"><i class="el-icon-s-order"></i><template slot="title">企划</template></el-menu-item>
            <el-submenu index="/dashboard/requests">
              <template slot="title"><i class="el-icon-s-ticket"></i><span>申请</span></template>
              <el-menu-item-group>
                <el-menu-item index="/dashboard/requests/overview"><i class="el-icon-finished"></i><template slot="title">概览</template></el-menu-item>
                <el-menu-item index="/dashboard/requests/created"><i class="el-icon-upload2"></i><template slot="title">我创建的</template></el-menu-item>
                <el-menu-item index="/dashboard/requests/received"><i class="el-icon-download"></i><template slot="title"></template>我收到的</el-menu-item>
              </el-menu-item-group>
            </el-submenu>
            <el-menu-item index="/dashboard/messages"><i class="el-icon-chat-line-round"></i><template slot="title">消息</template></el-menu-item>
            <el-submenu index="/dashboard/settings">
              <template slot="title"><i class="el-icon-setting"></i><span>设置</span></template>
              <el-menu-item-group>
                <el-menu-item index="/dashboard/settings/userdetail"><template slot="title"><i class="el-icon-postcard"></i>个人资料</template></el-menu-item>
                <el-menu-item index="/dashboard/settings/image"><template slot="title"><i class="el-icon-s-custom"></i>更改头像</template></el-menu-item>
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
  layout: 'defaultpink',
  head () {
    return {
      title: '仪表板 —— PrprClub'
    }
  },
  components: {},
  mounted: function () {
    this.activeIndex = this.$route.path
  },
  methods: {},
  data: function () {
    return {
      activeIndex: '/discover/home',
      isCollapse: false
    }
  },
  watch: {
    '$route' (to, from) {
      this.activeIndex = to.path
    }
  },
  created: function () {
    this.$router.push('/dashboard/me')
  },
  computed: {
    iconName: function () {
      if (this.isCollapse) return 'el-icon-arrow-right'
      else return 'el-icon-arrow-left'
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~/assets/pink.scss";
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}
</style>
