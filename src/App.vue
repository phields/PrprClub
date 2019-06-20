<template>
  <div id="app">
    <router-view/>
    <p-footer></p-footer>
  </div>
</template>

<script>
import PFooter from '@/components/pfooter'

export default {
  name: 'app',
  components: {
    PFooter
  }
}
</script>

<style lang="scss">
* {
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
}

html {
  margin: 0;
  width: 100%;
  height: 100%;
}

body {
    margin: 0;
  width: 100%;
  height: 100%;
}

h1 {
  font-size: 32px;
}

h1>small {
  font-size: 20px;
  color: gray;
}

.el-main {
  padding: 0;
  margin: 0;
}

.menu {
  margin: 0;
}
</style>
