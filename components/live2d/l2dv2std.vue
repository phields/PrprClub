<template>
  <div>
    <canvas id="live2d"
            :width="width"
            :height="height">
      Live2D Canvas未正确加载。
    </canvas>
  </div>
</template>

<!--<script src="~/renderer/live2d/live2d_sdk2_stdalone.js"></script>-->

<script>
import { loadlive2d } from '~/renderer/live2d/live2d_sdk2_stdalone.js'
export default {
  name: 'l2dv2std',
  props: ['height', 'width', 'src'],
  created () {
    loadlive2d('live2d', this.src)
    // Eg: ~/Resources/Hiyori/Hiyori.model3.json
  }
}
</script>
