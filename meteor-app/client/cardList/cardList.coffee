Template.cardList.helpers

  cards: ->
    console.log("cardList", this)
    # c = Cards.find().fetch()
    # console.log("cards", c)
    return this.cards

  gradeStep: ->
    ["C", "D", "E", "F", "G", "H", "I", "J"]


