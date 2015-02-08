Template.tabsTwo.helpers
  goals: ->
    goals = Goals.find().fetch()
    console.log("goals", goals)
    return goals

Template.tabsTwo.events
  'click .goalItem': (evt) ->
    goalid = $(evt.target).data('goalid')
    Goals.remove(goalid)
