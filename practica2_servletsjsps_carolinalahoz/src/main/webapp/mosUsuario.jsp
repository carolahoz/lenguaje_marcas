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


<% ArrayList <Persona2> personas = (ArrayList<Persona2>)request.getAttribute("personas"); 



%>


<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">USUARIO</th>
      <th scope="col">PASSWORD</th>
      <th scope="col">TIPO</th>
    </tr>
  </thead>
  <tbody>
    <tr>
    <%
				for (Persona2 p2 : personas){
					%>
      <th scope="row"><%= p2.getId() %></th>
      <td><%= p2.getUsuario() %></td>
      <td><%= p2.getPassword() %></td>
      <td><%= p2.getTipo() %></td>
    </tr>
    	<%
				}
			%>
  
  </tbody>
</table>


</body>
</html>