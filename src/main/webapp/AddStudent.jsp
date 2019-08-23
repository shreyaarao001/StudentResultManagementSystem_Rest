<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN</title>
<style type="text/css">

.button{
height:30px;
width:100px;
}
</style>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("id").value.length == 0) {
			alert("please enter id!!");
			return false;
		}
		if (document.getElementById("name").value.length == 0) {
			alert("please enter name!!");
			return false;
		}
		if (document.getElementById("maths").value.length == 0) {
			alert("please enter marks!!");
			return false;
		}
		if (document.getElementById("physics").value.length == 0) {
			alert("please enter marks!!");
			return false;
		}
		if (document.getElementById("chemistry").value.length == 0) {
			alert("please enter marks!!");
			return false;
		}

	}
</script>
<body bgcolor="#a3a3a3">
<form method="post" action="AdministratorServlet1?varname=addstudent" onsubmit="return msg()">
<center>
<h1>ADD STUDENT</h1>
<br> <br> <br> 
<table>
<tr>
<td>id:</td>
<td><input type="text" name="id" id="id"></td>
</tr>
<tr>
<tr>
<td>name:</td>
<td><input type="text" name="name" id="name"></td>
</tr>
<tr>
<td>maths:</td>
<td><input type="text" name="maths" id="maths"></td>
</tr>
<tr>
<td>physics:</td>
<td><input type="text" name="physics" id="physics"></td>
</tr>
<tr>
<td>chemistry:</td>
<td><input type="text" name="chemistry" id="chemistry"></td>
</tr>
<tr>
<td></td>
<td><input class="button" type="submit" value="submit"></td> 
 </tr>
 </table>
 </center>
 </form>
</body>
</html>