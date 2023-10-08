<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.DTOferta"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		 <jsp:include page="/WEB-INF/template/head.jsp"/>
	</head>
	<body>
		    <header>
		        <nav class="navbar p-3">
		            <div class=" d-flex justify-content-between align-items-center w-100" style="height: 8vh;">
		                <div class="d-flex" style="width: 80vw;">
		                    <jsp:include page="/WEB-INF/template/Logo.jsp" />
		                    <h3 class="m-0 d-flex align-items-center">Postular A Oferta Laboral</h3>
		                </div>
		            </div>
		        </nav>
		    </header>
		   <main>
			    <jsp:include page="/WEB-INF/template/NavBarPostulante.jsp" />
			    <div class="container my-5">
			         <% DTOferta oferta = (DTOferta) request.getAttribute("ofertaSeleccionada");%>
					        <div class="d-flex p-1  border border-dark align-items-center mb-3">
					            <div style="width: 25%;">
					                <img class="w-75" src="<%= oferta.getImagen()%>" alt="">
					            </div>
					            <div class="w-75">
					                <div class="d-flex flex-column">
					                    <h3><%= oferta.getNombre() %></h3>
					                    <div>
					                        <p>
					                            <%= oferta.getDescripcion() %>
					                        </p>
					                    </div>
					                    <div class="d-flex flex-column mb-2">
					                        <b>Departamento: <%= oferta.getDepartamento() %></b>
					                        <b>Ciudad: <%= oferta.getCiudad() %></b>
					                        <b>Horario: <%= oferta.getHorario() %></b>
					                        <b>Remuneración: <%= oferta.getRemuneracion() %></b>
					                    </div>
					                    <div class="d-flex gap-1 justify-content-start">
					                   	<%   
									        List<String> keywordsDeOferta = oferta.getKeywords();
									       
									        for(String keyword : keywordsDeOferta) {
									    %>
									     	 <span class="keyword">#<%= keyword %> </span>
									    <% 
									        }
									    %>
					                    </div>			                   
					               </div>			                	
					            </div>				             
					        </div>
					        <div>
				            		
						                <form class="d-flex justify-content-between">
						                    <div>
						                        <textarea class="form-control" style="height: 280px; width: 25vw;" placeholder="Ingrese CV reducido"></textarea>
						                    </div>
						                    <div>
						                        <textarea class="form-control" style="height: 280px; width: 25vw;" placeholder="Ingrese Motivación:"></textarea>
						                    </div>
						                </form>

            							<div class="d-flex justify-content-between mt-3">
            								<div>
											    <button onClick="retroceder()" type="button" class="btn btn-dark">Volver atrás</button>
            								</div>
								            <div>
								                <button type="submit" class="btn btn-dark">Confirmar</button>
								            </div>  
            							</div>
					            </div>		        
					
				</div>
			</main>
	</body>
	<script>
    function retroceder() {
        window.history.back();
    }
	</script>
</html>