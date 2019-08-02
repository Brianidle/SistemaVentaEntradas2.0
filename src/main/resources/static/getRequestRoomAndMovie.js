$(document).ready(
		function() {

			// GET REQUEST
			$("#registerMovieFunctionButton").click(function(event) {
				event.preventDefault();
				ajaxGetMovies();
				ajaxGetSeats();
			});

			// DO GET
			function ajaxGetMovies() {
				$.ajax({
					type : "GET",
					url : "getMovies",
					success : function(result) {
						if (result.status == "success") {
							$.each(result.data,
									function(i, movie) {//este objeto es el service response que le enviamos desde el backend, el cual tiene los atributos: data y result
										$("#movieNamesSelect").append("<option value=\""+movie.nombre+"\">"+movie.nombre+"</option><br>");
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
			
			function ajaxGetSeats() {
				$.ajax({
					type : "GET",
					url : "getSeats",
					success : function(result) {
						if (result.status == "success") {
							$.each(result.data,
									function(i, room) {//este objeto es el service response que le enviamos desde el backend, el cual tiene los atributos: data y result
										$("#movieNamesSelect").append("<option value=\""+movie.nombre+"\">"+movie.nombre+"</option><br>");
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