# Nuxt迁移说明

## 编译相关

请查阅package.json了解命令。全部SSR相关命令其后都会跟随:ssr。

## 关于assets

资源目录 assets 用于组织未编译的静态资源如 LESS、SASS 或 JavaScript。
在官方文档中，每个目录都有别名，这些别名在nuxt.config.js中配置时是有效的，比如之前配置的css选项，但不代表我们在组件中使用这些别名会有效，在组件中我们最好使用相对路径，比如在components/header/header.vue中就不能直接写~assets，而得老老实实写相对路径

```html
<style lang="scss" rel="text/css" src="../../assets/base.scss"></style>
<style type="text/css" src="../../assets/style.css"></style>
<style lang="scss" rel="text/css">
  @import "../../assets/mixin.scss";
  @import "./header.scss";
</style>
```
