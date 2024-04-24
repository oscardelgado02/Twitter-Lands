<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<body>
<div class="w3-container w3-display-middle">
<div style = "background-color: #6D9EEB; width:500px;" class="w3-container w3-round-xlarge">
	<div class="w3-container">
  		<div style = "background-color: #6D9EEB;" class="w3-panel w3-border w3-round-xlarge">
    		<h2 style = "color: #FAF9F8">New event</h2>
  		</div>
        
        <p style = "color: #FAF9F8">Name:</p>
        <input id="nameEvent" name="nameEvent" class="w3-input w3-border w3-round nameEvent" type="text" value="${event.name}">
        <p style = "color: #FAF9F8">Location:</p>
        <input id="locationEvent" name="locationEvent" class="w3-input w3-border w3-round locationEvent" type="text" value="${event.location}">
        <p style = "color: #FAF9F8">Info:</p>
        <input name="infoEvent" id="infoEvent" class="w3-input w3-border w3-round infoEvent" type="text" value="${event.info}">
        <p style = "color: #FAF9F8">Country:</p>
        <select class="countryEvent" name="countryEvent" id="countryEvent">
	    	<option value="" disabled selected>Select country</option>
	    	<c:forEach var="c" items="${f_countries}"> 
				<option value="${c.id}">${c.name}</option>
			</c:forEach>
	    </select>
        <p style = "color: #FAF9F8">Date:</p>
        <input type="text" class="w3-input w3-border w3-round dateEvent" name="dateEvent" id="dateEvent" value="${event.date}">
        
        <button style = "color:#FAF9F8; background-color: #93C47D;" class="eventCreation w3-panel w3-border w3-round-xlarge w3-btn">Create</button>
        
        <p style = "color: #FAF9F8">Fake events or events that don't respect the rules of TwitterLands will be delated</p>
    
	</div>

</div>
</div>
</body>