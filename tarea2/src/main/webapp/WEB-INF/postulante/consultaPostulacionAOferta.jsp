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
                        <a class="navbar-brand" href="dashboardPostulante.html"><img width="160" src="../src/img/trabajo_logo.png"
                                alt=""></a>
                    </div>
                    <h3 class="m-0 d-flex align-items-center">Consulta Postulacion a Oferta Laboral</h3>
                </div>
                <jsp:include page="/WEB-INF/template/CerrarSesionPostulante.jsp" />
                
            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp"/>
        <div class="d-flex flex-column justify-content-center p-4">
            <div class="d-flex mt-4 gap-3 flex-column">
                <div class="d-flex gap-5">
                    <div>
                        <h2>Mis Postulaciones:</h2>
                        <p class="m-0"><span class="fw-bold">Nombre de la oferta: </span></p>
                        <ul>
                            <li><a href="consultaOfertaLaboral.html">Desarrollador Frontend</a></li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </main>
</body>

</html>