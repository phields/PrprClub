function ParseUniversal (jsonData) {
  var data = JSON.parse(jsonData)
  var result
  if (data.code === 0) result.success = true
  else result.success = false
  result.msg = ''
  result.code = data.code
  result.data = data.data
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
    default:
      break
  }
  return result
}

export { ParseUniversal }
