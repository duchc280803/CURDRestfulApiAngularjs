var myApp = angular.module("myApp", []);
myApp.controller("myController", [
    "$scope",
    "$http",
    function ($scope, $http) {
        $scope.listProduct = [];
        $scope.newProduct = {};
        //lấy danh sách list product
        $http
            .get("http://localhost:8080/rest/product/hien-thi")
            .then(function (response) {
                $scope.listProduct = response.data;
            })
            .catch(function (error) {
                console.error("Error retrieving products:", error);
            });
        // delete một product
        $scope.removeProduct = function (event, index) {
            event.preventDefault();
            let p = $scope.listProduct[index];
            let api = "http://localhost:8080/rest/product/delete" + "/" + p.id;
            $http.delete(api).then(function () {
                $scope.listProduct.splice(index, 1);
            });
        };
        // detail
        $scope.viewProduct = function (event, id) {
            event.preventDefault();
            var apiDetil = "http://localhost:8080/rest/product/detail/" + id;
            $http
                .get(apiDetil)
                .then(function (response) {
                    $scope.newProduct = response.data;
                })
                .catch(function (error) {
                    console.error("Error retrieving products:", error);
                });
        };
        //add
        $scope.createProduct = function (event) {
            event.preventDefault();
            $http.post('http://localhost:8080/rest/product/create', $scope.newProduct).then(function (response) {
                $scope.listProduct.push(response.data);
            })
        }
        //update
        $scope.updateProduct  = function (event,id) {
            event.preventDefault();
            $http.put("http://localhost:8080/rest/product/update/" + id, $scope.newProduct).then(function (response) {
                // Xóa dữ liệu trong ô input
                $scope.newProduct = {};
            })
        }
    },
]);