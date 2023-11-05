<%@page import="servidor.publicar.DtEmpresa"%>
<%@page import="java.util.Set"%>
<%@page import="servidor.publicar.DtOferta"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<body>
    <header>
        <nav class="navbar">
            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex" style="width: 80vw;">
                    <div>
                        <a class="navbar-brand" href="/tarea2/visitante"><img width="160" src="media/img/trabajo_logo.png"
                                alt=""></a>
                    </div>
                    <h3 class="m-0 d-flex align-items-center">Info Usuario</h3>
                </div>
            </div>
        </nav>
    </header>
    <main>
    <jsp:include page="/WEB-INF/template/NavBarVisitante.jsp" />
    <div class="container my-5">
        <%
            DtEmpresa usuario = (DtEmpresa) request.getAttribute("usuarioSeleccionado");
        %>
        <div class="row">
 
            <div class="col-lg-5 d-flex justify-content-center align-items-center">
                <img src="<%=usuario.getUrlImagen() %>" class="img-fluid rounded-circle" alt="Imagen de perfil" style="max-width: 75%;">
            </div>

            <div class="col-lg-7 d-flex flex-column justify-content-center">
                <div class="card ">
                <div class="card-header">
                <h2>Datos Personales:</h2>
                </div>
                <div class="card-body">
                 <p class="m-0"><span class="fw-bold">Nickname: </span><%= usuario.getNickname() %></p>
                    <p class="m-0"><span class="fw-bold">Nombre: </span><%= usuario.getNombre() %></p>
                    <p class="m-0"><span class="fw-bold">Apellido: </span><%= usuario.getApellido() %></p>
                    <p class="m-0"><span class="fw-bold">Email: </span><%= usuario.getCorreo() %></p>
                </div>
                    
                   
                </div>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col d-flex justify-content-center">
                <button type="button" class="btn btn-dark btn-lg" onclick="window.history.back();" >Volver</button>
            </div>
        </div>
    </div>
</main>
</body>

</html>