Template.bridge.helpers
  bridgeItems: ->
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


Template.bridge.events
  "click #call1": (evt) ->
    console.log("call1")

  "click #call2": (evt) ->
    console.log("call2")

  "click #call3": (evt) ->
    console.log("call3")

