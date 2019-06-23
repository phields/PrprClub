const Cookie = process.client ? require('js-cookie') : undefined

function Logout () {
  // 使外部API上的JWT Cookie无效
  Cookie.remove('auth')
  this.$store.commit('setAuth', null)
}

export { Logout }
