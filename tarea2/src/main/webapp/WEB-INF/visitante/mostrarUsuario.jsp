<%@page import="utils.DTUsuario"%>

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
                    <h3 class="m-0 d-flex align-items-center">Info Usuario</h3>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <div class="d-flex col-10 gap-5 p-5">
            <div class="d-flex justify-content-center">
                <img width="250" height="250" src="https://tinyurl.com/yckek63e" alt="">
            </div>
            <div class="d-flex gap-5">
            	<%
            		DTUsuario usuario = (DTUsuario) request.getAttribute("usuarioSeleccionado");
            	%>
                <div>
                    <h2>Datos Personales:</h2>
                    <p class="m-0"><span class="fw-bold">Nickname: </span><%= usuario.getNickname() %></p>
                    <p class="m-0"><span class="fw-bold">Nombre: </span><%= usuario.getNombre() %></p>
                    <p class="m-0"><span class="fw-bold">Apellido: </span><%= usuario.getApellido() %></p>
                    <p class="m-0"><span class="fw-bold">Email: </span><%= usuario.getCorreo() %></p>
                </div>

            </div>

        </div>
        
        <div class="d-flex col-10 p-5">
        	<div class="d-flex justify-content-center">
               <button type="button" class="btn btn-dark btn-lg" onclick="window.location.href='consultaUsuario';">Volver</button>
           </div>
        </div>
    </main>
</body>

</html>