<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge w3-animate-opacity">
	<h3 style = "color: #6D9EEB;">User recommendations from ${selected_country.getName()}</h3>
</div>

<div class="w3-panel w3-border w3-round-xlarge w3-animate-opacity" style = "background-color: #4A86E8;"><br>
	<h4 style = "color: #FAF9F8;"> ${selected_recommendation.getName()} </h4>
	<hr class="w3-clear">
	<p style = "color: #FAF9F8;"><strong>Location:</strong> ${selected_recommendation.getLocation()} </p>
	<p style = "color: #FAF9F8;"><strong>Total Rate:</strong> ${selected_recommendation.getTotalRate()} </p>
</div>

<c:forEach var="r" items="${recommendations}">       
 <div id="${r.id}" class="w3-container w3-card w3-section w3-round-xlarge w3-animate-opacity" style = "background-color: #FAF9F8;"><br>
   <h4 style = "color: #6D9EEB;"> ${r.uname} </h4>
   <hr class="w3-clear">
   <p style = "color: #6D9EEB;"><strong>Rate:</strong> ${r.rate} </p>
   <p style = "color: #6D9EEB;"><strong>Comments:</strong> ${r.info} </p>
 </div>
</c:forEach>
