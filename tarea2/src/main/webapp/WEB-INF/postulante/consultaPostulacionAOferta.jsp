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
                    <h3 class="m-0 d-flex align-items-center">Consulta Postulación a Oferta Laboral</h3>
                </div>
                <jsp:include page="/WEB-INF/template/CerrarSesionPostulante.jsp" />
                
            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp"/>
        <div class="d-flex flex-column justify-content-center p-4">
            <div class="d-flex mt-4 gap-3 flex-column">
                <div class="d-flex gap-5">
                    <div>
                        <h2>Mis Postulaciones:</h2>
                        <% 
                        DTPostulante usuario = (DTPostulante) request.getAttribute("usuario");
                    	List<DTPostulacion> posts = (List<DTPostulacion>) usuario.getPostulaciones();
                    	for (DTPostulacion post: posts) {                    	
                    %>                    
				      
				      <div class="card mb-2">
				      <div class="card-body">
				      	<h5 class="card-title">
    						<%=post.getNombreOfertaLaboral()%>
				      	</h5>
				      	<p class="m-0 card-text"><span class="fw-bold">Motivacion: </span><%=post.getMotivacion() %></p>
                   		<p class="m-0 card-text"><span class="fw-bold">Cv reducido: </span><%=post.getCvReducido() %></p>
                  		<p class="m-0 card-text"><span class="fw-bold">Fecha de postulacion: </span><%=post.getFecha() %></p>		
				      </div>
				      				     
				      </div>
					<% } %>
                    </div>
              
                </div>
            </div>

        </div>
    </main>
</body>

</html>