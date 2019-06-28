const pkg = require('./package')
const { resolve } = require('path')

module.exports = {
  srcDir: '',
  head: {
    title: 'PrprClub',
    // titleTemplate: '%s —— PrprClub',
    meta: [{
      charset: 'utf-8'
    },
    {
      name: 'viewport',
      content: 'width=device-width, initial-scale=1,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0'
    },
    { hid: 'description', name: 'description', content: "We're PrprClub! " },
    { equiv: 'X-UA-Compatible', content: 'IE=Edge,chrome=1' },
    { equiv: 'Window-target', content: '_top' },
    { name: 'author', content: 'DD Center' },
    { name: 'keywords', content: 'DD Center,Prpr,PrprClub,虚拟偶像' },
    { name: 'copyright', content: 'All Rights Reserved' },
    { name: 'HandheldFriendly', content: 'true' },
    { name: 'MobileOptimized', content: '320' },
    { name: 'apple-mobile-web-app-title', content: 'PrprClub' },
    { name: 'apple-mobile-web-app-capable', content: 'yes' },
    { name: 'apple-mobile-web-app-status-bar-style', content: '#ff48cb' },
    { name: 'x5-page-mode', content: 'app' },
    { name: 'browsermode', content: 'application' },
    { name: 'msapplication-tap-highlight', content: 'no' },
    { name: 'msapplication-TileColor', content: '#ff48cb' },
    { name: 'msapplication-TileImage', content: '/mstile-icon.png' },
    { name: 'renderer', content: 'webkit' },
    { name: 'renderer', content: 'webkit' },
    { name: 'renderer', content: 'webkit' }
    ],
    // link: [{
    //     rel: "shortcut icon",
    //     type: "image/png",
    //     // 注意图片的路径直接指向static下的logo.png
    //     href: "/logo.png"
    // }]
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
      { rel: 'apple-touch-icon-precomposed', content: '/apple-touch-icon-144x144-precomposed.png' },
      { rel: 'apple-touch-startup-image', sizes: '768x1004', href: '/splash-screen-768x1004.png' },
      { rel: 'apple-touch-startup-image', sizes: '1536x2008', href: '/splash-screen-1536x2008.png' },
      { rel: 'apple-touch-startup-image', sizes: '1024x748', href: '/Default-Portrait-1024x748.png' },
      { rel: 'apple-touch-startup-image', sizes: '2048x1496', href: '/splash-screen-2048x1496.png' },
      { rel: 'apple-touch-startup-image', href: '/splash-screen-320x480.png' },
      { rel: 'apple-touch-startup-image', sizes: '640x960', href: '/splash-screen-640x960.png' },
      { rel: 'apple-touch-startup-image', sizes: '640x1136', href: '/splash-screen-640x1136.png' },
      { rel: 'shortcut icon', type: 'image/ico', href: '/favicon.ico' },
      { rel: 'manifest', href: 'manifest.json' }
    ]

  },
  loading: { color: '#fff' },
  plugins: ['~/plugins/ElementUI', '~/plugins/plugins'],
  css: [
    'element-ui/lib/theme-chalk/index.css',
    '~/assets/main.scss'
  ],
  build: {
    loaders: [{
      test: /\.(png|jpe?g|gif)(\?.*)?$/,
      loader: 'url-loader',
      options: {
        limit: 10000,
        name: 'img/[name].[hash:7].[ext]'
      }
    },
    {
      test: /\.svg$/,
      include: [resolve(__dirname, 'assets/svg')],
      loader: 'svg-sprite-loader',
      options: {
        symbolId: 'icon-[name]'
      }
    },
    {
      test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
      loader: 'url-loader',
      options: {
        limit: 10000,
        name: 'fonts/[name].[hash:7].[ext]'
      }
    },
    {
      test: /\.scss$/,
      loader: 'vue-style-loader!css-loader!sass-loader'
    }
    ],
    extend (config, ctx) {
      const svgRule = config.module.rules.find(rule => rule.test.test('.svg'))
      svgRule.exclude = [resolve(__dirname, 'assets/svg')]

      // Includes /assets/svg for svg-sprite-loader
      config.module.rules.push({
        test: /\.svg$/,
        include: [resolve(__dirname, 'assets/svg')],
        loader: 'svg-sprite-loader',
        options: {
          symbolId: 'icon-[name]'
        }
      })
    }
  }
}
