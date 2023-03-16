<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Data</title>
<script type="text/javascript">
var browserObject;
function employeeValidation(param){
	if(window.XMLHttpRequest){
		browserObject=new XMLHttpRequest();
	}else if(window.ActiveXObject){
		browserObject=new ActiveXObject("Microsoft.XMLHTTP");
	}
	var url="searchRequest.jsp?searchCriteria="+param;
	try{
		browserObject.onreadystatechange=employeeResponse;
		browserObject.open("GET",url,true);
		browserObject.send();
	}catch(e){
		alert("unable to connect to server");
	}
	}
	function employeeResponse(){
		if(browserObject.readyState==4){
			var val=browserObject.responseText;
			document.getElementById('employeeResponse').innerHTML=val;
		}
	}
</script>
</head>
<body align="center">
<input type="text" id="employeeIdSearch" name="employeeIdSearch" onkeyup="employeeValidation(this.value)">
<div id="employeeResponse"></div>
</body>
</html>