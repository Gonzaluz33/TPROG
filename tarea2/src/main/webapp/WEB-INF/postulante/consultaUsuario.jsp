<%@page import="java.util.List"%>
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
                        <a class="navbar-brand" href="/tarea2/postulante"><img width="160" src="media/img/trabajo_logo.png"
                                alt=""></a>
                    </div>
                    <h3 class="m-0 d-flex align-items-center">Consulta de Usuario</h3>
                </div>
                <jsp:include page="/WEB-INF/template/CerrarSesionPostulante.jsp" />
               
            </div>
        </nav>
    </header>
    <main>
	    <script>
		     function mostrarUsuarioSeleccionado(nickname) {
		        var infoUsuarioDiv = document.getElementById("infoUsuario");
		        // Recorre la lista de usuarios para encontrar el usuario seleccionado por el nickname
				var usuarios = <%= request.getAttribute("jsonUsers") %>;
		        var usuarioSeleccionado = usuarios.find(function(usuario) {
		            return usuario.nickname === nickname;
		        });
		        console.log(usuarioSeleccionado);
		        // Muestra la información del usuario seleccionado en el div "infoUsuario"
		        if (usuarioSeleccionado) {
		            infoUsuarioDiv.innerHTML = `
		                <h2>Datos Personales:</h2>
		                <p class="m-0"><span class="fw-bold">Nickname: </span>jorge</p>
		                <p class="m-0"><span class="fw-bold">Nombre: </span>${usuarioSeleccionado.nombre}</p>
		                <p class="m-0"><span class="fw-bold">Apellido: </span>${usuarioSeleccionado.apellido}</p>
		                <p class="m-0"><span class="fw-bold">Email: </span>${usuarioSeleccionado.correo}</p>
		                <p>${usuarioSeleccionado}</p>
		            `;
		            console.log(usuarioSeleccionado.correo);
		        } else {
		            infoUsuarioDiv.innerHTML = ""; // Limpia el contenido si no se seleccionó ningún usuario
		        }
		     }	
	    </script>
        <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp"/>
        <div class="d-flex flex-column justify-content-center p-4">
            <div>
                <div class="form-floating">
                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example" onchange=mostrarUsuarioSeleccionado(this.value)>
                        <%
                        List<DTUsuario> usuarios = (List<DTUsuario>) request.getAttribute("usuarios");
                        for(DTUsuario usuario: usuarios) {
                        %>
                        <option value="<%= usuario.getNickname()%>"><%= usuario.getNickname()%></option>
                        <% } %>
                    </select>
                    <label for="floatingSelect">Seleccione un usuario:</label>
                </div>
            </div>
            <div class="d-flex mt-4 gap-3 flex-column">
                <div class="d-flex gap-5">
                    <div class="d-flex justify-content-center">
                        <img width="250" height="250"src="https://tinyurl.com/yckek63e" alt="">
                    </div>
                    <div id="infoUsuario">
                    </div>
                </div>
            </div>
        </div>
    </main>
    

</body>
</html>