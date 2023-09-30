<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
    <jsp:include page="/WEB-INF/template/head.jsp" />
	<title>Trabajo.uy</title>
	
	  <!-- Tu código JavaScript para mostrar la alerta -->
    <script>
        <% if (request.getAttribute("sessionExpired") != null) { %>
            alert("La sesión ha expirado. Por favor, inicie sesión nuevamente.");
        <% } %>
    </script>
	
	</head>
	<body>
		<jsp:include page="/WEB-INF/template/headerVisitante.jsp" />
		<!-- Modal Login-->
		<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="loginModalLabel">Iniciar Sesión</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="iniciar-sesion" method="post">
			          <div class="form-group mb-2">
			            <label class="mb-3" for="login">Email</label>
			            <input type="text" class="form-control" id="login" name="login" placeholder="Ingrese su email">
			          </div>
			          <div class="form-group mb-2">
			            <label class="mb-3" for="password">Contraseña</label>
			            <input type="password" class="form-control" id="password" name="password" placeholder="Ingrese su contraseña">
			          </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary btn-dark" data-bs-dismiss="modal">Cerrar</button>
			        <!-- Cambia el tipo de botón a 'submit' para enviar el formulario al servlet -->
			        <button type="submit" class="btn btn-warning">Iniciar sesión</button>
			      </div>
		      </form>
		    </div>
		  </div>
		</div>
		<!-- Modal Login
		<div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="loginModalLabel">Iniciar Sesión</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form>
		          <div class="form-group mb-2">
		            <label class="mb-3" for="email">Email</label>
		            <input type="email" class="form-control" id="email" placeholder="Ingrese su email">
		          </div>
		          <div class="form-group mb-2">
		            <label class="mb-3" for="password">Contraseña</label>
		            <input type="password" class="form-control" id="password" placeholder="Ingrese su contraseña">
		          </div>
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary btn-dark" data-bs-dismiss="modal">Cerrar</button>
		        <button type="submit" class="btn btn-warning">Iniciar sesión</button>
		      </div>
		    </div>
		  </div>
		</div>-->
		<!--  <nav class="navbar navbar-expand-lg bg-body-tertiary bg-navbar">
	    <div class="container-fluid justify-content-center">
	      <div class="collapse navbar-collapse justify-content-center">
	        <ul class="navbar-nav">
	          <li class="nav-item">
	            <a class="nav-link active text-white" aria-current="page" href="index.html">Inicio</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link active text-white" aria-current="page" href="./visitante/ConsultaDeUsuario.html">Consulta de Usuario</a>
	          </li>
	          <li class="nav-item dropdown">
	            <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	              Paquetes y Tipos de Publicación
	            </a>
	            <ul class="dropdown-menu">
	              <li><a class="dropdown-item" href="./visitante/ConsultaPaquete.html">Consultar Paquetes</a></li>
	              <li><a class="dropdown-item" href="./visitante/ConsultaTipos.html">Consultar Tipos de Publicación</a></li>
	            </ul>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link text-white" href="./postulante/dashboardPostulante.html">Dashboard Postulante</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link text-white" href="./Empresa/dashboardEmpresa.html">Dashboard Empresa</a>
	          </li>
	        </ul>
	      </div>
	    </div>
	  </nav>
	  -->	
		<main>	
			<!-- El contenido principal del sitio web -->
			   <div class="container-fluid mt-3">
			        <div class="row">
			            <div class="col-md-2  mt-2 col-sm-12">
			               <div class=" container-fluid p-3 mx-auto border border-dark text-center" id="keywordList">
			                <h4>Filtrar Publicaciones:</h4>
			                <h5>Keywords</h5>
			                <br>
			                  <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                    <label class="form-check-label" for="flexCheckChecked">
			                      Tiempo Completo
			                    </label>
			                  </div>
			                  <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                    <label class="form-check-label" for="flexCheckChecked">
			                      Medio Tiempo
			                    </label>
			                  </div>
			                  <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                    <label class="form-check-label" for="flexCheckChecked">
			                      Remoto
			                    </label>
			                  </div>
			                  <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                    <label class="form-check-label" for="flexCheckChecked">
			                      Freelance
			                    </label>
			                  </div>
			                  <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                    <label class="form-check-label" for="flexCheckChecked">
			                      Temporal
			                    </label>
			                  </div>
			                  <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                    <label class="form-check-label" for="flexCheckChecked">
			                      Permanente
			                    </label>
			                  </div>
			                  <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                    <label class="form-check-label" for="flexCheckChecked">
			                      Computación
			
			                    </label>
			                  </div>
			                  <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                    <label class="form-check-label" for="flexCheckChecked">
			                      Administración
			                    </label>
			                  </div>
			                  <div class="form-check">
			                    <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                    <label class="form-check-label" for="flexCheckChecked">
			                      Logística
			                    </label>
			                  </div>
			                    <div class="form-check">
			                      <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
			                      <label class="form-check-label" for="flexCheckChecked">
			                        Contabilidad
			                      </label>
			                    </div>                    
			              </div>
			            </div>
			            <div class="col-md-10 col-sm-12 p-2" id="mainContent">
			                
			            </div>
			        </div>
			      </div>
		</main>
	    <script src="media/js/login.js"></script>
	    <script src="media/js/index.js"></script>
	   
	</body>
</html>