Template.cardList.helpers
  
  cards: ->
    c = Cards.find().fetch()
    console.log("cards", c)
    return c

  gradeStep: ->
    ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J"]