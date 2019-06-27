<template>
  <div>
    <h1>大家好我是一位企划ID是{{$route.params.projectId}}的企划页面。</h1>
  </div>
</template>

<script>
export default {
  head () {
    return {
      title: '企划' + this.$route.params.projectId + ' —— PrprClub'
    }
  },
  validate ({ params }) {
    return /^\d+$/.test(params.projectId)
  }
}
</script>
