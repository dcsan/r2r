hitlist = new ReactiveVar()
sorter = {sort: {name: 1}}

resort = (s) ->
  console.log("resort", sorter)
  statData = Students.find({}, sorter).fetch()
  hitlist.set(statData)

Template.studentList.rendered = () ->
  resort()


Template.studentList.helpers

  # students: ->
  #   return(resort() )

  hitlist: ->
    return hitlist.get()


Template.studentList.events
  
  'click #sortLevel': ->
    sorter = {sort: {level: 1}}
    resort()
    # sortMode = "level"

  'click #sortName': ->
    sorter = {sort: {name: 1}}
    resort()
