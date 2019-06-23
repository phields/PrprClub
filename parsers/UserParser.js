function GetUser (id) {
  return {
    Name: 'User.Name',
    WorkType: 0
  }
}

function GetUserDetail (id) {
  return {
    Name: 'User.Name' + id,
    Description: 'User.Description',
    Age: 0,
    Birthday: Date.now(),
    Male: true
  }
}

export { GetUser, GetUserDetail }
