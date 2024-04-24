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
    		<h2 style = "color: #FAF9F8">Add recommendation</h2>
  		</div>
        
        <p>
        <label style = "color: #FAF9F8">Select a place:</label>
        <select class="idRecommendation" id="idRecommendation" name="idRecommendation">
        	<option value="" disabled selected>Select a place you want to recommend</option>
        	<c:forEach var="r" items="${recommendations}"> 
  				<option value="${r.id}">${r.name}</option>
			</c:forEach>
		</select>
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Info:</label>
        <input type="text" class="infoRecommendation w3-input w3-border w3-round" id="infoRecommendation" name="infoRecommendation" value="${recommendation.info}" placeholder="Write your opinion of this place">
        </p>
        
        <p>
        <label style = "color: #FAF9F8" for="rate">Rate (between 0 and 10):</label>
  		<input type="range" class="w3-range rateRecommendation"id="rateRecommendation" value="${recommendation.rate}" name="rateRecommendation" min="0" max="10">
        </p>
        
        <div style= "text-align: center;">
        <h6><a class="menu" id="CreateRecommendation" href=#>
        <button style = "color:#FAF9F8; background-color: #93C47D;" class="w3-panel w3-border w3-round-xlarge w3-btn">Can't find the place you want to recommend? Register it</button>
        </a></h6>
        </div>
        
        <div style= "text-align: center;">
        <h4>
        <button style = "color:#FAF9F8; background-color: #93C47D;" class="recommendationAdd w3-panel w3-border w3-round-xlarge w3-btn">Add recommendation</button>
        </h4>
        </div>
        
        <p style = "color: #FAF9F8">Recommendations that don't respect the rules of TwitterLands will be delated</p>
    
	</div>

</div>
</div>

</body>