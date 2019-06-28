import Vue from 'vue'
import upperFirst from 'lodash/upperFirst'
import camelCase from 'lodash/camelCase'

import axios from 'axios'
import VueAxios from 'vue-axios'

import VueCookies from 'vue-cookies'

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

Vue.use(VueAxios, axios)
Vue.use(VueCookies)
