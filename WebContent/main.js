angular.module('web', []).run(($rootScope, $location) => {

})
    .controller('CtrlRecipe', ['$scope', 'ServiceRecipe', ($scope, ServiceRecipe) => {
        $scope.recipes = [];
        $scope.recipe = {};

        $scope.searchKey = '';
        $scope.searchParam = '';

        $scope.hundred = 0;

        $scope.msgAdd = '';
        
        $scope.getRecipes = () => {
            ServiceRecipe.getAll().then((response) => {
                $scope.recipes = response.data;
                console.log(response.data);
            });
        };

        $scope.addRecipe = () => {
            let recipe = {};
            recipe = angular.copy($scope.recipe);
            ServiceRecipe.add(recipe).then((response) => {
                $scope.recipes.push(recipe);
                $scope.msgAdd = 'Recipe added ' + recipe.name;
            });
        };

        $scope.findRecipe = () => {
            let key = angular.copy($scope.searchKey);

            ServiceRecipe.findByName(key).then((response) => {
                $scope.recipes = response.data;
            });
        };

        $scope.nextHundred = () => {
            let hundred = angular.copy($scope.hundred);
            ServiceRecipe.getHundreds(hundred).then((response) => {
                $scope.recipes = response.data;
            });
        };

        $scope.getRecipes();
    }])
    
    .factory('ServiceRecipe', ['$http', ($http) => {
        let service = {};

        service.getAll = () => {
            return $http.get('http://localhost:8080/Domaci8/rest/recipe');
        };

        service.add = (recipe) => {
            return $http.post('http://localhost:8080/Domaci8/rest/recipe', recipe);
        };

        service.findByName = (key) => {
            return $http.get('http://localhost:8080/Domaci8/rest/recipe/search/name/' + key, {
            });
        };

        service.getHundreds = (hundred) => {
            console.log(hundred)
            return $http.get('http://localhost:8080/Domaci8/rest/recipe/search/' + hundred);
        };

        return service;
    }])
    
    .controller('CtrlUser', ['$scope', 'ServiceUser', ($scope, ServiceUser) => {
        $userReg = {};
        $userLog = {};
        $msgReg = '';
        $msgLog = '';

        $scope.register = () => {
            let user = angular.copy($scope.userReg);

            ServiceUser.register(user).then((response) => {
                if (response.data)
                    $scope.msgReg = 'Registered';
                else
                    $scope.msgReg = 'Username is taken';
            });
        };

        $scope.login = () => {
            let user = angular.copy($scope.userLog);

            ServiceUser.login(user).then((response) => {
                if (response.data)
                    $scope.msgLog = 'Successfully logged in';
                else
                    $scope.msgLog = 'Error! Wrong username or password';
            });
        }
    }])
    
    .factory('ServiceUser', ['$http', ($http) => {
        let service = {};

        service.register = (user) => {
            return $http.post('http://localhost:8080/Domaci8/rest/user/register', user);
        };

        service.login = (user) => {
            return $http.post('http://localhost:8080/Domaci8/rest/user/login', user);
        };

        return service;
    }]);