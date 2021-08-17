<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Preferences</title>
</head>
<body>
<h3>Spring MVC dropdown example using select tag</h3>
Country: ${preferences.country}<br/>
Favorite exercise: ${preferences.exercise}

</body>
</html>