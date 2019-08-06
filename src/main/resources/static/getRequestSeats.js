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
									function(i, responseSeat) {//este objeto es el service response que le enviamos desde el backend, el cual tiene los atributos: data y result
										if(i!=0){
											if(lastLetter==responseSeat.rowSeat){
												$("#buttonBySeatDiv").append("<button onclick=\"buyTicket()\">"+responseSeat.rowSeat+responseSeat.number+"</button>&ensp;");
											}
											else{
												$("#buttonBySeatDiv").append("</br><button onclick=\"buyTicket()\">"+responseSeat.rowSeat+responseSeat.number+"</button>");
											}
										}
										else{
											$("#buttonBySeatDiv").append("<button onclick=\"buyTicket()\">"+responseSeat.rowSeat+responseSeat.number+"</button>&ensp;");
										}
										lastLetter=responseSeat.rowSeat;
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