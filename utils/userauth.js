import Cookie from 'js-cookie'
export default {
  getcookiesInServer: function (req) {
    let serviceCookie = {}
    req && req.headers.cookie && req.headers.cookie.split(';').forEach(function (val) {
      let parts = val.split('=')
      serviceCookie[parts[0].trim()] = (parts[1] || '').trim()
    })
    return serviceCookie
  },
  getcookiesInClient: function (key) {
    return Cookie.get(key) ? Cookie.get(key) : ''
  }
}
