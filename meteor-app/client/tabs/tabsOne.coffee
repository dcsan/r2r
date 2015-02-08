sendGrade = (grade) ->
  console.log("sendGrade", grade)
  try
    Android.annotateAudioWaveform( grade )
  catch
    console.warn("failed to call Android evt annotateAudioWaveform")


Template.tabsOne.helpers
  cards: ->
    c = Cards.find().fetch()
    console.log("cards", c)
    return c

  student: ->
    s = Students.findOne()

  sparkGraph: () ->
    max = 11
    min = 1
    n = Math.floor(Math.random() * (max - min + 1)) + min
    return "/images/sparks/spark#{n}.png"


Template.tabsOne.events

  'click #fb3': (evt) ->

    $(evt.target).toggleClass("assertive")
    $(evt.target).toggleClass("active")

    cardid = $(evt.target).data("cardid")
    
    if $(evt.target).hasClass("active")
      card = Cards.findOne(cardid)
      # delete card._id
      console.log("card", cardid, card)
      Goals.insert(card)
    else
      Goals.remove(cardid)

    sendGrade("C")



  'click #fb1': (evt) ->
    $(evt.target).toggleClass("balanced")
    $(evt.target).toggleClass("active")
    sendGrade("A")

  'click #fb2': (evt) ->
    $(evt.target).toggleClass("energized")
    $(evt.target).toggleClass("active")
    sendGrade("B")