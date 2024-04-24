<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="u" items="${users}">       
<div id="${u.user}" class="w3-container w3-card w3-round w3-white w3-center w3-section">
	<p>Friend Suggestion</p>
    <img src="imgs/avatar6.png" alt="Avatar" style="width:50%"><br>
    <div>${u.user}</div>
</div>
</c:forEach>



