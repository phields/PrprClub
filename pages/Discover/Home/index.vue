<template>
  <div>
    <el-main>
      <el-row>
        <!--Interval自定呗，card只适用于长宽比距离1比较近的图像 :interval="4000" type="card"-->
        <el-carousel trigger="click" height="200px">
          <el-carousel-item v-for="item in 4" :key="item">
            <img src="@/assets/bvtb.jpeg" class="headPic">
          </el-carousel-item>
        </el-carousel>
      </el-row>
      <el-row><el-button @click="popupVisible = true">Click Me! </el-button></el-row>
    </el-main>
    <work-popup :workId="workId" :visible="popupVisible" @go-privious="workId--" @go-next="workId++"
    @closed="popupVisible = false"></work-popup>
  </div>
</template>

<script>
export default {
  data() {
    return {
      workId: 0,
      popupVisible: false
    }
  },
  methods: {
  }
}
</script>

<style>
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
