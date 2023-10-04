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
                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
                    <div style="width: 80%;">
                        <form class="d-flex " role="search">
                            <input class="form-control square-corners  me-2 " type="search"
                                placeholder="Búsqueda de ofertas laborales" aria-label="Search">
                            <button class="btn btn-outline-light bg-dark square-corners" type="submit"><i
                                    class="fas fa-search"></i>Buscar</button>
                        </form>
                    </div>
                </div>     
            </nav>
        </header>
        <main>
            <jsp:include page="/WEB-INF/template/NavBarVisitante.jsp" />
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

          </main>
    </body>
</html>