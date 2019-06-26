<template>
  <div>
    <el-row style="margin: 20px;">
      <el-col :span="14">
        <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
             class="image center"
             width="500px"
             height="500px"></el-col>
      <el-col :span="6">
        <el-form ref="form"
                 :model="form"
                 label-width="80px"
                 label-position="right"
                 style="margin: 20px;"
                 v-loading="isLoading">
          <el-form-item label="手机号">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="form.passwd"
                      type="password"></el-input>
          </el-form-item>
          <el-form-item>
            <el-checkbox label="记住我"
                         v-model="form.rememberMe"
                         name="rememberMe"></el-checkbox>
          </el-form-item>
          <el-form-item>
            <el-button type="primary"
                       @click="onSubmit">登录</el-button>
            <el-button @click="$router.push('/register')">注册</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import 'vue'
import 'axios'
import 'vue-axios'

import 'https://recaptcha.net/recaptcha/api.js'

import { ParseUniversal } from '~/parsers/universalParser'

const Cookie = process.client ? require('js-cookie') : undefined

export default {
  middleware: 'notauthenticated',
  data () {
    return {
      form: {
        phone: '',
        passwd: '',
        rememberMe: false
      },
      isLoading: false
    }
  },
  methods: {
    onSubmit () {
      this.isLoading = true
      this.axios.post('/api/login', {
        phone: this.form.phone,
        captcha: ''
      })
        .then(function (response) {
          // this.$store.commit('setToken', JSON.parse(response).token)
          let result = ParseUniversal(response)
          if (!result.success) {
            this.$router.push({ path: '/error', query: { code: result.code } })
            return
          }
          this.$store.commit('setToken', result.data.token)
        })
        .catch(function (error) {
          console.log(error)
        })

      Cookie.set('token', '')
      this.$router.push('/')
      this.isLoading = false
    }
  }
}
</script>
