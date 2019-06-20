// SVG Loader BY Il Harper. 请勿修改。
const path = require('path')

function resolve (dir) {
  return path.join(__dirname, './', dir)
}

module.exports = {
  chainWebpack: config => {
    config.plugin('define').tap(args => {
      const argv = process.argv
      const icourt = argv[argv.indexOf('--icourt-mode') + 1]

      args[0]['process.env'].MODE = `"${icourt}"`

      return args
    })
    const svgRule = config.module.rule('svg')
    svgRule.uses.clear()
    svgRule.exclude.add(/node_modules/)
    svgRule
      .test(/\.svg$/)
      .use('svg-sprite-loader')
      .loader('svg-sprite-loader')
      .options({
        symbolId: 'icon-[name]'
      })

    const imagesRule = config.module.rule('images')
    imagesRule.exclude.add(resolve('src/icons'))
    config.module
      .rule('images')
      .test(/\.(png|jpe?g|gif|svg)(\?.*)?$/)
  },
  configureWebpack: {
    devServer: {
      open: true
      // 在使用HTTPS时启用该命令。
      // https: true,
    }
  }
}
