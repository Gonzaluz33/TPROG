<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <title>Trabajo.uy</title>
</head>

<body>
    <header>
        <nav class="navbar p-0 border-bottom border-black mb-1">
            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
                <div class="d-flex" style="width: 80vw;">
                    <div>
                        <a class="navbar-brand" href="dashboardPostulante.html"><img width="160" src="../src/img/trabajo_logo.png"
                                alt=""></a>
                    </div>
                    <h3 class="m-0 d-flex align-items-center">Postular a Oferta Laboral</h3>
                </div>
                <jsp:include page="/WEB-INF/template/CerrarSesionPostulante.jsp" />
            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp"/>
        <div class="d-flex flex-column justify-content-center p-4">
            <div class="d-flex col-12">
                <div class="w-50 form-floating">
                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                        <option selected value="0">Premium</option>
                        <option value="1">Destacada</option>
                        <option value="2">Estándar</option>
                        <option value="3">Básica</option>
            
                    </select>
                    <label for="floatingSelect">Seleccione una empresa:</label>
                </div>
                <div class="w-50 form-floating">
                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                        <option selected value="0">Tiempo Completo</option>
                        <option value="1">Medio Tiempo</option>
                        <option value="2">Temporal</option>
                        <option value="3">Permanente</option>
                        <option value="1">Computación</option>
                        <option value="2">Logística</option>
                        <option value="3">Contabilidad</option>
                        <option value="1">Remoto</option>
                        <option value="2">Freelance</option>
                        <option value="3">Permanente</option>
                    </select>
                    <label for="floatingSelect">Seleccione una Keyword:</label>
                </div>
            </div>
            <div id="mainOfertasAPostular">

            </div>
        </div>
    </main>
</body>
<script src="../js/dashboardPostulante.js"></script>
</html>