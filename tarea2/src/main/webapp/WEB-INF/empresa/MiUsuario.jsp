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
                    <h3 class="m-0 d-flex align-items-center">Mi Usuario</h3>
                </div>
                 <jsp:include page="/WEB-INF/template/CerrarSesionEmpresa.jsp"/>
            </div>
        </nav>
    </header>
    <main>
        <jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp"/>
        <div class="d-flex flex-column p-5">
            <div class="d-flex  gap-5">
                <div class="d-flex justify-content-center">
                    <img width="250" height="250" src="https://tinyurl.com/mr2hcufa" alt="">
                </div>
                <div class="d-flex gap-5">
                    <div>
                        <h2>Datos Personales:</h2>
                        <p class="m-0"><span class="fw-bold">Nickname: </span>EcoTech</p>
                        <p class="m-0"><span class="fw-bold">Nombre: </span>Sophia</p>
                        <p class="m-0"><span class="fw-bold">Apellido: </span>Johnson</p>
                        <p class="m-0"><span class="fw-bold">Email: </span>info@EcoTech.com</p>
                    </div>
                    <div>
                        <h2>Paquetes Adquiridos:</h2>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Costo:</th>
                                    <th scope="col">Fecha de Compra:</th>
                                    <th scope="col">Fecha de vencimiento:</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="fw-bold">Básico</td>
                                    <td>240</td>
                                    <td>15/8/2023</td>
                                    <td>15/9/2023</td>
                                    <td><a href="#">Ver información</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class=" mt-4">
                <div>
                    <h2>Ofertas Laborales:</h2>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Nombre:</th>
                                <th scope="col">Tipo de Publicacion:</th>
                                <th scope="col">Remuneración:</th>
                                <th scope="col">Horario:</th>
                                <th scope="col">Fecha de Alta:</th>
                                <th scope="col">Estado:</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="fw-bold">Desarrollador Frontend</td>
                                <td>Premium</td>
                                <td>90000</td>
                                <td>09:00 - 18:00</td>
                                <td>14/08/23</td>
                                <td>Ingresada</td>
                            </tr>
                            <tr>
                                <td class="fw-bold">A. de Marketing Digital</td>
                                <td>Premium</td>
                                <td>80000</td>
                                <td>10:00 - 19:00</td>
                                <td>15/08/23</td>
                                <td>Ingresada</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                </div>
            </div>
    </main>
</body>

</html>