<template>
  <div id="app">
    <nuxt/>
    <p-footer></p-footer>
  </div>
</template>

<script>
import PFooter from '~/components/pfooter'
export default {
  name: 'app',
  components: {
    PFooter
  }
}
</script>
