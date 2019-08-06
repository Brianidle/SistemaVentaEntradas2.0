$(document).ready(
		
		function() {
			// SUBMIT FORM
			$("#newMovieFunctionForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				var genresNames=[];
				$.each($("input[name='genre']:checked"), function(){            
	                genresNames.push($(this).val());
	            });
				ajaxPost(genresNames);
			});

			function ajaxPost(genresNames) {

				// PREPARE FORM DATA objeto
				var formData = {
					genres : genresNames,
					name : $("#movieName").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "addMovie",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "success") {
							$("#postResultDiv").html(
									"" + result.data.name
											+ " Registered Sucessfuly R <br>");
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