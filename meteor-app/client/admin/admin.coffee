Template.admin.helpers

  goalCount: ->
    return Goals.find().count()

  menuItems: ->
    [
      {
        text: "new data"
        path: "/data"
      }

      {
        text: "bridge"
        path: "/bridge"
      }

    ]

Template.admin.events
  'click #clearGoals': () ->
    console.log("clearGoals")
    Meteor.call('clearGoals')