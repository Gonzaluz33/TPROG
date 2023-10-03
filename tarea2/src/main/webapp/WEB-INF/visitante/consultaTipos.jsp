<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
     <jsp:include page="/WEB-INF/template/head.jsp"/>
</head>
<body>
    <header>
        <nav class="navbar p-0 border-bottom border-black mb-1">
            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex" style="width: 80vw;">
                    <div>
                        <a class="navbar-brand" href="index.html"><img width="160" src="../src/img/trabajo_logo.png"
                                alt=""></a>
                    </div>
                    <h3 class="m-0 d-flex align-items-center">Consultar Tipo de Publicación</h3>
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
                            <a class="nav-link active text-white" aria-current="page"
                                href="ConsultaDeUsuario.html">Consulta de
                                Usuario</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-white" href="#" role="button"
                                data-bs-toggle="dropdown" aria-expanded="false">
                                Paquetes y Tipos de Publicación
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="ConsultaPaquete.html">Consultar Paquetes</a></li>
                                <li><a class="dropdown-item" href="ConsultaTipos.html">Consultar Tipos de
                                        Publicación</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="../postulante/dashboardPostulante.html">Dashboard
                                Postulante</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="../Empresa/dashboardEmpresa.html">Dashboard Empresa</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="d-flex flex-column justify-content-center p-4">
            <div class="form-floating">
                <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                    <option value="0"selected>Básica</option>
                    <option value="1">Estándar</option>
                    <option value="2">Destacada</option>
                    <option value="3">Premium</option>
                </select>
                <label for="floatingSelect">Seleccione un Tipo de Publicación:</label>
            </div>
            <div class="d-flex mt-4 gap-3 flex-column">
                <div class="d-flex gap-5">
                    <div>
                        <h2>Datos del tipo seleccionado:</h2>
                        <p class="m-0"><span class="fw-bold">Nombre: </span>Básica</p>
                        <p class="m-0"><span class="fw-bold">Descripción: </span>Publica de forma sencilla en la lista de ofertas.</p>
                        <p class="m-0"><span class="fw-bold">Exposicion: </span>4</p>
                        <p class="m-0"><span class="fw-bold">Duración: </span>7</p>
                        <p class="m-0"><span class="fw-bold">Costo: </span>50</p>
                        <p class="m-0"><span class="fw-bold">Fecha de Alta: </span>07/08/23</p>
                    </div>       
                </div> 
            </div>
        </div>

    </main>
</body>
</html>