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
                    <h3 class="m-0 d-flex align-items-center">Consulta de Oferta Laboral</h3>
                </div>
                 <jsp:include page="/WEB-INF/template/CerrarSesionEmpresa.jsp"/>
            </div>
        </nav>
    </header>
    <main>
 		<jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp"/>
    <div class="p-1 mt-2 d-flex flex-column">
        <div class="d-flex justify-content-center">
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
    
                    <p class="m-0"><span class="fw-bold">Tipo de Publicacion:</span> Premium <a
                            href="./consultaTipoPublicacion.html">Ver más</a></p>
    
                </div>
                <div class="row d-flex  mt-3">
                    <p class="m-0"><span class="fw-bold">Fecha de alta: </span> 14/08/23</p>
                    <p class="m-0"><span class="fw-bold">Forma de Pago: </span>Paquete</p>
                    <p class="m-0"><span class="fw-bold">Tipo de Paquete: </span><a href="#">Básico</a></p>
                </div>
    
                <div class="row d-flex  mt-3">
                    <p class="m-0"><span class="fw-bold"> Keywords:</span> Tiempo completo, Mediotiempo, Remoto,
                        Freelance,
                        Temporal, Permanente</p>
                </div>
                <div class="mt-4">
                    <div class="dropdown">
                        <button class="btn btn-dark dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Opciones
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="./consultaPostulacionOferta.html">Ver listado de Postulantes</a></li>
                        </ul>
                    </div>
                </div>
            </div>
           
        </div>   
    </div>
    </main>
</body>
</html>