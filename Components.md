# Il Harper 的组件使用说明

## work-popup

```html
<el-button @click="popupVisible = true">Click Me! </el-button>

<work-popup
  :workId="workId"
  :visible="popupVisible"
  @go-privious="workId"
  @go-next="workId"
  @closed="popupVisible = false"
></work-popup>

<script>
  export default {
    data() {
      return {
        workId: '0',
        popupVisible: false
      };
    },
    methods: {
      open(id) {
        this.workId = id;
        this.popupVisible = true;
      }
    }
  };
</script>
```

## work-card

```html
<work-card
  v-for="o in 10"
  :key="o"
  @click="open(o)"
  :workId="o"
  size="120px"
></work-card>

<script>
  export default {
    data() {
      return {
        workId: '0',
        popupVisible: false
      };
    },
    methods: {
      open(id) {
        this.workId = id;
        this.popupVisible = true;
      }
    }
  };
</script>
```

## 这……project-popup 和 project-card 同理

## <l2dv2std>

```html
<l2dv2std height="768" width="1366" src="~/Resources/Hiyori/Hiyori.model3.json"></l2dv2std>
```

## <l2dv2>

```html
<l2dv2 height="768" width="1366"></l2dv2>
```

Put the model at:
    BACK_IMAGE_NAME: "assets/image/back_class_normal.png",
    MODEL_HARU: "assets/live2d/mod/mod.model.json",

## <l2dv3>

```html
<l2dv3 height="768" width="1366"></l2dv3>
```

Put the model at: './res/mod/mod.model3.json'
