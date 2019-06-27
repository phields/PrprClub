<template>
  <div>
    <h1>大家好我是ID为{{$route.params.l2DId}}的“L2D模型”页面。</h1>
  </div>
</template>

<script>
export default {
  head () {
    return {
      title: '模型' + this.$route.params.l2DId + ' —— PrprClub'
    }
  },
  validate ({ params }) {
    return /^\d+$/.test(params.l2DId)
  }
}
</script>
