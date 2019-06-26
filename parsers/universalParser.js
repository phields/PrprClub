function ParseUniversal (jsonData) {
  var data = JSON.parse(jsonData)
  var result = { success: false, code: data.code, data: data.data, msg: '' }
  if (data.code === 0) result.success = true
  else result.success = false
  switch (data.code) {
    case 0:
      result.msg = '成功'
      break
    case -1:
      result.msg = '失败 ' + data.msg
      break
    case -102:
      this.$store.commit('setToken', '')
      break
    case -130:
      result.msg = '无权访问！'
      break
    case -131:
      result.msg = '当前帐户已被封禁！'
      break
    case -100:
      result.msg = '未登录'
      break
    case -111:
      result.msg = '验证码错误'
      break
    case -101:
      result.msg = '用户名或密码错误'
      break
    case -103:
      result.msg = '验证码无效'
      break
    default:
      result.msg = '未知错误'
      break
  }
  return result
}

export { ParseUniversal }
