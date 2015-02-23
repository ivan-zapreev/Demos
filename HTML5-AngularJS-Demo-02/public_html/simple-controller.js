/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Define a new module and set the controller
angular.module('mySearchApp', []).controller('mySimpleController', SimpleController);

//The controller function
function SimpleController($scope) {
    $scope.people= [
                    {name: 'Ivan',  birth:'22/11/1979', place:'Novosibirsk', land: 'Russian Federation'},
                    {name: 'Galina', birth:'03/06/1983', place:'St. Leningradskaja', land: 'Russian Federation'},
                    {name: 'Katja',  birth:'04/05/2013', place:'Eindhoven', land: 'The Netherlands'}
                ];
}