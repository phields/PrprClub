<template>
  <el-dialog title="提示" :visible.sync="visible" height="90%" width="90%" v-loading="isLoading"
  @closed="$emit('closed')" style="margin: 0; padding: 0;">
  <el-row style="margin: 0; padding: 0; height: 100%; width: 100%;">
    <el-col :span="1"><el-button class="slide-button" @click="$emit('go-privious')"></el-button></el-col>
    <el-col :span="22"><h1 style="height: 300px;">{{work.Name}}</h1></el-col>
    <el-col :span="1"><el-button class="slide-button" @click="$emit('go-next')"></el-button></el-col>
  </el-row>
  </el-dialog>
</template>

<script>
import { GetWork } from '../parsers/WorkParser'
export default {
  props: ['workId', 'visible'],
  name: 'WorkPopup',
  data() {
    return {
      isLoading: true,
      work: GetWork('0')
    }
  },
  mounted() {
    this.loadData()
  },
  methods: {
    loadData: function() {
      this.isLoading = true
      this.work = GetWork(this.workId)
      this.isLoading = false
    }
  },
  watch: {
    workId: function(newId, oldId) {
      this.loadData()
    }
  }
}
</script>

<style lang="sass">

</style>
