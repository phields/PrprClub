<template>
  <div>
    <h1>大家好我是ID为{{$route.params.drawingId}}的立绘的页面。</h1>
  </div>
</template>

<script>
export default {
  head () {
    return {
      title: '立绘' + this.$route.params.drawingId + ' —— PrprClub'
    }
  },
  validate ({ params }) {
    return /^\d+$/.test(params.drawingId)
  }
}
</script>
