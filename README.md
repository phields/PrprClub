# PrprClub

prpr

qn❘ↃɹdɹԀ

加油! by 什么都不会的NEO

> 06-21 Il Harper

已经迁移到了Nuxt。查阅NuxtNotice.md获取信息。

**已经更新npm run命令。请使用npm run dev或者是vue ui而非nuxt。**

**请注意，所有在plugins里面的组件都已经全局注册，请不要另行注册。使用小写字符（如`<pfooter>`）即可引用组件。**

**components中的组件仍需手动引用。**

> Il Harper:

fe-demo的branch可以拆掉了。

**请勿修改icons文件夹和vue.config.js。**

> 06-20 Il Harper的废话更多了：

首先我建议每人commit前都跑一遍eslint再commit

然后页面间的Router架构已经做完了（静静看），然后npm加持个Element就好www

router.js那里有个'/'的路由不知道放什么好，看你们

[这里](https://github.com/phields/PrprClub/graphs/contributors)可以方便地看到每人贡献的代码行数，工资你们分，给我多少都行（真的都行）

> 06-18 Il Harper胡思乱想写下了以下文字：

## Pages (Based on Vue-Router)

既然这个网站目的不是bp/社交，那么页面逻辑最好业务性强一点。

分为仪表板（Dashboard）和探索（Discover）两个区域，相互独立（指Header独立区分），但右上角应该有便于切换的按钮。

### Dashboard

仪表板（即个人界面）主要是项目（Projects）栏和资产（Resources）栏。这里要本着*提高工作效率*的理念去设计。既然Prpr是一个*不仅限于*类似哔哩哔哩的非商业社交的平台，那么就应该体现出其对业务的专注和对用户的友好。

### Discover

探索（Discover）的重点和职能：

* 使“只是来浏览图片”的普通用户满♂足

* 使普通用户产生“我能不能也参与到这个项目里面来？”的想法从而增加活跃用户量，因此侧边栏*必须*要有对网站运营理念的介绍

* 通过牛逼的算法（靠你们了）使已经有资产的创作者能够快速发现与其创作符合的其他类型的作品（作品Card的footer应包含“获得联系”的方法）

## 几句废话

* 网站各处都应该（不应过于突出）地插入“让用户成为创作者”的提示。你看哔哩哔哩在手机app的个人空间页中给不是大会员的用户也放上了灰色的“大会员”的badge，这样很明显能够促使用户点进去www

> 好了废话说的太多了我去撸代码了www
