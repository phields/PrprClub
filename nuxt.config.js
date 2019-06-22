const pkg = require('./package')
const { resolve } = require('path')

module.exports = {
  srcDir: '',
  head: {
    title: 'PrprClub',
    meta: [{
      charset: 'utf-8'
    },
    {
      name: 'viewport',
      content: 'width=device-width, initial-scale=1,user-scalable=no,maximum-scale=1.0,minimum-scale=1.0'
    },
    { hid: 'description', name: 'description', content: pkg.description }
    ],
    // link: [{
    //     rel: "shortcut icon",
    //     type: "image/png",
    //     // 注意图片的路径直接指向static下的logo.png
    //     href: "/logo.png"
    // }]
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
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
    extend(config, ctx) {
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
