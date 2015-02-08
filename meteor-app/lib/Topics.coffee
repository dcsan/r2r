Cards = new Meteor.Collection("Cards")


reloadTopics = () ->
  console.log("reload topics")

if Meteor.isServer
  Meteor.startup ->
    reloadTopics()

