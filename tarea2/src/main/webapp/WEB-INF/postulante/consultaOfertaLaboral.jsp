<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
     <jsp:include page="/WEB-INF/template/head.jsp"/>
</head>

<body>
    <header>
        <nav class="navbar p-0 border-bottom border-black mb-1">
            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex" style="width: 80vw;">
                      <jsp:include page="/WEB-INF/template/Logo.jsp"/>
                    <h3 class="m-0 d-flex align-items-center">Usuario Postulante</h3>
                </div>
                 <jsp:include page="/WEB-INF/template/CerrarSesionPostulante.jsp"/>
            </div>
        </nav>
    </header>
    <main>
         <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp"/>
        <div class="p-3 mt-5 d-flex flex-column">
            <div class="d-flex  justify-content-center">
                        <div class="row d-flex text-center align-items-center justify-content-center">
                            <div>
                                <img class="w-75" src="https://tinyurl.com/45nsf34m" alt="">
                            </div>
                        
                        </div>
                        <div>
                            <div class="row d-flex  mt-3">
                                <div class="text-start align-items-center justify-content-center">
                                    <h3 class="fw-bold">Desarrollador Frontend</h3>
                                </div>
                                <p><span class="fw-bold">Descripción:</span> Unete a nuestro equipo de desarrollo frontend y crea
                                    experiencias de usuario excepcionales.</p>
                            </div>
                            <div class="row d-flex ">
                                <p class="m-0"><span class="fw-bold">Remuneración:</span> 90000 pesos uruguayos </p>
                                <p class="m-0"><span class="fw-bold">Horario:</span> 09:00-18:00 </p>
                                <p class="m-0"><span class="fw-bold">Departamento:</span> Montevideo </p>
                                <p class="m-0"><span class="fw-bold">Ciudad:</span> Montevideo </p>

                                <p class="m-0"><span class="fw-bold">Tipo de Publicacion:</span> Premium <a href="./consultaTipoPublicacion.html">Ver más</a></p>
                               
                            </div>
                            <div class="row d-flex  mt-3">
                                <p class="m-0"><span class="fw-bold">Fecha de alta:</span> 14/08/23</p>
                            </div>
                        
                            <div class="row d-flex  mt-3">
                                <p class="m-0"><span class="fw-bold"> Keywords:</span> Tiempo completo, Mediotiempo, Remoto,
                                    Freelance,
                                    Temporal, Permanente</p>
                        
                            </div>
                        </div>
            </div>
            <div class="d-flex mt-5 justify-content-center">
                <div class="col-8">
                    <h3 class="fw-bold">Mi Postulación:</h3>
                        <div class="d-flex">
                            <div>
                                <h4>CV:</h4>
                                <p>
                                    Licenciada en Administración, experiencia
                                    en gestión de equipos y
                                    proyectos. Conocimientos
                                    en Microsoft Office.
                                </p>
                                <h4>Motivación:</h4>
                                <p>
                                    Estoy emocionada por
                                    la oportunidad de formar parte de un equipo
                                    dinámico y contribuir
                                    con mis habilidades de
                                    liderazgo.
                                </p>
                                <h4>Fecha:</h4>
                                <p>
                                    16/08/23
                                </p>

                            </div>

                        </div>

                </div>
            </div>
        </div>
    </main>
</body>

</html>

    