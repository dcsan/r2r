@Cards = new Meteor.Collection("Cards")


reloadCards = () ->
  console.log("reload topics")
  Cards.remove({})
  for card in @cardData
    Cards.insert(card)


if Meteor.isServer
  Meteor.startup ->
    reloadCards()

