sorter = {sort: {name: 1}}

resort = (s) ->
  console.log("resort", sorter)

Template.studentList.helpers

  students: ->
    return Students.find({}, sorter).fetch()


Template.studentList.events
  
  'click #sortLevel': ->
    sorter = {sort: {level: 1}}
    resort()
    # sortMode = "level"

  'click #sortName': ->
    sorter = {sort: {name: 1}}
    resort()
