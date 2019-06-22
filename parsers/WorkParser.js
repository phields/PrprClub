// WorkType: 1, 2, 3

function GetWork (id) {
  return {
    Name: 'Work.Name' + id,
    Description: 'Work.Description',
    Date: Date.now(),
    Type: 'drawing' //, live2d, model。此处必须使用小写谢谢。
  }
}

export { GetWork }
