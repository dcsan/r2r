Template.studentList.helpers

  students: ->
    return Students.find().sort({
      name: 1
    }).fetch()