<template>
  <div>
    <h1>{{$route.params.requestId}}</h1>
  </div>
</template>

<script>
export default {
  head () {
    return {
      title: '申请' + this.$route.params.requestId + ' —— PrprClub'
    }
  }
}
</script>
