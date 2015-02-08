Template.studentList.helpers

  students: ->
    return Students.find().fetch()