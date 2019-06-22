<template>
  <el-card class="card" shadow="hover">
    <div style="margin: 0px; padding: 0px; cursor: pointer;" @click="$emit('click')">
      <img
        src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
        class="image"
        :width="size"
        :height="size"
      >
      <div style="padding-top: 14px;">
        <span>好看的画</span>
        <p class="description clearfix">{{work.Name}}</p>
      </div>
      <el-divider></el-divider>
    </div>
    <div>
      <el-button type="text" class="button" @click="pushNavigation">详情</el-button>
      <el-button type="text" class="button">Like</el-button>
      <el-button type="text" class="button">Share</el-button>
    </div>
  </el-card>
</template>

<script>
import { GetWork } from '../parsers/WorkParser'
export default {
  props: ['workId', 'size'],
  name: 'WorkCard',
  data() {
    return {
      work: GetWork('0')
    }
  },
  mounted() {
    this.loadData()
  },
  methods: {
    loadData: function() {
      this.work = GetWork(this.workId)
    },
    pushNavigation() {
      this.$router.push('/discover/' + this.work.Type + '/' + this.workId)
    }
  },
  watch: {
    workId: function(newId, oldId) {
      this.loadData()
    }
  }
}
</script>

<style>
.description {
  font-size: 13px;
  color: #999;
}

.button {
  margin: 3px;
  float: right;
}

.image {
  position: relative;
  text-align: center;
  vertical-align: middle;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}

.card {
  margin: 12px;
  position: relative;
  text-align: center;
  vertical-align: middle;
}

h2 {
  text-align: center;
}
</style>
