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
    </head>
    <body>
        <header>
            <nav class="navbar bg-body-tertiary border-bottom border-black">
                <div class="container d-flex py-1 ">
                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
                    <div style="width: 80%;">
                        <form class="d-flex " role="search">
                            <input class="form-control square-corners  me-2 " type="search"
                                placeholder="Búsqueda de ofertas laborales" aria-label="Search">
                            <button class="btn btn-outline-light bg-dark square-corners" type="submit"><i
                                    class="fas fa-search"></i>Buscar</button>
                        </form>
                    </div>
                </div>     
            </nav>
        </header>
       <main>
		    <jsp:include page="/WEB-INF/template/NavBarVisitante.jsp" />
		    <div class="container mt-5">
		        <%  String ofertaJSON = (String) request.getAttribute("oferta");
		            DTOferta oferta = gson.fromJson(ofertaJSON, DTOferta.class);
		            if(oferta != null){
		        %>
		            <div class="card mb-5">
		                <div class="card-header">
		                    <h3 class="fw-bold m-3"><%= oferta.getNombre() %></h3>
		                    <div class="col-md-6">
			                    <img src="https://tinyurl.com/45nsf34m" class="img-fluid w-50 m-2" alt="Imagen de la oferta laboral">
			                </div>
		                </div>
		                <div class="card-body">
		                    <p><span class="fw-bold">Descripción:</span> <%= oferta.getDescripcion() %></p>
		                    <p class="m-0"><span class="fw-bold">Remuneración:</span> <%= oferta.getRemuneracion() %> pesos uruguayos </p>
		                    <p class="m-0"><span class="fw-bold">Horario:</span> <%= oferta.getHorario() %> </p>
		                    <p class="m-0"><span class="fw-bold">Departamento:</span> <%= oferta.getDepartamento() %> </p>
		                    <p class="m-0"><span class="fw-bold">Ciudad:</span> <%= oferta.getCiudad() %> </p>
		                </div>
		                <div class="card-footer">
		                    <p class="m-0"><span class="fw-bold">Fecha de alta:</span> <%= oferta.getFechaAlta() %></p>
		                    <p class="m-0"><span class="fw-bold"> Keywords:</span>
		                        <% for(String keyword : oferta.getKeywords()){ %>
		                            <span class="badge bg-info"><%= keyword %></span>
		                        <% } %>
		                    </p>
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
		   </div>
		</main>
    </body>
</html>