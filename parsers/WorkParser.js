// WorkType: 1, 2, 3

function GetWork(id) {
  return {
    Name: 'Work.Name' + id,
    Description: 'Work.Description',
    Date: Date.now(),
    Type: 'Work.Type'
  }
}

export { GetWork }
