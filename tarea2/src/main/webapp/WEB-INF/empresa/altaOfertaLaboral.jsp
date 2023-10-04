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
                        <h3 class="m-0 d-flex align-items-center">Alta de Oferta Laboral</h3>
                    </div>
                    <jsp:include page="/WEB-INF/template/CerrarSesionEmpresa.jsp"/>
                </div>
            </nav>
        </header>
        <main>
           <jsp:include page="/WEB-INF/template/NavBarEmpresa.jsp"/>
            <div class="d-flex flex-column justify-content-start p-3">
                <div class="col-12">
                    <form class="d-flex justify-content-between gap-3">
                        <div class="col-6">
                            <div class="mb-3">
                                <label class="form-label">Seleccione un Tipo de Publicación:</label>
                                <select class="form-select" id="floatingSelect">
                                    <option selected value="0">Premium</option>
                                    <option value="1">Destacada</option>
                                    <option value="2">Estándar</option>
                                    <option value="3">Básica</option>
                                </select>
                            </div>
                            <div class="mb-3 d-flex gap-5 justify-content-between">
                                <div class="col-5">
                                    <label class="form-label">Nombre:</label>
                                    <input type="text" class="form-control" placeholder="Ingrese Nombre">
                                </div>
                                <div class="col-5">
                                    <label for="exampleInputPassword1" class="form-label">Remuneración:</label>
                                    <input type="number" class="form-control" placeholder="Ingrese Remuneración" >
                                </div>
                            </div>
                            <div class="mb-3 d-flex gap-5 justify-content-between">
                                <div class="col-5">
                                    <label for="exampleInputPassword1" class="form-label">Horario:</label>
                                    <input type="text" class="form-control" placeholder="Ingrese un horario">
                                </div>
                                <div class="col-5">
                                    <label for="exampleInputPassword1" class="form-label">Departamento:</label>
                                    <select class="form-select" id="floatingSelect" aria-label="Floating label select example">
                                        <option value="artigas">Artigas</option>
                                        <option value="canelones">Canelones</option>
                                        <option value="cerro_largo">Cerro Largo</option>
                                        <option value="colonia">Colonia</option>
                                        <option value="durazno">Durazno</option>
                                        <option value="flores">Flores</option>
                                        <option value="florida">Florida</option>
                                        <option value="lavalleja">Lavalleja</option>
                                        <option value="maldonado">Maldonado</option>
                                        <option value="montevideo">Montevideo</option>
                                        <option value="paysandu">Paysandú</option>
                                        <option value="rio_negro">Río Negro</option>
                                        <option value="rivera">Rivera</option>
                                        <option value="rocha">Rocha</option>
                                        <option value="salto">Salto</option>
                                        <option value="san_jose">San José</option>
                                        <option value="soriano">Soriano</option>
                                        <option value="tacuarembo">Tacuarembó</option>
                                        <option value="treinta_y_tres">Treinta y Tres</option>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-3 d-flex gap-5 justify-content-between">
                                <div class="col-12">
                                    <label class="form-label">Ciudad:</label>
                                    <input type="text" class="form-control" placeholder="Ingrese Ciudad">
                                    <div class="mt-3">
                                        <label class="form-label">URL imagen:</label>
                                        <input type="text" class="form-control" placeholder="Ingrese URL de imagen (opcional)">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-6">
                            <div class="mb-3">
                                <label for="floatingTextarea2">Descripción:</label>
                                <textarea class="form-control" placeholder="Ingrese una descripción"
                                    style="height: 120px;"></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="floatingTextarea2">Seleccione Keywords:</label>
                                <select class="custom-select form-control" multiple>
                                    <option value="opcion1">Tiempo completo</option>
                                    <option value="opcion2">Medio tiempo</option>
                                    <option value="opcion3">Remoto</option>
                                    <option value="opcion1">Freelance</option>
                                    <option value="opcion2">Temporal</option>
                                    <option value="opcion3">Permanente</option>
                                    <option value="opcion4">Computación</option>
                                    <option value="opcion4">Administración</option>
                                    <option value="opcion4">Logística</option>
                                    <option value="opcion4">Contabilidad</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label>Forma de Pago de Oferta:</label>
                               <div class="mt-2">
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" value="General">
                                        <label class="form-check-label" for="inlineRadio1">General</label>
                                    </div>
                                    <div class="form-check mb-3 form-check-inline">
                                        <input class="form-check-input" type="radio" name="inlineRadioOptions" value="Paquete">
                                        <label class="form-check-label" for="inlineRadio2">Paquete adquirido previamente</label>
                                    </div>
                                    <div>
                                        <label class="form-check-label" for="inlineRadio2">Seleccione Paquete:</label>
                                        <select class="form-select" id="floatingSelect">
                                            <option value="3">Básico</option>
                                        </select>
                                    </div>
                               </div>
                               
                            </div>
                        </div>
                    </form>
                    <div class="d-flex justify-content-end mt-2">
                        <button type="submit" class="btn btn-dark">Confirmar</button>
                    </div>

                </div>
            </div>
        </main>
    </body>
    <script>
        $('#multiple-select-field').select2({
                theme: "bootstrap-5",
                width: $(this).data('width') ? $(this).data('width') : $(this).hasClass('w-100') ? '100%' : 'style',
                placeholder: $(this).data('placeholder'),
                closeOnSelect: false,
            });
    </script>

</html>