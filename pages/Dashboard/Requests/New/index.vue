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
              :offset="3">
        <el-form :model="form"
                 :inline="true">
          <el-form-item label="我想以">
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
            <el-form-item label="加入企划">
              <el-input v-model="form.projId"></el-input>
            </el-form-item>
            <el-form-item>
              <p>没有企划？快去<el-link @click="$router.push('/dashboard/projects/new')">创建企划</el-link>！</p>
            </el-form-item>
          </el-form-item>
        </el-form>
        <el-form :model="form">

          <el-form-item>
            <el-button type="primary"
                       @click="onSubmit">创建</el-button>
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
        projId: ''
      }
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~/assets/pink.scss";
</style>
