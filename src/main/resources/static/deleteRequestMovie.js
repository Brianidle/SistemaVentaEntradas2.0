$(document).ready(
		
		function() {
			// SUBMIT FORM
			$("#deleteMovieForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxDelete();
			});

			function ajaxDelete() {

				// PREPARE FORM DATA objeto
				var formData = {
					name : $("#movieNamesSelect").val()
				}

				// DO POST
				$.ajax({
					type : "DELETE",
					contentType : "application/json",
					url : "deleteMovie",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(result.data.name+"Successfuly Deleted!! <br>");
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