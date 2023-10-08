<%@page import="utils.DTOferta"%>
<%@page import="utils.DTPostulacion"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>

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
                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
                    <h3 class="m-0 d-flex align-items-center">Consulta de Postulación a Oferta Laboral</h3>
                </div>
                <jsp:include page="/WEB-INF/template/CerrarSesionEmpresa.jsp" />
            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp" />
        <div class="d-flex flex-column justify-content-center p-4">
            <div class="d-flex mt-4 gap-3 flex-column">
                <div class="d-flex gap-5">
                    <div>
                        <% 
                        DTOferta oferta = (DTOferta) request.getAttribute("oferta");
                    	List<DTPostulacion> posts = (List<DTPostulacion>) oferta.getPostulaciones();
                    	System.out.println(oferta.getNombre()); %>
  				      <h2>Postulaciones a <%=oferta.getNombre() %>:</h2>
					<% 	
                    	for (DTPostulacion post: posts) {   
                    		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	                        String formattedDate = post.getFecha().format(formatter);
                    %>                    
				      
				      <div class="card mb-2">
				      <div class="card-body">
				      	<h5 class="card-title">
    						<%=post.getNicknamePostulante()%>
				      	</h5>
				      	<p class="m-0 card-text"><span class="fw-bold">Motivacion: </span><%=post.getMotivacion() %></p>
                   		<p class="m-0 card-text"><span class="fw-bold">Cv reducido: </span><%=post.getCvReducido() %></p>
                  		<p class="m-0 card-text"><span class="fw-bold">Fecha de postulacion: </span><%=formattedDate %></p>		
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