import utils from '~/utils/userAuth'

export default function ({ store, redirect }) {
  // If the user is not authenticated
  if ((!store.state.token || store.state.token === '') && !utils.getcookiesInClient('token')) {
    return redirect('/login')
  }
}
