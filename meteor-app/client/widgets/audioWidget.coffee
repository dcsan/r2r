# FIXME - parameterize for diff games
startAnimation = () ->

  $("#recordIcon").addClass("fadeIn")

  console.log("startAnimation")
  duration = 60

  $("#timerPct").velocity({
    width: '100%'
    backgroundColor: "#ccFFcc"
  })

  $("#timerPct").velocity({
    width: '1%',
    # backgroundColor: "#FF0000"
  },
  {
    duration: duration * 1000

  })
  # that = @
  # @timeoutRef = setTimeout @gameTimeout, @gameConfig.duration*1000, that


Template.audioWidget.record = () ->
  startAnimation()

Template.audioWidget.events
  "click #recordButton": ->
    startAnimation()