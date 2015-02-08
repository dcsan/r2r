Template.cardList.helpers
  
  cards: ->
    c = Cards.find()
    console.log("cards", c)
    return c