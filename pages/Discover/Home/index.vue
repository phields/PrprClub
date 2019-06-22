<template>
  <div>
    <el-main>
      <el-row>
        <!--Interval自定呗，card只适用于长宽比距离1比较近的图像 :interval="4000" type="card"-->
        <el-carousel trigger="click"
                     height="200px">
          <el-carousel-item v-for="item in 4"
                            :key="item">
            <img src="@/assets/bvtb.jpeg"
                 class="headPic">
          </el-carousel-item>
        </el-carousel>
      </el-row>
      <el-row>
        <el-col :span="8">
          <h2>立绘排行榜</h2>
          <work-card v-for="o in 10"
                     :key="o"
                     @click="open(o)"
                     :workId="o"
                     size="120px"></work-card>
        </el-col>
        <el-col :span="8">
          <h2>Live2D排行榜……嘛在这个最显眼的地方插一句嘴：这可都是组件基的啊……</h2>
          <work-card v-for="o in 10"
                     :key="o"
                     @click="open(o)"
                     :workId="o"
                     size="70px"></work-card>
        </el-col>
        <el-col :span="8">
          <h2>3D模型排行榜</h2>
          <work-card v-for="o in 10"
                     :key="o"
                     @click="open(o)"
                     :workId="o"
                     size="90px"></work-card>
        </el-col>
      </el-row>
    </el-main>
    <work-popup :workId="workId"
                :visible="popupVisible"
                @go-privious="workId"
                @go-next="workId"
                @closed="popupVisible = false"></work-popup>
  </div>
</template>

<script>
export default {
  data () {
    return {
      workId: '0',
      popupVisible: false
    }
  },
  methods: {
    open (id) {
      this.workId = id
      this.popupVisible = true
    }
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

.headPic {
  width: 100%;
}

h2 {
  text-align: center;
}
</style>
