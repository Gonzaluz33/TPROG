<%@page import="java.util.List"%>
<%@page import="utils.DTEmpresa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		 <jsp:include page="/WEB-INF/template/head.jsp"/>
	</head>
	<body>
		    <header>
		        <nav class="navbar p-3">
		            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
		                <div class="d-flex" style="width: 80vw;">
		                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
		                    <h3 class="m-0 d-flex align-items-center">Postular A Oferta Laboral</h3>
		                </div>
		            	<jsp:include page="/WEB-INF/template/CerrarSesionPostulante.jsp" />
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
			                        <h3 class="card-title">Seleccione una Empresa:</h3>
			                    </div>
			                    <div class="card-body">
			                        <ul class="list-group list-group-flush">
			                            <% List<DTEmpresa> empresas = (List<DTEmpresa>) request.getAttribute("empresas");
			                               for (DTEmpresa empresa : empresas) { %>
			                            <li class="list-group-item">
			                                <a class="text-decoration-none text-black fw-bold" href="mostrarOfertasAPostular?Empresa=<%= empresa.getNickname()%>"><%= empresa.getNombreEmpresa()%></a>                         
			                            </li>
			                            <% } %>
			                        </ul>
			                    </div>
			                </div>
			            </div>
					</div>
					<div class="mt-4">
					    <a href="postulante" class="btn btn-dark">Volver atrás</a>
					</div>
				</div>
			</main>
	</body>
</html>