$(document).ready(
		function() {

			// GET REQUEST
			$("#registerMovieButton").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "getGenres",
					success : function(result) {
						if (result.status == "success") {
							$.each(result.data,
									function(i, genero) {//este objeto es el service response que le enviamos desde el backend, el cual tiene los atributos: data y result
										$("#genreNameCheckboxes").append("<input type=\"checkbox\" name=\"vehicle1\"> "+genero.nombre+"<br>");
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