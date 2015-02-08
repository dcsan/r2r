Template.cardList.helpers
  
  cards: ->
    c = Cards.find().fetch()
    console.log("cards", c)
    return c