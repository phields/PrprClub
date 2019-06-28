<template>
  <div>
    <h1>投稿</h1>
  </div>
</template>

<script>
export default {
  name: 'submit',
  middleware: 'authenticated',
  head () {
    return {
      title: '投稿 —— PrprClub'
    }
  }
}
</script>
