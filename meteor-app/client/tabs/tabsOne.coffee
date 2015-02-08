Template.tabsOne.helpers
  cards: ->
    c = Cards.find().fetch()
    console.log("cards", c)
    return c

  student: ->
    s = Students.findOne()


Template.tabsOne.events
  'click #fb3': (evt) ->

    $(evt.target).toggleClass("assertive")
    $(evt.target).toggleClass("active")

    if $(evt.target).hasClass("active")
      cardid = $(evt.target).data("cardid")
      card = Cards.findOne(cardid)
      # delete card._id
      console.log("card", cardid, card)
      Goals.insert(card)
    else
      Goals.remove(cardid)
