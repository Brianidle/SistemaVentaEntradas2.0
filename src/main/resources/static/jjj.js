$(document).ready(
		function() {

			// GET REQUEST
			$("#registerMovieButton").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				for (i = 0; i < 5; i++) {
				$("#genreNameCheckboxes").append("<input type=\"checkbox\" name=\"vehicle1\"> I have a bike<br>");
				}
			}
		})