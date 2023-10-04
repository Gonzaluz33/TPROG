<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/WEB-INF/template/head.jsp"/> 
 		<link rel="stylesheet" type="text/css" href="media/styles/dashboardPostulante.css?v=<?php echo time(); ?>">
	</head>
	<body>
    <header>
        <nav class="navbar p-0 border-bottom border-black mb-1">
            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex">
                    <div>
                        <a class="navbar-brand" href="/tarea2/postulante"><img width="160" src="/media/img/trabajo_logo.png" alt=""></a>
                    </div>
                    <h3 class="m-0 d-flex align-items-center">Usuario Postulante</h3>
                </div>
                 <div class="d-flex me-5">
				 <jsp:include page="/WEB-INF/template/CerrarSesionPostulante.jsp" />
 			</div>
            </div>
        </nav>
    </header>
    <main>
        <section id="sectionMenu">
            <div class="p-2">
                <div class="list-group">
                    <a href="./consultaUsuario.html"><button type="button" class="list-group-item list-group-item-action" >Consulta de Usuario</button></a>
                    <a href="./consultaTipoPublicacion.html"><button type="button" class="list-group-item list-group-item-action">Consulta de Tipo de Publicacion</button></a>
                    <a href="./consultaPostulacionOferta.html"><button type="button" class="list-group-item list-group-item-action">Consulta de Postulación a Oferta Laboral</button></a>
                    <a href="./postularAOferta.html"><button type="button" class="list-group-item list-group-item-action">Postular a Oferta Laboral</button></a>
                </div>
            </div>
        </section>
        <div id="mainOfertas">
            <div class="d-flex justify-content-center col-12">
                <form class="d-flex col-12" role="search">
                    <input class="form-control square-corners" type="search" placeholder="Búsqueda de ofertas laborales"
                        aria-label="Search">
                    <button class="btn btn-outline-light bg-dark square-corners" type="submit"><i class="fas fa-search"></i>
                        Buscar</button>
                </form>
            </div>
        </div>
       <section id="sectionKeywords"> 
                    <div class="container-fluid p-3 mx-auto border border-dark text-center" id="keywordList">
                        <h4>Keywords:</h4>
                        <br>
                        <div>
                            <label class="form-check-label" for="flexCheckChecked">
                                Tiempo Completo
                            </label>
                        </div>
                        <div >                        
                            <label class="form-check-label" for="flexCheckChecked">
                                Medio Tiempo
                            </label>
                        </div>
                        <div>
                            <label class="form-check-label" for="flexCheckChecked">
                                Remoto
                            </label>
                        </div>
                        <div>
                            <label class="form-check-label" for="flexCheckChecked">
                                Freelance
                            </label>
                        </div>
                        <div>
                            <label class="form-check-label" for="flexCheckChecked">
                                Temporal
                            </label>
                        </div>
                        <div>
                            <label class="form-check-label" for="flexCheckChecked">
                                Permanente
                            </label>
                        </div>
                        <div>
                            <label class="form-check-label" for="flexCheckChecked">
                                Computación
                            </label>
                        </div>
                        <div>
                            <label class="form-check-label" for="flexCheckChecked">
                                Administración
                            </label>
                        </div>
                        <div>
                            <label class="form-check-label" for="flexCheckChecked">
                                Logística
                            </label>
                        </div>
                        <div>
                            <label class="form-check-label" for="flexCheckChecked">
                                Contabilidad
                            </label>
                        </div>
                </div>
        </section>
    </main>

</body>
    <script src="media/js/dashboardPostulante.js"></script>
</html>