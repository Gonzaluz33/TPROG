<%@page import="utils.DTTipoPublicacion"%>

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
                        <a class="navbar-brand" href="/tarea2/empresa"><img width="160" src="media/img/trabajo_logo.png"
                                alt=""></a>
                    </div>
                    <h3 class="m-0 d-flex align-items-center">Tipo de Publicación Seleccionado</h3>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <div class="d-flex col-10 gap-5 p-5">
            <div class="d-flex gap-5">
            	<%
            	DTTipoPublicacion tipo = (DTTipoPublicacion) request.getAttribute("tipoSeleccionado");
            	%>
                <div>
                        <p class="m-0"><span class="fw-bold">Nombre: </span><%= tipo.getNombre() %></p>
                        <p class="m-0"><span class="fw-bold">Descripción: </span><%= tipo.getDescripcion() %></p>
                        <p class="m-0"><span class="fw-bold">Exposicion: </span><%= tipo.getExposicion() %></p>
                        <p class="m-0"><span class="fw-bold">Duración: </span><%= tipo.getDuracion() %> Días</p>
                        <p class="m-0"><span class="fw-bold">Costo: </span><%= tipo.getCosto() %></p>
                        <p class="m-0"><span class="fw-bold">Fecha de Alta: </span><%= tipo.getAlta()%></p>
                </div> 
            </div>

        </div>
        
        <div class="d-flex col-10 p-5">
        	<div class="d-flex justify-content-center">
               <button type="button" class="btn btn-dark btn-lg" onclick="window.location.href='consultaTipos';">Volver</button>
           </div>
        </div>
    </main>
</body>

</html>