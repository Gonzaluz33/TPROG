<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		                    <div>
		                        <a class="navbar-brand" href="index.html"><img width="160" src="media/img/trabajo_logo.png"
		                                alt=""></a>
		                    </div>
		                    <h3 class="m-0 d-flex align-items-center">Consulta de Usuario</h3>
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
		                            <a class="nav-link active text-white" aria-current="page" href="ConsultaDeUsuario.html">Consulta de
		                                Usuario</a>
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
		                            <a class="nav-link text-white" href="../Empresa/dashboardEmpresa.html">Dashboard Empresa</a>
		                        </li>
		                    </ul>
		                </div>
		            </div>
		        </nav>
		        <div class="d-flex flex-column justify-content-center p-4">
		            <div>
		                <div class="form-floating">
		                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
		                        <option selected>lgarcia</option>
		                        <option value="1">EcoTech</option>
		
		                    </select>
		                    <label for="floatingSelect">Seleccione un usuario:</label>
		                </div>
		            </div>
		            <div class="d-flex mt-4 gap-3 flex-column">
		                <div class="d-flex gap-5">
		                    <div class="d-flex justify-content-center">
		                        <img width="250" height="250" src="https://tinyurl.com/yckek63e" alt="">
		                    </div>
		                    <div>
		                        <h2>Datos Personales:</h2>
		                        <p class="m-0"><span class="fw-bold">Nickname: </span>lgarcia</p>
		                        <p class="m-0"><span class="fw-bold">Nombre: </span>Lucía</p>
		                        <p class="m-0"><span class="fw-bold">Apellido: </span>García</p>
		                        <p class="m-0"><span class="fw-bold">Email: </span>lgarcia85@gmail.com</p>
		                    </div>
		  
		                </div>
		
		                <div class="d-flex gap-5">
		                    <div class="d-flex justify-content-center">
		                        <img width="250" height="250" src="https://tinyurl.com/mr2hcufa" alt="">
		                    </div>
		                    <div>
		                        <h2>Datos Personales:</h2>
		                        <p class="m-0"><span class="fw-bold">Nickname: </span>EcoTech</p>
		                        <p class="m-0"><span class="fw-bold">Nombre: </span>Sophia</p>
		                        <p class="m-0"><span class="fw-bold">Apellido: </span>Johnson</p>
		                        <p class="m-0"><span class="fw-bold">Email: </span>info@EcoTech.com</p>
		                    </div>
		
		                    <div>
		                        <h2>Ofertas Laborales Activas:</h2>
		                        <p class="m-0"><span class="fw-bold">Nombre de Oferta Laboral: </span><a
		                                href="./consultaOfertaLaboral.html">Desarrollador Frontend</a></p>
		                    </div>
		                </div>
		            </div>
		
		        </div>
		    </main>
	</body>

</html>