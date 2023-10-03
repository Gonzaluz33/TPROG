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
        <jsp:include page="/WEB-INF/template/NavBarVisitante.jsp" />
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