<template>
  <div>
    <el-row style="margin: 20px;">
      <el-col :span="14">
        <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
             class="image center"
             width="500px"
             height="500px"></el-col>
      <el-col :span="8">
        <h1>欢迎加入~</h1>
        <el-form ref="form"
                 :model="form"
                 label-width="80px"
                 label-position="right"
                 style="margin: 20px;"
                 v-loading="isLoading"
                 :rules="rules"
                 @validate="vali">
          <el-form-item label="昵称"
                        prop="name">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
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
          <el-form-item label="验证码"
                        prop="veri">
            <el-input v-model="form.veri"></el-input>
            <el-button :disabled="!isVeriEnabled"
                       @click="getCode"
                       style="margin: 6px;">{{ veriButtonText + countOutput }}</el-button>
          </el-form-item>
          <el-form-item>
            <p style="margin: 10px">注册即表明您同意我们的<el-link>使用协议</el-link>和<el-link>社区规范</el-link>
            </p>
            <!--嘛这俩文档应该是在教程站吧……弄个什么子域名吧……-->
          </el-form-item>
          <el-form-item>
            <el-button type="primary"
                       @click="submit"
                       :disabled="!isSubmitEnabled">注册</el-button>
            <el-link @click="$router.push('/login')"
                     style="float: right;">登录</el-link>
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
  head () {
    return {
      title: '注册 —— PrprClub'
    }
  },
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
        name: '',
        phone: '',
        passwd: '',
        veri: ''
      },
      isLoading: false,
      showPasswd: false,
      veriButtonText: '获取验证码',
      isVeriEnabled: true,
      count: '',
      timer: null,
      isSubmitEnabled: true,
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
        }],
        veri: [
          {
            required: true,
            message: '请输入验证码',
            trigger: 'blur'
          }, {
            min: 6,
            max: 6,
            message: '长度为6位'
          }
        ],
        name: [
          {
            required: true,
            message: '请输入昵称',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  methods: {
    submit () {
      let valid = false
      this.$refs['form'].validate((v) => {
        valid = v
      })
      if (!valid) {
        this.isSubmitEnabled = false
        return
      }
      this.isLoading = true
      this.axios.post('/api/register', {
        phone: this.form.phone,
        password: this.form.passwd,
        verifyCode: '123456',
        username: ''
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
    },
    getCode () {
      const TIME_COUNT = 60
      if (!this.timer) {
        this.axios.post('/api/send_verify', {
          phone: this.form.phone,
          captcha: '123456'
        })
          .catch(function (error) {
            this.$router.push({ path: '/error', query: { code: -1, err: error } })
          }.bind(this))
        this.count = TIME_COUNT
        this.isVeriEnabled = false
        this.timer = setInterval(() => {
          if (this.count > 0 && this.count <= TIME_COUNT) {
            this.count--
          } else {
            this.isVeriEnabled = true
            clearInterval(this.timer)
            this.timer = null
          }
        }, 1000)
      }
    },
    vali (o, p, msg) {
      this.isSubmitEnabled = p
    }
  },
  computed: {
    countOutput () {
      if (this.count > 0) return '（' + this.count + '）'
      else return ''
    }
  }
}
</script>
