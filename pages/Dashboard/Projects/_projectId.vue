<template>
  <nuxt-child />
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
