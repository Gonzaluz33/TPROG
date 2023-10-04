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
                    <h3 class="m-0 d-flex align-items-center">Consulta de Tipo de Publicación</h3>
                </div>
                 <jsp:include page="/WEB-INF/template/CerrarSesionEmpresa.jsp"/>
            </div>
        </nav>
    </header>
    <main>
         <jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp"/>
        <div class="d-flex flex-column justify-content-center p-4">
            <div>
                <div class="form-floating">
                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                        <option selected value="0">Premium</option>
                        <option value="1">Destacada</option>
                        <option value="2">Estándar</option>
                        <option value="3">Básica</option>

                    </select>
                    <label for="floatingSelect">Seleccione un Tipo de Publicación:</label>
                </div>
            </div>
            <div class="d-flex mt-4 gap-3 flex-column">
                <div class="d-flex gap-5">
                    <div class="d-flex justify-content-center">
                        <img width="250" height="250" src="" alt="imagen premium">
                    </div>
                    <div>
                        <h2>Premium:</h2>
                        <p class="m-0"><span class="fw-bold">Descripción: </span>Obtén tu maxima visibilidad.</p>
                        <p class="m-0"><span class="fw-bold">Exposición: </span>1</p>
                        <p class="m-0"><span class="fw-bold">Duración: </span>30 días</p>
                        <p class="m-0"><span class="fw-bold">Costo: </span>4000</p>
                        <p class="m-0"><span class="fw-bold">Alta: </span>10/08/2023</p>
                    </div>
                </div>
            </div>

        </div>
    </main>
</body>

</html>