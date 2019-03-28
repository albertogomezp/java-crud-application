<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script>
function callJqueryAjax(){
	//var action = $('#name').val();
	var action ="mostrar";
	$.ajax({
		url     : '/Competidor/adminCompetidor',
		method     : 'POST',
		data     : {action: action},
		success    : function(resultText){
						$('#result').html(resultText);
					},
		error : function(jqXHR, exception){
		console.log('Error occured!!');
		}
	});
}
</script>
</head>
<body>
<h2>JQuery AJAX Example</h2>
Enter your name:
<input type="text" id="name"/><br/>
<button onclick="callJqueryAjax()">Submit</button>
<br/>
<h3 id="result"></h3>


</body>
</html>