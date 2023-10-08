<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="utils.DTOferta"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		 <jsp:include page="/WEB-INF/template/head.jsp"/>
	</head>
	<script>
		setTimeout(function() {
		    var errorDiv = document.getElementById("errorDiv");
		    if (errorDiv) {
		        errorDiv.style.display = "none";
		    }
		}, 5000);
	</script>
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
			    <% if (request.getAttribute("error") != null) { %>
				    <div id="errorDiv" class="alert alert-danger">
				        ${requestScope.error}
				    </div>
				<% } %>
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
				                <form class="d-flex flex-column" action="confirmarPostulacion?NombreOferta=<%= oferta.getNombre() %>" method="post">
				                    <div class="d-flex justify-content-between">
					                    <div>
					                        <textarea class="form-control" style="height: 280px; width: 20vw;" id="cv" name="cv" placeholder="Ingrese CV reducido"></textarea>
					                    </div>
					                    <div>
					                        <textarea class="form-control" style="height: 280px; width: 20vw;" id="motivacion" name="motivacion" placeholder="Ingrese Motivación:"></textarea>
					                    </div>
				                    </div>
	       							<div class="d-flex justify-content-between mt-3">
	       								<div>
							    			<button onClick="retroceder()" type="button" class="btn btn-dark">Volver atrás</button>
	       								</div>
							            <div>
							                <button type="submit" class="btn btn-dark">Confirmar</button>
							            </div>  
	        						</div>
				                </form>
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