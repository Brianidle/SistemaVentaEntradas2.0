$(document).ready(
		function() {
			
			ajaxGetMovies();
			ajaxGetRooms();

			// DO GET
			function ajaxGetMovies() {
				$.ajax({
					type : "GET",
					url : "getMovies",
					success : function(result) {
						if (result.status == "success") {
							$.each(result.data,
									function(i, movie) {//este objeto es el service response que le enviamos desde el backend, el cual tiene los atributos: data y result
										$("#movieNamesSelect").append("<option value=\""+movie.name+"\"> "+movie.name+"</option>");
									});
							console.log("Success: ", result);
						} else {
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						console.log("ERROR: ", e);
					}
				});
			}
			
			function ajaxGetRooms() {
				$.ajax({
					type : "GET",
					url : "getRooms",
					success : function(result) {
						if (result.status == "success") {
							$.each(result.data,
									function(i, room) {//este objeto es el service response que le enviamos desde el backend, el cual tiene los atributos: data y result
										$("#roomNumbersSelect").append("<option value=\""+room.roomNumber+"\"> "+room.roomNumber+"</option>");
									});
							console.log("Success: ", result);
						} else {
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						console.log("ERROR: ", e);
					}
				});
			}
		})