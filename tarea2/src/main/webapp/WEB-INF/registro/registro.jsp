<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="media/styles/bootstrap.min.css?v=<?php echo time(); ?>">
   <script src="media/js/bootstrap.min.js?v=<?php echo time(); ?>"></script>
   <script src="media/js/jquery-3.7.1.min.js?v=<?php echo time(); ?>"></script>
    <title>Trabajo.uy</title>
</head>
<body> 
    <main>
		<% if (request.getAttribute("error") != null) { %>
		    <div id="errorDiv" class="alert alert-danger">
		        ${requestScope.error}
		    </div>
		<% } %>
		<script>
		setTimeout(function() {
		    var errorDiv = document.getElementById("errorDiv");
		    if (errorDiv) {
		        errorDiv.style.display = "none";
		    }
		}, 3000);
		</script>
        <section class="h-auto w-auto bg-light">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-8 col-md-10">
                        <div class="card card-registration my-1">
                            <div class="row g-0">
                                <div class="col-xl-9">
                                    <div class="card-body p-md-5 text-black">
                                        <h3>Registrarse como:</h3>
                                        <select id="registerAs" class="form-control mb-4">
                                            <option value="postulante">Postulante</option>
                                            <option value="empresa">Empresa</option>
                                        </select>

                                        <form id="postulanteForm" action="registro" method="post">
                                            <input type="hidden" name="action" value="altaPostulante">
                                            <div class="form-group mb-2">
                                                <label for="nickname">Nickname:</label>
                                                <input type="text" id="nickname" name="nickname" class="form-control" required>
                                            </div>
                                            <div class="form-group mb-2">
					                              <label for="nombre">Nombre:</label>
					                              <input type="text" id="nombre" name="nombre" class="form-control" required>
					                          </div>
					                          <div class="form-group mb-2">
					                              <label for="apellido">Apellido:</label>
					                              <input type="text" id="apellido" name="apellido" class="form-control" required>
					                          </div>
					                          <div class="form-group mb-2">
					                              <label for="email">Email:</label>
					                              <input type="email" id="email" name="email" class="form-control" required>
					                          </div>
					                          <div class="form-group mb-2">
					                              <label for="fechaNacimiento">Fecha de Nacimiento:</label>
					                              <input type="date" id="fechaNacimiento" name="fechaNacimiento" class="form-control" required>
					                          </div>
					                          <div class="form-group mb-4">
					                              <label for="nacionalidad">Nacionalidad:</label>
					                              <select id="nacionalidad" name="nacionalidad" class="form-control">
					                                  <option value="Uruguayo">Uruguayo</option>
					                                  <option value="Argentino">Argentino</option>
					                                  <option value="Brasileño">Brasileño</option>
					                              </select>
					                          </div>
					                           <div class="form-group mb-2">
			                                        <label for="password">Contraseña:</label>
			                                        <input type="password" id="password" name="password" class="form-control" required>
			                                   		 <small>La contraseña debe tener al menos 6 caracteres.</small>
			                                    </div>
			                                <div class="form-group mb-3">
												    <label for="confirmar_contrasena">Confirmar Contraseña:</label>
											        <input type="password" id="confirmar_contrasena" name="confirmar_contrasena" class="form-control" required pattern=".{6,}">
										    </div>
					                          
                                            <button type="button" class="btn btn-dark btn-lg" onclick="window.location.href='visitante';">Cancelar</button>
                                            <button type="submit" id="submitButtonPostulante" class="btn btn-warning btn-lg">Enviar</button>
                                        </form>

                                        <form id="empresaForm" action="registro" method="post"  style="display: none;">
                                           <input type="hidden" name="action" value="altaEmpresa">
                                           <div class="form-group mb-2">
					                            <label for="nickname">Nickname:</label>
					                            <input class="form-control" type="text" id="nickname" name="nickname" required>
					                        </div>
					                
					                        
					                        <div class="form-group mb-2">
					                            <label for="nombre">Nombre:</label>
					                            <input class="form-control" type="text" id="nombre" name="nombre" required>
					                        </div>
					                
					                        
					                        <div class="form-group mb-2">
					                            <label for="apellido">Apellido:</label>
					                            <input class="form-control" type="text" id="apellido" name="apellido" required>
					                        </div>
					                
					                       
					                        <div class="form-group mb-2">
					                            <label for="email">Email:</label>
					                            <input class="form-control" type="email" id="email" name="email" required>
					                        </div>
					                
					                        
					                        <div class="form-group mb-2">
					                            <label for="nomEmpresa">Nombre de la Empresa:</label>
					                            <input class="form-control" type="text" id="nomEmpresa" name="nomEmpresa" required>
					                        </div>
					                
					                        
					                        <div class="form-group mb-2">
					                            <label for="desc">Descripción:</label>
					                            <textarea class="form-control" id="desc" name="desc" rows="4" cols="42" required></textarea>
					                        </div>
					                
					                       
					                        <div class="form-group mb-2">
					                            <label for="linkWeb">Sitio Web:</label>
					                            <input class="form-control" type="url" id="linkWeb" name="linkWeb">
					                        </div>
					                        
					                        <div class="form-group mb-2">
										        <label for="password">Contraseña:</label>
										        <input type="password" id="password" name="password" class="form-control" required>
										        <small>La contraseña debe tener al menos 6 caracteres.</small>
										    </div>
										    <div class="form-group mb-3">
												    <label for="confirmar_contrasena">Confirmar Contraseña:</label>
											        <input type="password" id="confirmar_contrasena" name="confirmar_contrasena" class="form-control" required pattern=".{6,}">
										    </div>
                                            
                                            <button type="button" class="btn btn-dark btn-lg" onclick="window.location.href='visitante';">Cancelar</button>
                                            <button type="submit"  id="submitButtonEmpresa" class="btn btn-warning btn-lg">Enviar</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>
    <script src="media/js/register.js"></script>
	<script src="media/js/index.js"></script>
</body>
</html>
