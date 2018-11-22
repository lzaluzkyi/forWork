<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Welcome</title>
</head>
<body>

				<form:form class="form-horizontal" modelAttribute="user" action="/admin/userInf/${user.id}/changepersinf" method="POST">
					<div class="form-group">
						<label for="name" class="control-label col-sm-2">firstName:</label>
						<div class="col-sm-10">
							<form:input type="text" path="firstName" id="firstName" class="form-control"/> 
						</div>
					</div>
					
										<div class="form-group">
						<label for="name" class="control-label col-sm-2">secondName:</label>
						<div class="col-sm-10">
							<form:input type="text" path="secondName" id="secondName" class="form-control"/> 
						</div>
					</div>
					

					<div class="form-group">
						<div class="col-sm-10 col-sm-offset-2">
							<button class="btn btn-success" type="submit">Create</button>
						</div>
					</div>
				</form:form>


</body></html>