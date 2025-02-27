<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
	<h4>Register Here</h4>
	
	<c:if test ="${not empty successMsg}">
		<h4 style ="color:yellow"> ${successMsg} </h4>
	</c:if>
	<c:if test ="${not empty errorMsg}">
			<h4 style ="color:green"> ${errorMsg} </h4>
		</c:if>
   <form  action="regForm" method="post">

    Name: <input type="text" name ="name" /><br/><br/>
    Email: <input type="text" name ="email" /><br/><br/>
    Password: <input type="password" name ="password" /> <br/><br/>
    Phone No: <input type="text" name ="phoneno" /><br/><br/>
    <input type="submit" value="Register" /><br/><br/>
   </form>
   <br/><br/>
   
   If already registered .....<a href ="loginPage"> <b>Click Here</b></a>
</body>


</html>