// const cookieparser = process.server ? require('cookieparser') : undefined

export const state = () => {
  return {
    token: '',
    auth: ''
  }
}

export const mutations = {
  setToken (state, token) {
    state.token = token
  },
  setAuth (state, auth) {
    state.auth = auth
  }
}
