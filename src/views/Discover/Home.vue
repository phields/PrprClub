<template>
  <div>
    <el-main>
      <el-row>
        <el-carousel height="150px">
          <el-carousel-item v-for="item in 4" :key="item">
            <!--Content Here-->
          </el-carousel-item>
        </el-carousel>
      </el-row>
    </el-main>
  </div>
</template>

<style>

  .el-carousel__item:nth-child(2n) {
     background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
     background-color: #d3dce6;
  }
</style>
