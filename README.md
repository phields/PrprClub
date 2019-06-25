# PrprClub

prpr

qn❘ↃɹdɹԀ

加油! by 什么都不会的NEO

## 各种MarkDown

* UserAuth.md 用户登录指南

* Interface.md 前后端通信指南

* NuxtNotice.md 迁移到Nuxt后大家需要注意的事情

* Components.md 组件使用指南

> 06-22 Il Harper

要在页面内部实现刷新，请使用DI。Eg：

`inject: ['reload']`后直接调用`this.reload()`。

关于头像上传，请参阅：[vue-image-crop-upload](https://github.com/dai-siki/vue-image-crop-upload)

请查阅甲♂方所给的最新Req（在Trello）。

> 06-21 Il Harper

已经迁移到了Nuxt。查阅NuxtNotice.md获取信息。

**已经更新npm run命令。请使用npm run dev或者是vue ui而非nuxt。**

**请注意，所有在plugins里面的组件都已经全局注册，请不要另行注册。使用小写字符（如`<pfooter>`）即可引用组件。**

**components中的组件仍需手动引用。**
