# Il Harper的组件使用说明

## work-popup

```html
<el-button @click="popupVisible = true">Click Me! </el-button>

<work-popup :workId="workId" :visible="popupVisible" @go-privious="workId--" @go-next="workId++"
    @closed="popupVisible = false"></work-popup>

<script>
export default {
  data() {
    return {
      workId: 0,
      popupVisible: false
    }
  },
  methods: {
  }
}
</script>
```
