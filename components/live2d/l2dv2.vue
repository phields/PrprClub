<template>
  <div>
    <canvas id="glcanvas"
            :width="width"
            :height="height"
            style="border:dashed 1px #CCC">
    </canvas>
  </div>
</template>

<script>
import '~/renderer/live2d/live2d.min.js'
import '~/renderer/live2d/Live2DFramework.js'
import { sampleApp1 } from '~/renderer/live2d/live2d_sdk2.js'
export default {
  name: 'l2dv2',
  props: ['height', 'width'],
  created () {
    sampleApp1()
    // AT: BACK_IMAGE_NAME: "assets/image/back_class_normal.png",
    // AT: MODEL_HARU: "assets/live2d/mod/mod.model.json",
  }
}
</script>

  <style>
html,
body {
  oveflow: hidden;
  height: 100%;
}

body {
  margin: 0px;
  padding: 0px;
}

#glcanvas {
  /*
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                */
  background-size: 150%;
  background-position: 50% 50%;
  background-image: url(assets/image/back_class_normal.png);
}

button {
  font-family: Arial, Helvetica, sans-serif;
  font-size: 14px;
  color: #ffffff;
  padding: 10px 20px;
  -moz-border-radius: 30px;
  -webkit-border-radius: 30px;
  border-radius: 30px;
  -moz-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5),
    inset 0px 0px 1px rgba(255, 255, 255, 0.7);
  -webkit-box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5),
    inset 0px 0px 1px rgba(255, 255, 255, 0.7);
  box-shadow: 0px 1px 3px rgba(0, 0, 0, 0.5),
    inset 0px 0px 1px rgba(255, 255, 255, 0.7);
  text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.4),
    0px 1px 0px rgba(255, 255, 255, 0.3);
}

button.active {
  background: linear-gradient(to bottom, #3498db, #2980b9);
  background: -moz-linear-gradient(top, #3498db 0%, #2980b9);
  background: -webkit-gradient(
    linear,
    left top,
    left bottom,
    from(#3498db),
    to(#2980b9)
  );
  border: 1px solid #2980b9;
}

button.inactive {
  background: linear-gradient(to bottom, #e74c3c, #c0392b);
  background: -moz-linear-gradient(top, #e74c3c 0%, #c0392b);
  background: -webkit-gradient(
    linear,
    left top,
    left bottom,
    from(#e74c3c),
    to(#c0392b)
  );
  border: 1px solid #c0392b;
}
</style>
