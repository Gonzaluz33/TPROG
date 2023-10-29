<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="servidor.publicar.DtOferta" %>
<%@ page import="servidor.publicar.DtPublicacion" %>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import=" utils.LocalDateSerializer"%>
<%@ page import="utils.LocalDateTimeAdapter"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="net.java.dev.jaxb.array.StringArray" %>


<!DOCTYPE html>
<html>
	<head>
    <jsp:include page="/WEB-INF/template/head.jsp"/>
	   <script>
	        <% if (request.getAttribute("sessionExpired") != null) { %>
	            alert("La sesión ha expirado. Por favor, inicie sesión nuevamente.");
	        <% } %>
	    </script>   
	</head>
<body>
		<% 
		String errorMessage = (String)session.getAttribute("errorMessage");
		session.removeAttribute("errorMessage"); 
		%>
		<% if(errorMessage != null && !errorMessage.isEmpty()) { %>
		     <div class="alert alert-danger error-message" role="alert">
		        <%= errorMessage %>
		    </div>
		<% } %>
		<script type="text/javascript">
		    $(document).ready(function() {
		        setTimeout(function() {
		            $(".error-message").fadeOut("slow");
		        }, 3000);
		    });
		</script>
		
		<%
		    String mensaje = request.getParameter("mensaje");
		    if (mensaje != null) {
			%>
			<div id="mensajeDiv" class="alert alert-success">
			    <%= mensaje %>
			</div>
			<script>
			    setTimeout(function() {
			        var mensajeDiv = document.getElementById('mensajeDiv');
			        if (mensajeDiv) {
			            mensajeDiv.style.display = 'none';
			        }
			    }, 3000); // 3000 milisegundos (3 segundos)
			</script>
			<%
			    }
		%>
    <nav class="navbar  navbar-light bg-light shadow mt-3">
        <div class="container-fluid mx-lg-3">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand fw-bold text-uppercase" href="#">Bienvenida Lucía</a>
                <div id="profile_img_container">
					    <img id="profile_img" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png" class="rounded-circle" alt="Foto de perfil" style="width:40px; height:40px; border: 2px solid black;">
                </div>
            <div class="collapse navbar-collapse my-3" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <hr class="d-lg-none">
                    <li class="nav-item">
                        <a class="nav-link fw-bold" href="#">Ver Ofertas Laborales</a>
                    </li>
                    <hr class="d-lg-none">
                    <li class="nav-item">
                        <a class="nav-link fw-bold" href="#">Ver Postulaciones</a>
                    </li>
                    <hr class="d-lg-none">
                    <li class="nav-item">
                        <a class="nav-link fw-bold" href="#">Salir</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container my-3">
        <div class="row">
            <div class="col-12 align-items-center d-flex ms-2">
                <div >
                    <button class="badge rounded-pill"onclick="window.history.back();">
                        <span class="badge rounded-pill  p-2"><i class=" text-black bi bi-caret-left-fill me-2"></i><span class="text-dark fw-bold">Volver Atrás</span></span>
                    </button>
                </div>
            </div>

        </div>
    </div>
    <div class="d-flex justify-content-center align-items-center bg-secondary p-2 text-light">
        <h1>Ver Ofertas Laborales</h1>
    </div>
        <div class="dropdown shadow p-2">
            <button class="btn btn-warning dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
              Empresas
            </button>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">ANTEL</a></li>
              <li class="border border-bottom"><a class="dropdown-item" href="#">EcoTech</a></li>
              <li  class="border border-bottom"><a class="dropdown-item" href="#">FusionTech</a></li>
              <li  class="border border-bottom"><a class="dropdown-item" href="#">GlobalHealth</a></li>
              <li  class="border border-bottom"><a class="dropdown-item" href="#">MIEM</a></li>
              <li  ><a class="dropdown-item" href="#">TechSolutions</a></li>
            </ul>
    </div>
   <div class="container mt-4">
        <div class="row">
     		<% 
		    	List<DtPublicacion> publicaciones = (List<DtPublicacion>) request.getAttribute("publicaciones");
		        for(DtPublicacion publicacion : publicaciones) {
		    %>
            <div class="col-md-4 mb-4">
                <div class="card  shadow">
                    <img src="<%= publicacion.getDtOferta().getUrlImagen()%>" class="card-img-top" alt="Nombre oferta 1">
                    <div class="card-body">
                        <h5 class="card-title"><%= publicacion.getDtOferta().getNombre() %></h5>
                    </div>
                    <span class="badge bg-dark"><a href="consultaOferta?nombreOferta=<%= URLEncoder.encode(publicacion.getDtOferta().getNombre(), "UTF-8") %>" class="text-white text-decoration-none">Ver más</a></span>
                </div>
            </div>
    		<% 
			  }
			%>
            <!-- Puedes seguir agregando más ofertas laborales de la misma manera -->
        </div>
    <script src="media/js/login.js"></script>
	<script src="media/js/index.js"></script>
	<script src="media/js/bootstrap.min.js?v=<?php echo time(); ?>"></script>
 	<script src="media/js/jquery-3.7.1.min.js?v=<?php echo time(); ?>"></script>
</body>	
	
	
	
</html>