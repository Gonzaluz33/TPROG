<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<%@page import="utils.DTOferta"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="java.lang.reflect.Type"%>
<%@ page import="com.google.gson.reflect.TypeToken"%>
<%@ page import="com.google.gson.GsonBuilder"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import=" utils.LocalDateSerializer"%>
<%@ page import="utils.LocalDateTimeAdapter"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		 <jsp:include page="/WEB-INF/template/head.jsp"/>
		 <% Gson gson = new GsonBuilder()
     		    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
     		    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
     		    .create(); 
        %>
	</head>
	<body>
		    <header>
		        <nav class="navbar p-3">
		            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
		                <div class="d-flex" style="width: 80vw;">
		                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
		                    <h3 class="m-0 d-flex align-items-center">Postular A Oferta Laboral</h3>
		                </div>
		            </div>
		        </nav>
		    </header>
		   <main>
			    <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp" />
			    <div class="container my-5">
			        <div class="row">
			            <div class="col-md-6">
			                <div class="card">
			                    <div class="card-header">
			                        <h3 class="card-title">Seleccione una Oferta:</h3>
			                    </div>
			                    <div class="card-body">
			                        <ul class="list-group list-group-flush">
			                            <%
			                            	String ofertasJSON = (String) request.getAttribute("ofertasVigentes");
			                            	Type listType = new TypeToken<Set<DTOferta>>() {}.getType();	
			                            	Set<DTOferta> ofertas = gson.fromJson(ofertasJSON, listType);
			                               for (DTOferta oferta : ofertas) { %>
			                            <li class="list-group-item">
			                                <a class="text-decoration-none text-black fw-bold" href="confirmarPostulacion?NombreOferta=<%= oferta.getNombre()%>"><%= oferta.getNombre()%></a>                             
			                            </li>
			                            <% } %>
			                        </ul>
			                    </div>
			                </div>
			            </div>
					</div>
					<div class="mt-4">
					    <a href="postularAOferta" class="btn btn-dark">Volver atrás</a>
					</div>
				</div>
			</main>
	</body>
</html>