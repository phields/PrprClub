<template>
  <div>
    <canvas id="SAMPLE"
            :width="width"
            :height="height">
      Live2D Canvas未正确加载。
    </canvas>
  </div>
</template>

<script>
import 'https://cdn.jsdelivr.net/npm/promise-polyfill@8/dist/polyfill.min.js'
import '~/renderer/live2d/live2dcubismcore.min.js'
import { main } from '~/renderer/live2d/live2d_sdk3.js'
export default {
  name: 'l2dv3',
  props: ['height', 'width'],
  created () {
    main()
    // AT: './res/mod/mod.model3.json'
  }
}
</script>
