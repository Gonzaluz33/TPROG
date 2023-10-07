<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="utils.DTOferta" %>
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
<!DOCTYPE html>
<html lang="en">

<head>
     <jsp:include page="/WEB-INF/template/head.jsp"/>
      <% Gson gson = new GsonBuilder()
     		    .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
     		    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
     		    .create(); 
        %>
         <%   String imgPerfilJSON = (String) request.getAttribute("imgPerfil");
		 %>
</head>

<body>
    <header>
         <nav class="navbar p-3">
            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex ms-5">
                      <jsp:include page="/WEB-INF/template/Logo.jsp"/>
                </div>
                  <div class="d-flex me-5">
					 <div class="d-flex">
					    <img src="<%=imgPerfilJSON%>" class="rounded-circle" alt="Foto de perfil" style="width:40px; height:40px; border: 2px solid black;">
					  </div>
				     <div class="d-flex border-end px-2 mt-2">
				         <a href="/tarea2/miUsuario" class="text-decoration-none text-black fw-bold ">Mi Usuario</a>
				     </div>
				     <div class="d-flex px-2 mt-2">
				         <a class="text-decoration-none text-black fw-bold " href="/tarea2/cerrar-sesion">Cerrar Sesión<i class="ms-2 fas fa-sign-out-alt"></i></a>
				     </div>
				 </div>
            </div>
        </nav>
    </header>
    <main>
 		<jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp"/>

          <%  String ofertaJSON = (String) request.getAttribute("oferta");
		            DTOferta oferta = gson.fromJson(ofertaJSON, DTOferta.class);
		            if(oferta != null){
			%>
			    <div class="p-1 mt-2 d-flex flex-column">
			        <div class="d-flex justify-content-center">
			            <div class="row d-flex text-center align-items-center justify-content-center">
			                <div>
			                    <img class="w-75" src="<%=oferta.getImagen()%>" alt="">
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
			    
			                    <p class="m-0"><span class="fw-bold">Tipo de Publicacion:</span> Premium <a
			                            href="./consultaTipoPublicacion.html">Ver más</a></p>
			    
			                </div>
			                <div class="row d-flex  mt-3">
			                    <p class="m-0"><span class="fw-bold">Fecha de alta: </span> <%= oferta.getFechaAlta() %></p>
			                    <p class="m-0"><span class="fw-bold">Forma de Pago: </span>Paquete</p>
			                    <p class="m-0"><span class="fw-bold">Tipo de Paquete: </span><a href="#">Básico</a></p>
			                </div>
			    
			                <div class="row d-flex  mt-3">
                                <p class="m-0"><span class="fw-bold"> Keywords:</span>  <% for(String keyword : oferta.getKeywords()){ %>
		                            <span class="badge bg-info"><%= keyword %></span>
		                        <% } %>
                        
                            </div>
			                <div class="mt-4">
			                    <div class="dropdown">
			                        <button class="btn btn-dark dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
			                            Opciones
			                        </button>
			                        <ul class="dropdown-menu">
			                            <li><a class="dropdown-item" href="./consultaPostulacionOferta.html">Ver listado de Postulantes</a></li>
			                        </ul>
			                    </div>
			                </div>
			            </div>
			           
			        </div>   
			    </div>
    			 <%
		            } else {
		                %>
		                    <div class="alert alert-danger" role="alert">
		                        Lo sentimos, no se pudo encontrar la oferta solicitada.
		                    </div>
		                <%  
		                    }
		                %>
    </main>
</body>
</html>