<%@page import="utils.DTPostulante"%>
<%@page import="utils.DTPostulacion"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<body>
    <header>
        <nav class="navbar p-0 border-bottom border-black mb-1">
            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex" style="width: 80vw;">
                    <div>
                        <a class="navbar-brand" href="/tarea2/postulante"><img width="160" src="media/img/trabajo_logo.png"
                                alt=""></a>
                    </div>
                    <h3 class="m-0 d-flex align-items-center">Info Usuario</h3>
                </div>
				<jsp:include page="/WEB-INF/template/CerrarSesionPostulante.jsp" />
            </div>
        </nav>
    </header>
    <main>
       	<jsp:include page="/WEB-INF/template/NavBarPostulante.jsp" />
        <div class="d-flex col-10 gap-5 p-5">
            <div class="d-flex justify-content-center">
                <img width="250" height="250" src="https://tinyurl.com/yckek63e" alt="">
            </div>
            <div class="d-flex gap-5">
            	<%
            		DTPostulante usuario = (DTPostulante) request.getAttribute("usuarioSeleccionado");
            	%>
                <div>
                    <h2>Datos Personales:</h2>
                    <p class="m-0"><span class="fw-bold">Nickname: </span><%= usuario.getNickname() %></p>
                    <p class="m-0"><span class="fw-bold">Nombre: </span><%= usuario.getNombre() %></p>
                    <p class="m-0"><span class="fw-bold">Apellido: </span><%= usuario.getApellido() %></p>
                    <p class="m-0"><span class="fw-bold">Email: </span><%= usuario.getCorreo() %></p>
                </div>
               
                <div>
                    <h2>Mis postulaciones:</h2>
                    <% 
                    	List<DTPostulacion> posts = (List<DTPostulacion>) usuario.getPostulaciones();
                    	for (DTPostulacion post: posts) {                    	
                    %>
                    <p class="m-0"><span class="fw-bold">Nombre de Oferta Laboral: </span>Desarrollador Frontend</p>
                    
					<div class="accordion-item">
					    <h2 class="accordion-header">
					      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
							<%=post.getNombreOfertaLaboral()%>
					      </button>
					    </h2>
					    <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
					      <div class="accordion-body">
					      	<p class="m-0"><span class="fw-bold">Motivacion: </span><%=post.getMotivacion() %></p>
                    		<p class="m-0"><span class="fw-bold">Cv reducido: </span><%=post.getCvReducido() %></p>
                   			<p class="m-0"><span class="fw-bold">Nombre de Oferta Laboral: </span><%=post.getFecha() %></p>					     
					      </div>
					    </div>
					  </div>
					<% } %>
                </div>
                
            </div>

        </div>
        
        <div class="d-flex col-10 p-5">
        	<div class="d-flex justify-content-center">
               <button type="button" class="btn btn-dark btn-lg" onclick="window.location.href='consultaUsuario';">Volver</button>
           </div>
        </div>
    </main>
</body>

</html>