Template.bridge.helpers
  bridgeItems: ->
    [
      {
        text: "showRecordingButton"
        btnId: "btn1"
      }

      {
        text: "hideAudioWaveform"
        btnId: "btn2"
      }

    ]


Template.bridge.events
  "click #btn1": (evt) ->
    console.log("call1")
    Android.showRecordingButton("btn1")

  "click #btn2": (evt) ->
    console.log("call2")
    Android.hideAudioWaveform("btn2")

  "click #call3": (evt) ->
    console.log("call3")

