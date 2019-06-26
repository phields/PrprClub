<template>
  <div>
    <el-row style="margin: 20px;">
      <el-col :span="14">
        <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
             class="image center"
             width="500px"
             height="500px"></el-col>
      <el-col :span="6">
        <h1>登录</h1>
        <el-form ref="form"
                 :model="form"
                 label-width="80px"
                 label-position="right"
                 style="margin: 20px;"
                 v-loading="isLoading"
                 :rules="rules">
          <el-form-item label="手机号"
                        prop="phone">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-form-item label="密码"
                        prop="passwd">
            <el-input v-model="form.passwd"
                      :type="showPasswd ? 'text' : 'password'">
              <svgicon :iconClass="showPasswd ? 'show-passwd' : 'hide-passwd'"
                       width="20"
                       height="15"
                       @click.native="showPasswd = !showPasswd"
                       slot="suffix"
                       alt=""
                       style="cursor: pointer;" />
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-checkbox label="记住我"
                         v-model="form.rememberMe"
                         name="rememberMe"></el-checkbox>
          </el-form-item>
          <el-form-item>
            <el-button type="primary"
                       @click="submit">登录</el-button>
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

// import 'https://recaptcha.net/recaptcha/api.js'

import { ParseUniversal } from '~/parsers/universalParser'

const Cookie = process.client ? require('js-cookie') : undefined

export default {
  middleware: 'notauthenticated',
  data () {
    var checkPhone = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('手机号不能为空'))
      } else {
        const reg = /^1[3|4|5|7|8][0-9]\d{8}$/
        if (reg.test(value)) {
          callback()
        } else {
          return callback(new Error('请输入正确的手机号'))
        }
      }
    }
    return {
      form: {
        phone: '',
        passwd: '',
        rememberMe: false
      },
      isLoading: false,
      showPasswd: false,
      rules: {
        phone: [
          { validator: checkPhone, trigger: 'blur', required: true }
        ],
        passwd: [{
          required: true,
          message: '请输入密码',
          trigger: 'blur'
        }, {
          min: 6,
          max: 20,
          message: '长度在 6 到 20 个字符'
        }, {
          pattern: /^(\w){6,20}$/,
          message: '只能输入6-20个字母、数字、下划线'
        }]
      }
    }
  },
  methods: {
    submit () {
      this.isLoading = true
      this.axios.post('/api/login', {
        phone: this.form.phone,
        captcha: '123456'
      })
        .then(function (response) {
          let result = ParseUniversal(response)
          if (!result.success) {
            this.$router.push({ path: '/error', query: { code: result.code } })
            return
          }
          this.$store.commit('setToken', result.data.token)
          Cookie.set('token', result.data.token)
          this.isLoading = false
          this.$router.push('/')
        }.bind(this))
        .catch(function (error) {
          this.$router.push({ path: '/error', query: { code: -1, err: error } })
        }.bind(this))
    }
  }
}
</script>
