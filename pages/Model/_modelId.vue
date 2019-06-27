<template>
  <div>
    <h1>大家好我是一个ID是{{$route.params.modelId}}的“3D模型”页面。</h1>
  </div>
</template>

<script>
export default {
  head () {
    return {
      title: '3D模型' + this.$route.params.modelId + ' —— PrprClub'
    }
  },
  validate ({ params }) {
    return /^\d+$/.test(params.id)
  }
}
</script>
