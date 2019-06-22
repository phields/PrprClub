<template>
  <el-dialog :title="work.Name"
             :visible.sync="visible"
             height="90%"
             width="90%"
             v-loading="isLoading"
             @closed="$emit('closed')"
             style="margin: 0; padding: 0;">
    <el-row style="margin: 0; padding: 0; height: 100%; width: 100%;"
            class="center">
      <el-col :span="1">
        <el-button class="slide-button"
                   @click="$emit('go-privious')"></el-button>
      </el-col>
      <el-col :span="22">

        <div style="margin: 0px; padding: 0px;"
             class="center">
          <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
               class="image">
          <div style="padding-top: 14px;">
            <span>好看的画</span>
            <p class="description clearfix">{{work.Name}}</p>
          </div>
        </div>
        <div>
          <el-button type="text"
                     class="button"
                     @click="pushNavigation">详情</el-button>
          <el-button type="text"
                     class="button">Like</el-button>
          <el-button type="text"
                     class="button">Share</el-button>
        </div>
      </el-col>
      <el-col :span="1">
        <el-button class="slide-button"
                   @click="$emit('go-next')"></el-button>
      </el-col>
    </el-row>
  </el-dialog>
</template>

<script>
import { GetWork } from '../parsers/WorkParser'
export default {
  props: ['workId', 'visible'],
  name: 'WorkPopup',
  data () {
    return {
      isLoading: true,
      work: GetWork('0')
    }
  },
  mounted () {
    this.loadData()
  },
  methods: {
    loadData: function () {
      this.isLoading = true
      this.work = GetWork(this.workId)
      this.isLoading = false
    },
    pushNavigation () {
      this.$router.push('/discover/' + this.work.Type + '/' + this.workId)
    }
  },
  watch: {
    workId: function (newId, oldId) {
      this.loadData()
    }
  }
}
</script>

<style scoped lang="scss">
@import "~/assets/card.scss";
</style>
