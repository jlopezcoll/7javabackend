<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>7J - Sopa de letras</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">   
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">		
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<table class="table table-striped">
  				<thead>
	  				<tr>
	  					<th scope="col">IdPalabra</th>
	      				<th scope="col">Palabra</th>
	  				</tr>
  				</thead>
	  				<tbody>
	  				<c:forEach items="${listaPalabras}" var="diccionario">
					    <tr>
					      <th scope="row">
					      	<c:out value="${diccionario.idPalabra}"></c:out>
					      </th>
					      <td>
					      	<c:out value="${diccionario.palabra}"></c:out>
					      </td>
					    </tr>
					</c:forEach>					    
				    </tbody>
  			</table>
		</div>
	</div>
</body>
</html>