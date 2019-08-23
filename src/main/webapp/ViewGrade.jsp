<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GRADE</title>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("grade").value.length == 0) {
			alert("please enter grade!!");
			return false;
		}
	}
	</script>
<body bgcolor="#a3a3a3" >
<form method="post" action="AdministratorServlet1?varname=view_grades" onsubmit="return msg()">
<center>
<h1>GRADE</h1>
<br> <br> <br> 
<table>
<tr>
<td>grade:</td>
<td><input type="text" name="grade" id="grade"></td>
</tr>
    <tr>
<td></td>
<td><input  type="submit" value="submit"></td>
</tr>
 </table>
 </center>
</form>

</body>
</html>