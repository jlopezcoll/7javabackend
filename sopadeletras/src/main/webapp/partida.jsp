<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<% if (session.getAttribute("user")== null)
    {
%>
    <jsp:forward page="index.jsp"></jsp:forward>

<% }
if (request.getParameter("salir")!= null)
    {
    session.invalidate();
    %>
    <jsp:forward page="index.jsp"></jsp:forward>
   <% } %>

<head>
	<meta charset="UTF-8">
	<title>7J - Sopa de letras</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">   
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/wordfind.css">			
    <script src="js/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="js/jquery.min.js"></script>    
        <!-- Librerias para generar el juego -->
    <script type="text/javascript" src="js/wordfind.js"></script>
    <script type="text/javascript" src="js/wordfindgame.js"></script>
</head>
<body>

	<jsp:useBean id="juego" class="com.sopadeletras.controller.Juego" scope="session"/>
	<% juego.setJugador((String)session.getAttribute("user")); %>
	<% juego.setPuntuacion(6666); %>


<%-- <p>El nombre es <jsp:getProperty name="juego" property="sopa.idJugador"/></p> --%>

<p><%= juego.getPuntuacion() %></p>


	<form>	
		<div class="form-group text-center">
			<input type="submit" value="Salir" name="salir" class="btn login_btn">
		</div>
	</form>
	<p><%= session.getAttribute("user") %></p>
	<div><button id="solve">RESOLVER</button></div>
	<div id="timer"></div>
<div id='puzzle'></div>
<div id='words'></div>

<!-- <script language="javascript" type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="../src/wordfind.js"></script> -->
<!-- <script type="text/javascript" src="scripts/wordfindgame.js"></script> -->


	
<script>

hasAcertado = function(){
	<% juego.guardarPartida(); %>
	alert("HAS GANADO!!!");
	window.location.reload();
};



$(document).ready(function(){
	function isWinner(){
		if ($('.puzzleSquare').hasClass('complete')){
			hasAcertado();
		}
	}setInterval(isWinner, 3000);


});




var n = 0;
var l = document.getElementById("timer");
window.setInterval(function(){
  l.innerHTML = n;
  n++;
},1000);

 
  var words = [];
  
  	<c:forEach items="${listaPalabras}" var="diccionario"> 
  	words.push("${diccionario.palabra}");
  	</c:forEach>
  	


  
   var puzzle = wordfind.newPuzzle(words, {
      height: 10,
      width: 10,
      fillBlanks: false
  });
   
   // start a word find game
   var gamePuzzle = wordfindgame.create(words, '#puzzle', '#words');
  
  $('#solve').click(function() {
      wordfindgame.solve(gamePuzzle, words);
  });

</script>

	
</body>
</html>