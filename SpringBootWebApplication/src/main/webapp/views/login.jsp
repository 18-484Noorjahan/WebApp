<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
	<h4>Login Here</h4>
	
	<c:if test ="${not empty errorMsg}">
			<h4 style ="color:green"> ${errorMsg} </h4>
		</c:if>
   <form  action="loginForm" method="post">
    Email: <input type="text" name ="email" /><br/><br/>
    Password: <input type="password" name ="password" /> <br/><br/>
	<input type ="submit" value="login" />
   </form>
   <br/><br/>
   
   If not  registered .....<a href ="regPage"> <b>Click Here</b></a>
</body>


</html>