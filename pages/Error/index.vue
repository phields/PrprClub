<template>
  <div class="center"
       style="margin: 20px">
    <el-row>
      <h1>啊嘞，出错了！</h1>
    </el-row>
    <el-row>
      <h2>{{ result }}</h2>
    </el-row>
    <el-row>
      <el-button type="primary"
                 @click="$router.go(-1)">返回</el-button>
    </el-row>
  </div>
</template>

<script>
import { ParseUniversal } from '~/parsers/universalParser'
export default {
  mounted () {
    this.result = ParseUniversal(JSON.stringify('{"code": ' + this.$route.query.code + '}')).msg
    if (this.$route.query.err) this.result += JSON.parse(JSON.stringify(this.$route.query.err))
    // if (this.result === '' || !this.result) this.result = '!!!'
  },
  data () {
    return {
      result: ''
    }
  }
  // ,
  // beforeRouteUpdate (to) {
  //   this.result = ParseUniversal(JSON.stringify('{"code": ' + to.query.code + '}')).msg
  //   if (to.query.err) this.result += JSON.parse(JSON.stringify(to.query.err))
  // },
  // watch: {
  //   '$route' (to, from) {
  //     if (to.path === '/promotions') {
  //       this.$store.dispatch('getAllPromotions')
  //     } else if (to.path === '/promotions/coupon') {
  //       this.$store.dispatch('getAllPromotions', {
  //         type: 'coupon'
  //       })
  //     }
  //   }
  // }
}
</script>
