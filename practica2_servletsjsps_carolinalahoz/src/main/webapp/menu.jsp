<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="clases.Persona2,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>


<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid d-flex justify-content-center">

		<div class="card p-1 col-3 mt-5">

			<a href="mosCliente.jsp"><p>Mostrar clientes</p></a> <a
				href="insCliente.jsp"><p>Insertar clientes</p> 
				
		<% 		
		
		String admin = request.getParameter("admin");
		
		if (admin != null) {%>
				
				<div class="box2 bg-warning">
				
				<a
				href="mosUsuario.jsp"><p>Mostrar usario</p></a> <a
				href="insUsuario.jsp"><p>Insertar usuario</p></a>
				</div>
				
				<% } 
		
		ArrayList <Persona2> personas2 = (ArrayList<Persona2>)request.getAttribute("personas");
				
		   session.setAttribute("personas", personas2);
				
				
				
				%>
		</div>
	</div>

</body>
</html>