<template>
  <el-main>
    <el-row>
      <h1>新申请</h1>
    </el-row>
    <el-row style="margin: 20px;">
      <el-col :span="18"
              :offset="3">
        <el-steps :active="0"
                  finish-status="success">
          <el-step title="创建申请"></el-step>
          <el-step title="等待许可"></el-step>
        </el-steps>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="18"
              :offset="3"
              v-loading="isLoading">
        <el-form ref="form1"
                 :model="form"
                 :inline="true"
                 :rules="rules"
                 @validate="vali">
          <el-form-item label="我想以"
                        prop="type">
            <el-select v-model="form.type">
              <el-option label="我的立绘作品"
                         value="drawing"></el-option>
              <el-option label="我的Live2D技术"
                         value="live2d"></el-option>
              <el-option label="我的3D模型"
                         value="model"></el-option>
              <el-option label="我自己作为中之人"
                         value="middle"></el-option>
            </el-select>
            <el-form-item label="加入企划"
                          prop="projId">
              <el-input v-model.number="form.projId"
                        type="number"
                        onkeypress="return( /[\d]/.test(String.fromCharCode(event.keyCode) ) )"></el-input>
            </el-form-item>
            <el-form-item>
              <p>没有企划？快去<el-link @click="$router.push('/dashboard/projects/new')">创建企划</el-link>！</p>
            </el-form-item>
          </el-form-item>
        </el-form>
        <el-form ref="form2"
                 :model="form"
                 :inline="true"
                 v-if="form.type === 'drawing' || form.type === 'live2d' || form.type === 'model'"
                 :rules="rules"
                 @validate="vali">
          <el-form-item label="是否需要提供素材"
                        prop="reqType">
            <el-radio-group v-model="form.reqType">
              <el-radio :label="1">我需要提供素材</el-radio>
              <el-radio :label="2">我不需要提供素材</el-radio>
            </el-radio-group>
          </el-form-item>
          <p>若您需要提供素材，则创建申请后，企划的管理者在跟您协商后会提供给您素材；若不需要提供素材，则可直接上传作品并提出申请。</p>
        </el-form>
        <el-form ref="form3"
                 :model="form"
                 :inline="true"
                 v-if="form.reqType === 2"
                 :rules="rules"
                 @validate="vali">
          <el-form-item label="您的作品ID："
                        prop="workId">
            <el-input v-model.number="form.workId"
                      type="number"
                      onkeypress="return( /[\d]/.test(String.fromCharCode(event.keyCode) ) )"></el-input>
          </el-form-item>
        </el-form>
        <el-form :model="form"
                 :inline="true"
                 v-if="form.type === 'middle' || form.reqType === 1">
          <p>只需轻敲“创建”即可创建申请。</p>
        </el-form>
        <el-form :model="form"
                 :inline="true">
          <el-form-item>
            <el-button type="primary"
                       @click="submit"
                       :disabled="!isSubmitEnabled">创建</el-button>
            <el-button @click="$router.go(-1)">取消</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
export default {
  name: 'newRequest',
  head () {
    return {
      title: '创建新申请 —— PrprClub'
    }
  },
  data () {
    return {
      form: {
        type: '',
        projId: '',
        reqType: 0,
        workId: ''
      },
      isLoading: false,
      isSubmitEnabled: false,
      rules: {
        projId: [{
          required: true,
          message: '请输入企划ID',
          trigger: 'blur'
        },
        {
          type: 'number',
          message: '只能输入数字',
          trigger: 'blur'
        }],
        type: [
          {
            required: true,
            message: '请选择一项',
            trigger: 'blur'
          }
        ],
        workId: [{
          validator: (r, v, cb) => {
            if (this.form.reqType !== 2) return cb()
            else if (v && v !== '') return cb()
            else cb(new Error('请输入作品ID'))
          },
          trigger: 'blur'
        }],
        reqType: [
          {
            validator: (r, v, cb) => {
              if (!(this.form.type === 'drawing' || this.form.type === 'live2d' || this.form.type === 'model')) return cb()
              else if (v && v !== '') return cb()
              else cb(new Error('请选择一项'))
            },
            trigger: 'change'
          }
        ]
      }
    }
  },
  methods: {
    submit () {
      let valid = true
      try {
        this.$refs['form1'].validate((v) => {
          valid = v
        })
      } catch (e) {

      }
      if (!valid) {
        this.isSubmitEnabled = false
        return
      }
      try {
        this.$refs['form2'].validate((v) => {
          valid = v
        })
      } catch (e) {

      }
      if (!valid) {
        this.isSubmitEnabled = false
        return
      }
      try {
        this.$refs['form3'].validate((v) => {
          valid = v
        })
      } catch (e) {

      }
      if (!valid) {
        this.isSubmitEnabled = false
        return
      }
      this.isLoading = true
      // DO STH
    },
    vali (o, p, msg) {
      this.isSubmitEnabled = p
    }
  }
}
</script>
