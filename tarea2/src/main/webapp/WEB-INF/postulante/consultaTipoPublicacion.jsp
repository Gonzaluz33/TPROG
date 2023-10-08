<%@page import="java.util.List"%>
<%@page import="utils.DTTipoPublicacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <jsp:include page="/WEB-INF/template/head.jsp"/>
      <%   String imgPerfilJSON = (String) request.getAttribute("imgPerfil");
		 %>
</head>
<body>
    <header>
         <nav class="navbar p-3">
            <div class="d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex">
                    <div class="ms-5">
                        <a class="navbar-brand" href="/tarea2/postulante"><img class="img-fluid w-50" src="media/img/trabajo_logo.png" alt=""></a>
                    </div>
                  
                </div>

                 <div class="d-flex me-5">
                 
				 <div class="d-flex me-5">
					 <div class="d-flex">
					    <img src="<%=imgPerfilJSON%>" class="rounded-circle" alt="Foto de perfil" style="width:40px; height:40px; border: 2px solid black;">
					  </div>
				     <div class="d-flex border-end px-2 mt-2">
				         <a href="/tarea2/miUsuario" class="text-decoration-none text-black fw-bold "><img src="">Mi Usuario</a>
				     </div>
				     <div class="d-flex px-2 mt-2">
				         <a class="text-decoration-none text-black fw-bold " href="/tarea2/cerrar-sesion">Cerrar Sesión<i class="ms-2 fas fa-sign-out-alt"></i></a>
				     </div>
 </div>
 				</div>

            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp" />
         <div class="container my-5">
	    <h2 class="mb-4">Seleccione un Tipo de Publicación:</h2>
	    <ul class="list-group">
	        <% List<DTTipoPublicacion> tiposPublicacion = (List<DTTipoPublicacion>) request.getAttribute("tiposPublicacion");
	           for (DTTipoPublicacion tipo : tiposPublicacion) { %>
	        <li class="list-group-item">
	            <a class="text-decoration-none text-black fw-bold" href="mostrarTipo?nombre=<%= tipo.getNombre()%>"><%= tipo.getNombre()%></a>
	        </li>
	        <% } %>
	    </ul>
	     <div class="mt-4">
	            <a href="visitante" class="btn btn-dark">Volver atrás</a>
	        </div>
		</div>


    </main>
</body>
</html>