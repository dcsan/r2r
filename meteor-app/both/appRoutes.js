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
  this.route('studentList');
  this.route('cardList');
  this.route('studentAdd');
  this.route('interview');
  this.route('admin');
  this.route('bridge');

  this.route('tabs.one', {path: '/tabs/one', layoutTemplate: 'tabsLayout'});
  this.route('tabs.two', {path: '/tabs/two', layoutTemplate: 'tabsLayout'});
  this.route('tabs.three', {path: '/tabs/three', layoutTemplate: 'tabsLayout'});

  // this.route('forms', {
  //   data: function () {
  //     return {
  //       post: Posts.find().fetch()[0]
  //     };
  //   }
  // });
})
