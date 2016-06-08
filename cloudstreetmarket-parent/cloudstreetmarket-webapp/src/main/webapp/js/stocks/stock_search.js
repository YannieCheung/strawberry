cloudStreetMarketApp.factory("stockTableFactory", function ($http) {
    return {
        get: function (ps, pn, cn, sw, sf, sd) {
        	return $http.get("/api/products/stocks.json?sw="+sw+"&cn="+cn+"&size="+ps+"&page="+pn+"&sort="+sf+","+sd);
        }
    }
});

cloudStreetMarketApp.controller('stockSearchController', function PaginationCtrl($scope, stockTableFactory){
	  $scope.loadPage = function () {
		  stockTableFactory.get($scope.pageSize, $scope.currentPage, $scope.stockSearch, $scope.startWith, $scope.sortedField, $scope.sortDirection)
			.success(function(data, status, headers, config) {
				updatePaginationStockS ($scope, data);
	        });
	  }

	  /*
	   * Pagination
	   */
	  $scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo-1;
	    $scope.loadPage();
	  };
	  initPaginationStockS ($scope);
	  
	  /*
	   * Request spec.
	   */
	  $scope.setStartWith = function (startWith) {
		  $scope.startWith = (startWith!==$scope.startWith) ? startWith : ""; 
		  $scope.loadPage();
	  };
	  
	  $scope.setContains = function () {
		  $scope.containsSubmitted = $scope.stockSearch;
		  $scope.loadPage();
	  };
	  
	  $scope.startWith = "";
	  $scope.stockSearch ="";
	  $scope.letters = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
	  
	  /*
	   * Sorting
	   */
	  $scope.setSort = function(field) {
		  updateSortParamStockS ($scope, field)
	  }
	  
	  $scope.loadPage();
});

/**
 * Static functions
 */
function updatePaginationStockS ($scope, data){
	$scope.stocks = data.content;
    $scope.currentPage = data.number;
    $scope.paginationCurrentPage = data.number+1;
    $scope.paginationTotalItems =  data.totalElements;//number total of objects
}

function updateSortParamStockS ($scope, field){
	  if( $scope.sortedField == field){
		  $scope.sortDirection = ($scope.sortDirection === "asc")? "desc" : "asc";
	  }
	  else{
		  $scope.sortDirection = "asc";
	  }
	  $scope.sortedField = field;
	  $scope.loadPage()
}

function initPaginationStockS ($scope){
	$scope.sortedField = "name";
	$scope.sortDirection = "asc";
	
	$scope.maxSize = 6; //number of visible buttons for pages
	$scope.currentPage = 0;
	$scope.paginationTotalItems = 5;
	$scope.paginationCurrentPage = 1;
	$scope.pageSize = 15;
	$scope.stocks = [];
}