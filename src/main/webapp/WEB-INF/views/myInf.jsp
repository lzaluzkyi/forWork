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
				<table width="100%" class="table table-bordered">

							<tr>
							<td>${user.firstName}</td>
							<td>${user.secondName}</td>
							<td>${user.email}</td>
							<td>${user.phone}</td>
							<td>${user.role}</td>
									<sec:authorize access="hasRole('ROLE_ADMIN')">
				<td><a  class="btn btn-success" href="/admin/userInf/${user.id}/setadmin">Set admin</a></td>
				<td><a  class="btn btn-success" href="/admin/userInf/${user.id}/changepersinf">change personal inf</a></td>
				<td><a  class="btn btn-success" href="/admin/userInf/${user.id}/gotoexsel">Create exsel</a></td>
				
								</sec:authorize>
							
						</tr>
					

</table>


</body>
</html>