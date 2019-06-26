// const cookieparser = process.server ? require('cookieparser') : undefined

export const state = () => {
  return {
    token: ''
  }
}

export const mutations = {
  setToken (state, token) {
    state.token = token
  }
}
