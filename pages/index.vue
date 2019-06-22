<template>
  <div></div>
</template>

<script>
export default {
  created: function() {
    let isSignedIn = false
    // 在此判断是否登录
    if (isSignedIn) this.$router.push('/dashboard/me')
    else this.$router.push('/discover/home')
  }
}
</script>
