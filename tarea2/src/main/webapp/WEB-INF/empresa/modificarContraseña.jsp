<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="servidor.publicar.DtUsuario"%>
<%@page import="servidor.publicar.DtPostulante"%>
<%@page import="servidor.publicar.DtEmpresa"%>
    
<!DOCTYPE html>
<html>
	<head>
	<jsp:include page="/WEB-INF/template/head.jsp"/>
	<%   String imgPerfilJSON = (String) request.getAttribute("imgPerfil");
	%>
	</head>
	<body>
	<header>
		<nav class="navbar p-3 border-bottom border-black">
	            <div class="d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
	                <div class="d-flex">
	                    <div class="ms-5">
	                        <a class="navbar-brand" href="/tarea2/empresa"><img class="img-fluid w-50" src="media/img/trabajo_logo.png" alt=""></a>
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
	 	<jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp"/>
	 	<div class="p-2 d-flex justify-content-center mt-5">	
		<form class="col-6">
			  <div class="form-group">
			    <label>Contraseña Actual</label>
			    <input type="password" class="form-control" id="antiguaContraseña" placeholder="Ingrese su contraseña actual">
			  </div>
			  <div class="form-group">
			    <label>Nueva Contraseña</label>
			    <input type="password" class="form-control" id="nuevaContraseña" placeholder="Ingrese su nueva contraseña" >
			  </div>
			  <div class="form-group">
			    <label>Reingrese Nueva Contraseña</label>
			    <input type="password" class="form-control" id="confirmacionContraseña" placeholder="Reingrese su nueva contraseña">
			  </div>
              <div class="mt-4">
			  	<button type="submit" class="btn btn-dark">Confirmar</button>
              </div>
		</form>
	 	</div>
	
	</main>
	
	</body>
</html>