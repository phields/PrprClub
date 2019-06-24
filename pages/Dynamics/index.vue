<template>
  <div>
    <el-main>
      <el-row>
        <el-col :span="4" :offset="3">
          <work-card v-for="o in 10" :key="o" @click="open(o)" :workId="o" size="120px"></work-card>
        </el-col>
        <el-col :span="10">
          <work-card v-for="o in 10" :key="o" @click="open(o)" :workId="o" size="70px"></work-card>
        </el-col>
        <el-col :span="3">
          <work-card v-for="o in 10" :key="o" @click="open(o)" :workId="o" size="90px"></work-card>
        </el-col>
      </el-row>
    </el-main>
    <el-button @click="popupVisible = true">Click Me!</el-button>
    <work-popup
      :workId="workId"
      :visible="popupVisible"
      @go-privious="workId"
      @go-next="workId"
      @closed="popupVisible = false"
    ></work-popup>
  </div>
</template>

<script>
export default {
  data() {
    return {
      workId: '0',
      popupVisible: false
    }
  },
  methods: {
    open(id) {
      this.workId = id
      this.popupVisible = true
    }
  }
}
</script>
