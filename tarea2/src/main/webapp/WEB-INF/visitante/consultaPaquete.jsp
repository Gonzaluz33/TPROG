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
                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
                    <h3 class="m-0 d-flex align-items-center">Consultar Paquete</h3>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="/WEB-INF/template/NavBarVisitante.jsp" />
        <div class="d-flex flex-column justify-content-center p-4">

                <div class="form-floating">
                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                        <option selected>Básico</option>
                    </select>
                    <label for="floatingSelect">Seleccione un Paquete:</label>
                </div>
                <div class="d-flex mt-4 gap-3 flex-column">
                    <div class="d-flex gap-5">
                        <div class="d-flex justify-content-center">
                            <img width="250" height="250" src="https://shorturl.at/ceCD2" alt="">
                        </div>
                        <div>
                            <h2>Datos del paquete seleccionado:</h2>
                            <p class="m-0"><span class="fw-bold">Nombre: </span>Básico</p>
                            <p class="m-0"><span class="fw-bold">Descripción: </span>Publica ofertas laborales
                            en nuestra plataforma por
                            un período de 30 días.</p>
                            <p class="m-0"><span class="fw-bold">Descuento: </span>20%</p>
                            <p class="m-0"><span class="fw-bold">Costo: </span>240</p>
                            <p class="m-0"><span class="fw-bold">Fecha de Alta: </span>16/08/23</p>
                        </div>
                        <div>
                            <h2>Contenido:</h2>
                            <div>
                                <ul>
                                    <li><p class="m-0"><span class="fw-bold">Tipo de Publicacion: </span><a href="#">Premium</a></p>
                                        <p class="m-0"><span class="fw-bold">Cantidad: </span>1</p>
                                    </li>
                                </ul>
                            </div>
                            <div>
                                <ul>
                                    <li>
                                        <p class="m-0"><span class="fw-bold">Tipo de Publicacion: </span><a href="#">Destacada</a></p>
                                        <p class="m-0"><span class="fw-bold">Cantidad: </span>1</p>
                                    </li>
                                </ul>
                            </div>
                            <div>
                                <ul>
                                    <li>
                                        <p class="m-0"><span class="fw-bold">Tipo de Publicacion: </span><a href="#">Estándar</a></p>
                                        <p class="m-0"><span class="fw-bold">Cantidad: </span>1</p>
                                    </li>
                                </ul>
                            </div>          
                        </div>
                
                    </div>

                </div>
        </div>
    </main>
</body>
</html>