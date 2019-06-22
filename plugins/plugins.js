import Vue from 'vue'
import upperFirst from 'lodash/upperFirst'
import camelCase from 'lodash/camelCase'

// Require in a base component context
const requireComponent = require.context('~/plugins', true, /.vue$/)

requireComponent.keys().forEach(fileName => {
  // console.log(fileName);
  // Get component config
  const componentConfig = requireComponent(fileName)

  // Get PascalCase name of component
  const componentName = upperFirst(
    camelCase(fileName.replace(/^\.\//, '').replace(/\.\w+$/, ''))

  )

  // console.log(componentName)
  // Register component globally
  Vue.component(componentName, componentConfig.default || componentConfig)
})

const requireAll = requireContext => requireContext.keys().map(requireContext)
const req = require.context('~/assets/svg', false, /\.svg$/)
requireAll(req)
