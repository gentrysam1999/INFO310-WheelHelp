//"use strict";



//class CarPurchase {
//
//    constructor(car, hoursSelected) {
//       
//        if (car) {
//            this.car = car;
//            this.hoursSelected = hoursSelected;
//            this.purchasePrice = car.hourlyCharge;
//
//        }
//    }
//
//    getCarTotal() {
//        return this.hoursSelected * this.purchasePrice;
//    }
//}

var module = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);
module.factory('ownerRegisterAPI', function ($resource) {
    return $resource('/api/owners/register');
});

module.factory('ownerSignInAPI', function ($resource) {
    return $resource('/api/owners/:username');
});





module.controller('OwnerController', function (ownerRegisterAPI, $window, ownerSignInAPI, $sessionStorage) {
    this.signInMessage = "Please sign in to continue.";
    this.checkSignIn = function () {
        // has the customer been added to the session?
        if ($sessionStorage.owner) {
            this.signedIn = true;
            this.welcome = "Welcome " + $sessionStorage.owner.firstName;
        } else {
            this.signedIn = false;
        }
    };
    this.registerOwner = function (owner) {
        ownerRegisterAPI.save(null, owner,
                // success callback
                        function () {
                            $window.location = 'ownerLogin.html';
                        },
                        // error callback
                                function (error) {
                                    console.log(error);
                                }
                        );
                    };
            let ctrl = this;
            this.signIn = function (username, password) {

                // get customer from web service
                ownerSignInAPI.get({'username': username},
                        // success callback
                                function (owner) {
                                    // also store the retrieved customer
                                    $sessionStorage.owner = owner;
                                    // redirect to home
                                    $window.location = '.';
                                },
                                // fail callback
                                        function () {
                                            ctrl.signInMessage = 'Sign in failed. Please try again.';
                                        }
                                );
                            };

                    this.signOut = function () {
                        delete $sessionStorage.owner;
                        $window.location = 'index.html';
                    };
                });
