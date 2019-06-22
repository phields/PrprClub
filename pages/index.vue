<template></template>

<script>
export default {
  created: function() {
    // 在此判断是否登录
    if (false) this.$router.push('/dashboard/me')
    else this.$router.push('/discover/home')
  }
}
</script>
