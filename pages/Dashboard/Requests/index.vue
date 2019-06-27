<template>
  <div>REQ</div>
</template>

<script>
export default {
  name: 'requests',
  head () {
    return {
      title: '申请 —— PrprClub'
    }
  },
  mounted () {
    this.$router.push('/dashboard/requests/overview')
  }
}
</script>

<style lang="scss" scoped>
@import "~/assets/pink.scss";
</style>
