<template>
  <div>
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
  created () {
    this.result = ParseUniversal(JSON.stringify('{"code": ' + this.$router.query.code + '}')).msg
  },
  data () {
    return {
      result: ''
    }
  }
}
</script>
