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
