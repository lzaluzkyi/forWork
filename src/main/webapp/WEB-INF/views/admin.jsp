<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Rent type</title>
<style type="text/css">
	.form-horizontal .control-label{
		text-align: left;
	}
</style>
</head>
<body>


				<table width="100%" class="table table-bordered">

<c:forEach var="user" items="${users}">
						<tr>
						
									<td><a href = "/admin/userInf/${user.id}"> ${user.email}</a></td>

						</tr>
					</c:forEach>
					</table>
					</body>
					</html>