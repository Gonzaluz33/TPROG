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
                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
                    <h3 class="m-0 d-flex align-items-center">Consulta de Postulación a Oferta Laboral</h3>
                </div>
                <jsp:include page="/WEB-INF/template/CerrarSesionEmpresa.jsp" />
            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp" />
        <div class="d-flex flex-column justify-content-center p-2">
            <div class="d-flex mt-4 gap-3 p-2 flex-column">
                <h3>Postulación Seleccionada:</h3>
                <table class="table table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Nickname:</th>
                            <th scope="col">Nombre:</th>
                            <th scope="col">Apellido:</th>
                            <th scope="col">Email:</th>
                            <th scope="col">Fecha de Postulación:</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">lgarcia</th>
                            <td>Lucía</td>
                            <td>García</td>
                            <td>@lgarcia85@gmail.com</td>
                            <td>16/08/23</td>
                            
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="d-flex justify-content-around p-5">
                <div>
                    <h3>CV:</h3>
                    <div class="col-6">
                        <p class="text-start">
                            Licenciada en Administración, experiencia
                            en gestión de equipos y
                            proyectos. Conocimientos
                            en Microsoft Office.

                        </p>
                    </div>
                </div>
                <div>
                    <h3>Motivación:</h3>
                    <div class="col-6 ">
                        <p class="text-start">
                            Estoy emocionada por
                            la oportunidad de formar parte de un equipo
                            dinámico y contribuir
                            con mis habilidades de
                            liderazgo.
                        </p>
                    </div>
                </div>
            </div>

        </div>
    </main>
</body>

</html>