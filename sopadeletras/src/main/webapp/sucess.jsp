<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3></h3>
				<div class="d-flex justify-content-end social_icon">
					<span><i class="fas fa-brain"></i></span>
					<span><i class="fab fa-java"></i></span>
					<span><i class="fas fa-chess-board"></i></span>
				</div>
			</div>
			<div class="card-body">
				<div class="d-flex justify-content-center links">
					<h3>BIENVENIDO <%=request.getParameter("username").toUpperCase()%></h3>
				</div>

			</div>
		</div>
	</div>
</div>
</body>
</html>
