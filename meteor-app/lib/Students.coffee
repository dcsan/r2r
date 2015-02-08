@Students = new Meteor.Collection("Students")

reloadStudents = () ->
  console.log("reload students")
  Students.remove({})
  for st in @studentData
    Students.insert(st)


if Meteor.isServer
  Meteor.startup ->
    reloadStudents()

