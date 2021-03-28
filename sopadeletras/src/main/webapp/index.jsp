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
	<c:if test ="${not empty param.username}">
		<div class="alert alert-danger" role="alert">
			<P>El usuario <strong><c:out value="${param.username}"></c:out></strong> o la contrase�a no es v�lido</P>
		</div>
	</c:if>

	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Acceso 7J</h3>
				<div class="d-flex justify-content-end social_icon">
					<span><i class="fas fa-brain"></i></span>
					<span><i class="fab fa-java"></i></span>
					<span><i class="fas fa-chess-board"></i></span>
				</div>
			</div>
			<div class="card-body">
				<form action="login" method="post">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="username" name="username">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="password" name="password">
					</div>
					<div class="form-group text-center">
						<input type="submit" value="Entrar" class="btn login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					<h3>Sopa de letras</h3>
				</div>
				<div class="d-flex justify-content-center links">
					7J Team
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>