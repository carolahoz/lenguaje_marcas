<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
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
	
	
	
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>

<div class= "container-fluid">

<div id="box" class="d-flex justify-content-center pb-1"> 
<form class="col-3 card p-1 mt-5" action="http://localhost:8080//practica2_servletsjsps_carolinalahoz/ServletAct2" method="post">
  <div class="mb-3 ">
    <label for="exampleInputUser" class="form-label">USUARIO</label>
    <input type="text" class="form-control" id="exampleInputUser" aria-describedby="userHelp" name="usuario">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">CONTRASE�A</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="passwd">
  </div>
  <button type="submit" class="btn btn-primary">LOGIN</button>
</form>
</div>
<div class="d-flex justify-content-center">
<% String error = request.getParameter("error");
    	 
    if (error != null)	{
    	
    		%>
    		
    <p class="text-danger">ERROR: NO REGISTRADO</p>

<% } %>

</div>
</div>

</body>
</html>