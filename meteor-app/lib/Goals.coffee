@Goals = new Meteor.Collection("Goals")


clearGoals = () ->
  console.log("reload goals")
  Goals.remove({})

if Meteor.isServer
  Meteor.startup ->
    # clearGoals()

  Meteor.methods
    'clearGoals': ->
      clearGoals()


