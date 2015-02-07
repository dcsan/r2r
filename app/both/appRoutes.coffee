Meteor.startup ->

  if Meteor.isClient

    Router.configure
      # notFoundTemplate: 'NotFound',
      # layoutTemplate: "sidemenu"
      # loadingTemplate: 'loading'
      # onBeforeAction: "loading"

    Router.route "/", ->
      @render "top"

    Router.route "/interview", ->
      @render "interview"

    Router.route "/studentList", ->
      @render "studentList"

    Router.route "/student/add", ->
      @render "studentAdd"

