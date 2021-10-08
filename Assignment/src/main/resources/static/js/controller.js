app.controller('registerUserController', function($scope, $http, $location,
$route) {
$scope.submitUserForm = function() {
	console.log($scope.user);
$http({
method : 'POST',
data : $scope.user,
url : 'http://localhost:8080/api/user/upload',

}).then(function(response) {
$location.path("/list-all-users");
$route.reload();
}, function(errResponse) {
$scope.errorMessage = errResponse.data.errorMessage;
});
}

});

app.controller('listUserController', function($scope, $http, $location, $route) {
$http({
method : 'GET',
url : 'http://localhost:8080/api/user/'
}).then(function(response) {
$scope.users = response.data;
});
$scope.editUser = function(userId) {
$location.path("/update-user/" + userId);
}
$scope.deleteUser = function(userId) {
$http({
method : 'DELETE',
url : 'http://localhost:8080/api/user/' + userId
})
.then(
function(response) {
$location.path("/list-allusers");
$route.reload();
});
}
});

app.controller('usersDetailsController',function($scope, $http, $location, $routeParams,
$route) {
$scope.userId = $routeParams.id;
$http({
method : 'GET',
url : 'http://localhost:8080/api/user/' + $scope.userId
}).then(function(response) {

$scope.user = response.data;
  $scope.user.dob = new Date($scope.user.dob);
});

$scope.submitUserForm = function() {
	console.log($scope.user);
$http({
method : 'POST',
data : $scope.user,
url : 'http://localhost:8080/api/user/update'
})
.then(
function(response) {
$location.path("/list-all-users");
$route.reload();
},
function(errResponse) {
$scope.errorMessage = "Error while updating User - Error Message: '"
+ errResponse.data.
errorMessage;
});

}

});