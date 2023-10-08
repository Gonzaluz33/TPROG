<%@page import="utils.DTOferta"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="java.lang.reflect.Type"%>
<%@ page import="com.google.gson.reflect.TypeToken"%>
<%@ page import="com.google.gson.GsonBuilder"%>
<%@ page import="java.time.LocalDateTime"%>
<%@ page import="com.google.gson.reflect.TypeToken"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import=" utils.LocalDateSerializer"%>
<%@ page import="utils.LocalDateTimeAdapter"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="utils.LocalDateTimeAdapter"%>

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
                    <h3 class="m-0 d-flex align-items-center">Consulta de Oferta Laboral</h3>
                </div>
                 <jsp:include page="/WEB-INF/template/CerrarSesionEmpresa.jsp"/>
            </div>
        </nav>
    </header>
    <main>
 		<jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp"/>
    <div class="p-1 mt-2 d-flex flex-column">
    <%  String ofertaJSON = (String) request.getAttribute("oferta");
    				Gson gson = new Gson();
		            DTOferta oferta = gson.fromJson(ofertaJSON, DTOferta.class);
		            if(oferta != null){
		 %>
        <div class="row d-flex text-center align-items-center justify-content-center">
                <div>
                    <img class="w-75" src="<%= oferta.getImagen() %>" alt="">
                </div>
                
                </div>
                <div>
                    <div class="row d-flex  mt-3">
                        <div class="text-start align-items-center justify-content-center">
                            <h3 class="fw-bold"><%= oferta.getNombre() %></h3>
                        </div>
                        <p><span class="fw-bold">Descripción: </span><%= oferta.getDescripcion() %></p>
                    </div>
                    <div class="row d-flex ">
                        <p class="m-0"><span class="fw-bold">Remuneración: </span><%= oferta.getRemuneracion() %> pesos uruguayos </p>
                        <p class="m-0"><span class="fw-bold">Horario: </span> <%= oferta.getHorario() %> </p>
                        <p class="m-0"><span class="fw-bold">Departamento: </span><%= oferta.getDepartamento() %></p>
                        <p class="m-0"><span class="fw-bold">Ciudad: </span><%= oferta.getCiudad() %> </p>

                    </div>
                    <div class="row d-flex  mt-3">
                        <p class="m-0"><span class="fw-bold">Fecha de alta:</span> <%= oferta.getFechaAlta() %></p>
                    </div>
                
                    <div class="row d-flex  mt-3">
                        <p class="m-0"><span class="fw-bold"> Keywords:</span>  <% for(String keyword : oferta.getKeywords()){ %>
                      <span class="badge bg-info"><%= keyword %></span>
                  <% } %>
                
                    </div>
                </div>
                <div class="mt-4">
                    <div class="dropdown">
                        <button class="btn btn-dark dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Opciones
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="./consultaPostulacionOferta?<%=oferta.getNombre() %>>">Ver listado de Postulantes</a></li>
                        </ul>
                    </div>
                </div>
            </div>
           <% } %>
        </div>   
    </div>
    </main>
</body>
</html>