<template>
  <div>
    <h1>大家好我是一位用户ID是{{$route.params.authorId}}的“个人空间”页面。</h1>
  </div>
</template>

<script>
export default {
  head () {
    return {
      title: this.$route.params.authorId + '的空间 —— PrprClub'
    }
  },
  validate ({ params }) {
    return /^\d+$/.test(params.id)
  }
}
</script>
