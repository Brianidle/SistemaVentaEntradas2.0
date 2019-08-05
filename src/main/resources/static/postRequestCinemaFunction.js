$(document).ready(
		
		function() {
			// SUBMIT FORM
			$("#newCinemaFunctionForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA objeto
				var formData = {
					movieName : $("#movieNamesSelect").val(),
					roomNumber : $("#roomNumbersSelect").val(),
					date : $("#functionDateText").val(),
					time : $("#functionTimeText").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "addCinemaFunction",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
											"Successfull Post !! <br>"
											+ "---> Congrats !!" + "</p>");
						} else {
							$("#postResultDiv").html("<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						alert("Error!")
						console.log("ERROR: ", e);
					}
				});

			}

		})