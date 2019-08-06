$(document).ready(
		function() {

			// GET REQUEST
			
			ajaxGet();

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "getSeats",
					success : function(result) {
						var lastLetter;
						if (result.status == "success") {
							$.each(result.data,
									function(i, cinemaFunction) {//este objeto es el service response que le enviamos desde el backend, el cual tiene los atributos: data y result
									
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