<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
          <jsp:include page="/WEB-INF/template/head.jsp"/>
    </head>
    <body>
        <header>
            <nav class="navbar bg-body-tertiary border-bottom border-black">
                <div class="container d-flex py-1 ">
                    <div style="width: 20%;">
                        <a class="navbar-brand" href="#"><img class="w-50" src="../src/img/trabajo_logo.png" alt=""></a>
                    </div>
                    <div style="width: 80%;">
                        <form class="d-flex " role="search">
                            <input class="form-control square-corners  me-2 " type="search"
                                placeholder="Búsqueda de ofertas laborales" aria-label="Search">
                            <button class="btn btn-outline-light bg-dark square-corners" type="submit"><i
                                    class="fas fa-search"></i> Buscar</button>
                        </form>
                    </div>
                </div>     
            </nav>
        </header>
        <main>
            <nav class="navbar navbar-expand-lg bg-body-tertiary bg-navbar">
                <div class="container-fluid justify-content-center">
                    <div class="collapse navbar-collapse justify-content-center">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link active text-white" aria-current="page" href="../index.html">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active text-white" aria-current="page" href="../visitante/ConsultaDeUsuario.html">Consulta de Usuario</a>
                            </li>
                           <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                    Paquetes y Tipos de Publicación
                                </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="ConsultaPaquete.html">Consultar Paquetes</a></li>
                                <li><a class="dropdown-item" href="ConsultaTipos.html">Consultar Tipos de Publicación</a></li>
                            </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="../postulante/dashboardPostulante.html">Dashboard Postulante</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-white" href="../empresa/dashboardEmpresa.html">Dashboard Empresa</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div class="p-3 mt-5 d-flex">
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
                </div>
                <div class="row d-flex  mt-3">
                    <p class="m-0"><span class="fw-bold">Fecha de alta:</span> 14/08/23</p>
                </div>
            
                <div class="row d-flex  mt-3">
                    <p class="m-0"><span class="fw-bold"> Keywords:</span> Tiempo completo, Mediotiempo, Remoto, Freelance,
                        Temporal, Permanente</p>
            
                </div>
                </div>
            </div>

        
    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
        crossorigin="anonymous"></script>
</html>