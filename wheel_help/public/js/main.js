//"use strict";



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

class ShoppingCart {

    constructor() {
        this.items = new Array();
    }

    reconstruct(sessionData) {
        for (let item of sessionData.items) {
            this.addItem(Object.assign(new CarPurchase(), item));
        }
    }

    getItems() {
        return this.items;
    }

    addItem(item) {
        this.items.push(item);
    }

    setCustomer(customer) {
        this.customer = customer;
    }

    getTotal() {

         let total = 0;
        for (let item of this.items) {
            total += item.getCarTotal();
        }
        return total;
    }

}
var module = angular.module('ShoppingApp', ['ngResource', 'ngStorage']);

      module.factory('cart', function ($sessionStorage) {
        let cart = new ShoppingCart();
                // is the cart in the session storage?
                if ($sessionStorage.cart) {

        // reconstruct the cart from the session data
        cart.reconstruct($sessionStorage.cart);
        }

        return cart;
        });


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
    return $resource('/api/cars');
});

module.factory('carTypeAPI', function ($resource) {
    return $resource('/api/types');
});

module.factory('registerCarAPI', function ($resource) {
    return $resource('/api/cars/register');
});

module.factory('carOwnerAPI', function ($resource) {
    return $resource('/api/cars/:ownerId');
});

module.factory('transactionAPI', function ($resource) {
    return $resource('/api/transactions');
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

module.controller('CarController', function (registerCarAPI, $window, $sessionStorage, carAPI, carOwnerAPI, carTypeAPI, $scope) {
    this.listMessage = "Please register your car here:";
    this.types = carTypeAPI.query();
    this.cars = carAPI.query();
    this.selectType = function (selectedType) {

    };
});
//        this.selectCategory = function (selectedCat) {
//        this.products = categoryAPI.query({"category": selectedCat});
//this.requests = studentRequestDAO.query({"studentID": $sessionStorage.student.studentID});

module.controller('CarListController', function (registerCarAPI, $window, $sessionStorage, carOwnerAPI, ) {
    this.ownerCars = carOwnerAPI.query({'ownerId': $sessionStorage.owner.OwnerID});
    this.registerCar = function (car) {


        car.ownerId = $sessionStorage.owner.OwnerID;
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







module.controller('ShoppingCartController', function (cart, $window, $sessionStorage, carAPI, transactionAPI) {
    this.items = cart.getItems();
    this.total = cart.getTotal();
    this.selectedCar = $sessionStorage.car;
    this.rentCar = function (car) {
        carAPI.get({'car': car}),
                $sessionStorage.car = car;
        $window.location = 'hireCar.html';
    };
    this.addCart = function (hoursSelected) {

        let car = $sessionStorage.car;
        let item = new CarPurchase(car, hoursSelected);
        cart.addItem(item);
        $sessionStorage.cart = cart;
        delete $sessionStorage.car;
        $window.location = 'cart.html';

    };
    this.checkout = function () {
        if ($sessionStorage.cart) {
            cart.setCustomer($sessionStorage.customer);
            transactionAPI.save(cart);
            //delete $sessionStorage.customer;
            delete $sessionStorage.cart;
            $window.location = 'confirmation.html';
        } else {
            alert("No product in cart");
        }
    };
});

