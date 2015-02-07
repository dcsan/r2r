Router.configure({
  layoutTemplate: 'layout'
});

Meteor.startup(function () {
  if (Meteor.isClient) {
    var location = Iron.Location.get();
    if (location.queryObject.platformOverride) {
      Session.set('platformOverride', location.queryObject.platformOverride);
    }
  }
});

Router.map(function() {
  this.route('index', {path: '/'});
  this.route('actionSheet');
  this.route('backdrop');
  this.route('forms', {
    data: function () {
      return {
        post: Posts.find().fetch()[0]
      };
    }
  });
})
