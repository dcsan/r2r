Template.levelList.helpers

  students: ->
    return Students.find().fetch()