var app =  angular
    .module('ui', [ 'ngRoute','ngCookies'])
    .config(function($routeProvider) {
    $routeProvider
      .when('/signin', {
        templateUrl: 'SignIn.html',
        controller: 'signincontroller'
        })
	  .when('/movie-login',{
		templateUrl:'moviea.temp.html',
		controller:'movieadmincontroller'
	  }) 
	  .when('/movie-detail/:id',{
		templateUrl:'Movie_detail.tmpl.html',
		controller:'moviedetailcontroller'
	  }) 
	  .when('/signup',{
		templateUrl:'signup.temp.html',
		controller:'signupcontroller'
	  })
	  .when('/log-out',{
		templateUrl:'logout.temp.html',
		controller:'logoutcontroller'
	  })
	  .when('/movie-admin',{
		templateUrl:'moviea.temp.html',
		controller:'movieadmincontroller'
	  })
	  .otherwise({
        redirectTo: '/signin'
      });
  }).run(function() {
    console.log('App Started');
  });