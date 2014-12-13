var KuPRA = angular.module('KuPRA', [
    'ngRoute',
    'KuPRA.services'
]);

/**
 * Services
 *
 * @type {module}
 */
//angular.module('KuPRA.services').factory('register', ['$resource',
//    function($resource){
//        return $resource('http://localhost:9999/register', {}, {
//            query: {
//                method:'GET',
//                params:
//                {
//                    username:'username',
//                    password:'password'
//                },
//                isArray:true
//            }
//        });
//    }]);
//
//angular.module('KuPRA.services').factory('login', ['$resource',
//    function($resource){
//        return $resource('http://localhost:9999/login', {}, {
//            query: {
//                method:'GET',
//                params:
//                {
//                    username:'username',
//                    password:'password'
//                },
//                isArray:true
//            }
//        });
//    }]);
//
//angular.module('KuPRA.services').factory('activeUser', ['$resource',
//    function($resource){
//        return $resource('http://192.168.33.10:9999/activeUser', {}, {
//            query: {
//                method:'GET',
//                isArray:true
//            }
//        });
//    }]);

angular.module('KuPRA.services', []).
    factory('activeUser', function($http) {

        var activeUser = {};

        activeUser.getUser = function() {
            return $http({
                method: 'GET',
                url: 'http://192.168.33.10:9999/activeUser'
            });
        };

        return activeUser;
    });

/**
 * Controllers
 */

var controllers = {};

controllers.topBarController = function($scope, activeUser){
    activeUser.getUser().success(function () {
        $scope.isLogged=true;
    }).error(function () {
        $scope.isLogged=false;
    });
};

controllers.contentController = function($scope, activeUser){
    activeUser.getUser().success(function () {
        $scope.isLogged=true;
    }).error(function () {
        $scope.isLogged=false;
    });
};

/**
 * END Controllers
 */

KuPRA.controller(controllers);

/**
 * Routing
 */
KuPRA.config(function($routeProvider){
    $routeProvider.when('/', {
        controller: 'indexController',
        templateUrl: 'index.html'
    })
});
