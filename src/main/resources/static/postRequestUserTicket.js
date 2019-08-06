$(document).ready(
		
		function() {
			// SUBMIT FORM
			$("#buyTicketForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA objeto
				var formData = {
					nickname : $("#nicknameLabel").val(),
					rowSeat : $("#functionDateText").val(),
					seatNumber : $("#functionTimeText").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "addCinemaFunction",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
							$("#postResultDiv").html("Cinema Function Successfully Registered !! <br>");
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})