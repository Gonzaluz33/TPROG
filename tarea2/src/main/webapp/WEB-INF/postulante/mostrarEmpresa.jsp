<%@page import="utils.DTEmpresa"%>
<%@page import="java.util.Set"%>
<%@page import="utils.DTOferta"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/template/head.jsp" />
    <%   String imgPerfilJSON = (String) request.getAttribute("imgPerfil");
		 %>
</head>
<body>
    <header>
        <nav class="navbar p-3">
            <div class="d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex">
                    <div class="ms-5">
                        <a class="navbar-brand" href="/tarea2/postulante"><img class="img-fluid w-50" src="media/img/trabajo_logo.png" alt=""></a>
                    </div>
                  
                </div>
                 <div class="d-flex me-5">
                 
				 <div class="d-flex me-5">
					 <div class="d-flex">
					    <img src="<%=imgPerfilJSON%>" class="rounded-circle" alt="Foto de perfil" style="width:40px; height:40px; border: 2px solid black;">
					  </div>
				     <div class="d-flex border-end px-2 mt-2">
				         <a href="/tarea2/miUsuario" class="text-decoration-none text-black fw-bold "><img src="">Mi Usuario</a>
				     </div>
				     <div class="d-flex px-2 mt-2">
				         <a class="text-decoration-none text-black fw-bold " href="/tarea2/cerrar-sesion">Cerrar Sesión<i class="ms-2 fas fa-sign-out-alt"></i></a>
				     </div>
 </div>
 				</div>
            </div>
        </nav>
    </header>
    <main>
    <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp" />
    <div class="container my-5">
        <%
            DTEmpresa usuario = (DTEmpresa) request.getAttribute("usuarioSeleccionado");
        %>
        <div class="row">
            <!-- Columna para la imagen -->
            <div class="col-lg-5 d-flex justify-content-center align-items-center">
                <img src="<%=usuario.getUrlImagen() %>" class="img-fluid rounded-circle" alt="Imagen de perfil" style="max-width: 75%;">
            </div>
            <!-- Columna para los datos personales -->
            <div class="col-lg-7 d-flex flex-column justify-content-center">
                <div class="card">
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
        <!-- Fila para el botón de volver -->
        <div class="row mt-5">
            <div class="col d-flex justify-content-center">
                <button type="button" class="btn btn-dark btn-lg" onclick="window.history.back();" >Volver Atrás</button>
            </div>
        </div>
    </div>
</main>
</body>

</html>