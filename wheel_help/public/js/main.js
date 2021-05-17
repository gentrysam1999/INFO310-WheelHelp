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

module.factory('customerRegisterAPI', function ($resource) {
    return $resource('/api/customers/register');
});


module.factory('customerSignInAPI', function ($resource) {
    return $resource('/api/customers/:customerUsername');
});

module.factory('carAPI', function ($resource) {
    return $resource('/api/cars/:id');
});

module.factory('registerCarAPI', function ($resource) {
    return $resource('/api/cars/register');
});




module.controller('OwnerController', function (ownerRegisterAPI, $window, ownerSignInAPI, $sessionStorage) {
    this.signInMessage = "Please sign in to continue.";
    this.checkSignIn = function () {

        if ($sessionStorage.owner) {
            this.signedIn = true;
            this.welcome = "Welcome " + $sessionStorage.owner.username;
        } else {
            this.signedIn = false;
        }
    };
    this.registerOwner = function (owner) {
        ownerRegisterAPI.save(null, owner,
                function () {
                    $window.location = 'ownerLogin.html';
                },
                function (error) {
                    console.log(error);
                }
        );
    };
    let ctrl = this;
    this.signIn = function (username, password) {


        ownerSignInAPI.get({'username': username},
                function (owner) {
                    $sessionStorage.owner = owner;
                    $window.location = 'ownerHome.html';
                },
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


module.controller('CustomerController', function (customerRegisterAPI, $window, customerSignInAPI, $sessionStorage) {
    this.signInMessage = "Please sign in to continue.";
    this.checkSignIn = function () {

        if ($sessionStorage.customer) {
            this.signedIn = true;
            this.welcome = "Welcome " + $sessionStorage.customer.customerUsername;
        } else {
            this.signedIn = false;
        }
    };
    this.registerCustomer = function (customer) {
        customerRegisterAPI.save(null, customer,
                function () {
                    $window.location = 'customerLogin.html';
                },
                function (error) {
                    console.log(error);
                }
        );
    };
    let ctrl = this;
    this.signIn = function (customerUsername, customerPassword) {


        customerSignInAPI.get({'customerUsername': customerUsername},
                function (customer) {
                    $sessionStorage.customer = customer;
                    $window.location = 'customerHome.html';
                },
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

module.controller('CarController', function (registerCarAPI, $window, $sessionStorage, ownerSignInAPI) {
    this.listMessage = "Please register your car here:";
     
    this.registerCar = function (car) {

        $sessionStorage.owner = owner;     
        this.ownerID = owner.OwnerID;
        registerCarAPI.save(null, car,
                function () {
                    $window.location = 'viewCars.html';
                },
                function (error) {
                    console.log(error);
                }
            
        );
    };


});