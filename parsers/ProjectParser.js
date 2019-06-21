function GetProject(id) {
    return {
        Name: 'Project.Name' + id,
        Description: 'Project.Description',
        Date: Date.now(),
        Work1Id: 0,
        Work2Id: 0,
        Work3Id: 0
    }
}

export { GetProject };