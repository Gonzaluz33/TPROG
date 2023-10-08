<%@page import="java.util.List"%>
<%@page import="utils.DTTipoPublicacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <jsp:include page="/WEB-INF/template/head.jsp"/>
</head>
<body>
    <header>
        <nav class="navbar p-0 border-bottom border-black mb-1">
            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex" style="width: 80vw;">
                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
                    <h3 class="m-0 d-flex align-items-center">Consultar Tipo de Publicación</h3>
                </div>
                <jsp:include page="/WEB-INF/template/CerrarSesionPostulante.jsp" />
            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp" />
        <div class="d-flex flex-column justify-content-center p-4">
            <h2>Seleccione un Tipo de Publicación:</h2>
            <div class="d-flex mt-4 gap-3 flex-column">
                <ul>
				        <% List<DTTipoPublicacion> tiposPublicacion = (List<DTTipoPublicacion>) request.getAttribute("tiposPublicacion");
				           for (DTTipoPublicacion tipo : tiposPublicacion) { %>
				            <li><a href="mostrarTipo?nombre=<%= tipo.getNombre()%>"><%= tipo.getNombre()%></a></li>
				        <% } %>
				    </ul>
            </div>
        </div>

    </main>
</body>
</html>