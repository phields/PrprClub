import Vue from 'vue'
import upperFirst from 'lodash/upperFirst'
import camelCase from 'lodash/camelCase'

const requireComponent = require.context('~/plugins', true, /.vue$/)

requireComponent.keys().forEach(fileName => {
  // console.log(fileName);
  const componentConfig = requireComponent(fileName)

  const componentName = upperFirst(
    camelCase(fileName.replace(/^\.\//, '').replace(/\.\w+$/, ''))

  )

  // console.log(componentName)
  Vue.component(componentName, componentConfig.default || componentConfig)
})

const requireAll = requireContext => requireContext.keys().map(requireContext)
const req = require.context('~/assets/svg', false, /\.svg$/)
requireAll(req)
