<%@page import="java.util.List"%>
<%@page import="utils.DTUsuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		 <jsp:include page="/WEB-INF/template/head.jsp"/>
	</head>
	<body>
		    <header>
		        <nav class="navbar p-0 border-bottom border-black mb-1">
		            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
		                <div class="d-flex" style="width: 80vw;">
		                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
		                    <h3 class="m-0 d-flex align-items-center">Consulta de Usuario</h3>
		                </div>
		            </div>
		        </nav>
		    </header>
		    <main>
		        <jsp:include page="/WEB-INF/template/NavBarVisitante.jsp" />
		        <div class="d-flex flex-column justify-content-center p-4">
		   
				    <h1>Lista de Usuarios</h1>
			    
				    <ul>
				        <% List<DTUsuario> usuarios = (List<DTUsuario>) request.getAttribute("usuarios");
				           for (DTUsuario usuario : usuarios) { %>
				            <li><a href="mostrarUsuario?nickname=<%= usuario.getNickname()%>"><%= usuario.getNickname()%></a></li>
				        <% } %>
				    </ul>
	
	            </div>
		    </main>
	</body>
</html>