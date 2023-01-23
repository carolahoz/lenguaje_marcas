<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1" import="clases.Persona,java.util.ArrayList"%>
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


<% ArrayList <Persona> personas = (ArrayList<Persona>)request.getAttribute("personas"); 



%>


<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">APELLIDOS</th>
      <th scope="col">SALDO</th>
    </tr>
  </thead>
  <tbody>
    <tr>
    <%
				for (Persona p : personas){
					%>
      <th scope="row"><%= p.getId() %></th>
      <td><%= p.getNombre() %></td>
      <td><%= p.getApellidos() %></td>
      <td><%= p.getSaldo() %></td>
    </tr>
    	<%
				}
			%>
  
  </tbody>
</table>


</body>
</html>