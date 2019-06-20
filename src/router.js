import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
    path: '/dashboard',
    name: 'dashboard',
    redirect: '/dashboard/me',
    component: () =>
                import('./views/Dashboard.vue'),
    children: [{
      path: '/dashboard/me',
      name: 'me',
      component: () =>
                    import('./views/Dashboard/Me.vue')
    }, {
      path: '/dashboard/works',
      name: 'works',
      component: () =>
                    import('./views/Dashboard/Works.vue')
    }, {
      path: '/dashboard/projects',
      name: 'projects',
      component: () =>
                    import('./views/Dashboard/Projects.vue')
    }, {
      path: '/dashboard/messages',
      name: 'messages',
      component: () =>
                    import('./views/Dashboard/Messages.vue')
    }, {
      path: '/dashboard/settings',
      name: 'settings',
      component: () =>
                    import('./views/Dashboard/Settings.vue')
    }]
  },
  {
    path: '/discover',
    name: 'discover',
    redirect: '/discover/home',
    component: () =>
                import('./views/Discover.vue'),
    children: [{
      path: '/discover/home',
      name: 'home',
      component: () =>
                    import('./views/Discover/Home.vue')
    }, {
      path: '/discover/dynamics',
      name: 'dynamics',
      component: () =>
                    import('./views/Discover/Dynamics.vue')
    }, {
      path: '/discover/adoption',
      name: 'adoption',
      component: () =>
                    import('./views/Discover/Adoption.vue')
    }, {
      path: '/discover/about',
      name: 'about',
      component: () =>
                    import('./views/Discover/About.vue')
    }]
  },
  {
    path: '/',
    redirect: to => {
      return '/dashboard/me'
      // OR return '/discover/home';
      // Il Harper: 这里建议已注册用户转到个人页，未注册用户转到主页
      // 或是用该路由作为一个Toggle……只是个建议，具体看你们
    }
  },
  {
    path: '/discover',
    redirect: '/discover/home'
  },
  {
    path: '/dashboard',
    redirect: '/discover/me'
  }
  ]
})
