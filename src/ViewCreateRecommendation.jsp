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
    		<h2 style = "color: #FAF9F8">New recommendation</h2>
  		</div>
        
        <p>
        <label style = "color: #FAF9F8">Name:</label>
        <input class="w3-input w3-border w3-round nameRecommendation" id="nameRecommendation" name="nameRecommendation" type="text" value="${recommendation.name}" placeholder="Input the name of the place to recommend">
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Location:</label>
        <input class="w3-input w3-border w3-round locationRecommendation" id="locationRecommendation" name="locationRecommendation" type="text" value="${recommendation.location}" placeholder="Input the location of the place">
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Info:</label>
        <input class="w3-input w3-border w3-round infoRecommendation" id="infoRecommendation" name="infoRecommendation" type="text" value="${recommendation.info}" placeholder="Write your opinion of this place">
        </p>
        
        <p><label style = "color: #FAF9F8">Country:</label>
        <select class="countryRecommendation" id="countryRecommendation" name="countryRecommendation">
  			<option value="" disabled selected>Select country</option>
  			<c:forEach var="c" items="${f_countries}"> 
				<option value="${c.id}">${c.name}</option>
			</c:forEach>
		</select>
        </p>
        
        <p>
        <label style = "color: #FAF9F8" for="rateRecommendation">Rate (between 0 and 10):</label>
  		<input type="range" class="w3-range rateRecommendation"id="rateRecommendation" value="${recommendation.rate}" name="rateRecommendation" min="0" max="10">
        </p>
        
        <div style= "text-align: center;">
        <p>
        <button style = "color:#FAF9F8; background-color: #93C47D;" class="recommendationCreation w3-panel w3-border w3-round-xlarge w3-btn">Create</button>
        </p>
        </div>
        
        <p style = "color: #FAF9F8">Recommendations that don't respect the rules of TwitterLands will be delated</p>
    
	</div>

</div>
</div>

</body>