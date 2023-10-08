<%@ page import="utils.DTOferta"%>
<%@ page import="java.util.Set"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <jsp:include page="/WEB-INF/template/Logo.jsp"/>
                    <h3 class="m-0 d-flex align-items-center">Consulta de Postulación a Oferta Laboral</h3>
                </div>
                 <jsp:include page="/WEB-INF/template/CerrarSesionEmpresa.jsp"/>
            </div>
        </nav>
    </header>
    <main>
         <jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp"/>
    <div class="d-flex flex-column justify-content-center p-4">
            <h2>Seleccione una Oferta:</h2>
            <div class="d-flex mt-4 gap-3 flex-column">
                <ul>
				        <% Set<DTOferta> ofertas = (Set<DTOferta>) request.getAttribute("ofertas");
				           for (DTOferta oferta : ofertas) { %>
				            <li><a href="mostrarPostulacion?nombre=<%= oferta.getNombre()%>"><%= oferta.getNombre()%></a></li>
				        <% } %>
				    </ul>
            </div>
        </div>
    </main>
</body>

</html>