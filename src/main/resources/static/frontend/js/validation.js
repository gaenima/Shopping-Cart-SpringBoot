$(document).ready(function(){
	$("#form-signup").validate({
		rules: {
			name: {
				required: true,
				minlength: 3			
			},
			lastname: {
				required: true,
							
			},
			telephone: {
				required: true,
				number: true,
				minlength: 5,
				maxlength: 10,
							
			},
			street: {
				required: true,						
			},
			number: {
				required: true,	
				number: true
			},
			province: {
				required: true,
			},
			city: {
				required: true,
			},
			mail: {
				required: true,
				minlength: 13
			},
			password: {
				required: true,
				minlength: 8
			}
		},
		messages: {
			name: {
				required: "Debe ingresar un nombre",
				minlength: "El nombre debe contener al menos 3 caracteres"
			},
			lastname: {
				required: "Debe ingresar un apellido",
				
			},
			telephone: {
				required: "Debe ingresar un teléfono",
				number: "El campo solo perite números",
				minlength: "El teléfono debe contener al menos 5 caracteres",
			    maxlength: "El teléfono debe contener menos de 11 caracteres"
			},
			street: {
				required: "Debe ingresar una calle",
				
			},
			number: {
				required: "Debe ingresar una altura",
				number: "Solo se aceptan números"
				
			},
			province: {
				required: "Debe seleccionar una provincia",
				
			},
			city: {
				required: "Debe seleccionar una ciudad",
				
			},
			mail: {
				required: "Dele ingresar un correo",
				minlength: "mínimo 13 carcteres"
			},
			password: {
				required: "Dele ingresar una contraseña",
				minlength: "mínimo 8 carcteres"
			}
			
		},
		submitHandler: function(form){
			form.submit();
		}
	
	});
	
	$("#mail").blur(function(){
		let enteredMail = $("#mail").val();
		$.ajax({
			url: "/validateMail",
			data: "mailId=" + enteredMail,
			
		}).done(res => {
			if(res=='Duplicate'){
				$("#dupliMail").html("El correo " + enteredMail + "ya existe en el sistema");
				$("#mail").focus()
				$("#btn-signup").prop("disabled", true);
			}else{
				$("#dupliMail").html("");
				$("#btn-signup").prop("disabled", false);
				
			}
		}).fail(err =>  console.log(err));
		
					
	})
})