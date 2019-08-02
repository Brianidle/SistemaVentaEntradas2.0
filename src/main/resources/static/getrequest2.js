$(document).ready(
		function() {

			// GET REQUEST
			$("#listarFuncionesButton").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "listarFunciones",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.data,//este objeto es el service response que le enviamos desde el backend, el cual tiene los atributos: data y result
									function(i, funcion) {
										var funcion = "Pelicula Funcion  "
												+ funcion.pelicula
												+ ", Fecha = " +funcion.fecha+", Hora:"+funcion.hora
												+ "<br>";
										$('#getResultDiv .list-group').append(
												funcion)
									});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})
		
		for (var i = 0; i < json.items.length; i++) {
    $('<input />', {
        type : 'checkbox',
        id: 'id' + i,
        name: 'name' + json.items[i].name,
        value: 'value'
    })
    .appendTo("#someId"); 
}