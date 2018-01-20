<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../CSS/dashboard.css">
<title>User Profile</title>
</head>
<body>
	<div id="container">
	<h4>(User Profile)</h4>
		<form id="logoutForm" method="POST" action="/logout">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input id="logoutButton" type="submit" value="Logout!" />
	    </form>
	    <h1>Hello, <c:out value="${loggedUser.first_name}" />! </h1>
	    <p>(Option #1 Issue Areas in a nav bar)</p>
	    <div id="nav_bar">
	    	<a href="">ForEach this Issue areas</a>
	    	<a href="">Issue 1</a>
	    	<a href="">Issue 2</a>
	    	<a href="">Issue 3</a>
	    	<hr>
	    	
	    </div>
		<div id="organizations">
	    <h3>Your Organizations</h3>
	    
	    <table border="2">
	    	<thead>
	    		<tr>
					<th>Title</th>
					<th>Description</th>
				</tr>
	    	</thead>
	    	<c:forEach items="${organizations}" var="organization">
	    		<tr>
	    			<td><a href="/events/${ organization.getId() }"><c:out value="${organization.getTitle()}"/></a></td>
	    			<td><c:out value="${organization.getDescription()}"/></td>
	    		</tr>
	    	</c:forEach>
	    </table>
	    </div>
	    <div id="issue_areas">
	    <h4>Issue Areas</h4>
	    <p style="color: black">(Option #2: Issue Areas in a scroll bar)</p>

		<div style="height:200px;width:100px; border:2px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;">
		<c:forEach items="${all_issues}" var="issue">
	  		<tr>
	  			<td><a href="/users/${user.getId()}">Test</a></td>
	  			<hr>
	  		</tr>
	   	</c:forEach>
		</div>
		</div>
		<div id="events">
	    <h3>Events you are joining</h3>
	    <table border="1">
	    	<thead>
	    		<tr>
					<th>Name</th>
					<th>Held By:</th>
					<th>Date:</th>
					<th>RSVP By:</th>
					
					
				</tr>
	    	</thead>
	    	<c:forEach items="${organizations}" var="organization">
	    		<tr>
	    			<td><a href="/events/${ organization.getId() }"><c:out value="${organization.getTitle()}"/></a></td>
	    			<td><c:out value="${organization.getDescription()}"/></td>
	    			<td><c:out value="${organization.getDescription()}"/></td>
	    			<td><c:out value="${organization.getDescription()}"/></td>
  			
	    		</tr>
	    	</c:forEach>
	    </table>
	    </div>
	</div>
</body>
</html>