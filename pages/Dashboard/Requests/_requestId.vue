<template>
  <nuxt-child />
</template>

<script>
export default {
  head () {
    return {
      title: '申请' + this.$route.params.requestId + ' —— PrprClub'
    }
  },
  validate ({ params }) {
    return /^\d+$/.test(params.requestId)
  }
}
</script>
