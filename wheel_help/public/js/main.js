/* global angular */

"use strict";

// create a new module, and load the other pluggable modules
//var module = angular.module('ShopApp', ['ngResource', 'ngStorage']);

class CarPurchase {

    constructor(car, hoursSelected) {
       
        if (car) {
            this.car = car;
            this.hoursSelected = hoursSelected;
            this.purchasePrice = car.hourlyCharge;

        }
    }

    getCarTotal() {
        return this.hoursSelected * this.purchasePrice;
    }
}

module.factory('ownerSignInAPI', function ($resource) {
    return $resource('/api/owners/:username');
});

module.factory('ownerRegisterAPI', function ($resource) {
    return $resource('/api/owner/register');
});

var module = angular.module('ShopApp', ['ngResource', 'ngStorage']);

module.controller('OwnerController', function (ownerRegisterAPI, $window, ownerSignInAPI, $sessionStorage) {
    this.signInMessage = "Please sign in to continue.";
    this.checkSignIn = function () {
        // has the customer been added to the session?
        if ($sessionStorage.customer) {
            this.signedIn = true;
            this.welcome = "Welcome " + $sessionStorage.customer.firstName;
        } else {
            this.signedIn = false;
        }
    };
    this.registerCustomer = function (customer) {
        ownerRegisterAPI.save(null, customer,
                // success callback
                        function () {
                            $window.location = 'signin.html';
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
                                function (customer) {
                                    // also store the retrieved customer
                                    $sessionStorage.customer = customer;
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
                        delete $sessionStorage.customer;
                        $window.location = 'index.html';
                    };
                });
