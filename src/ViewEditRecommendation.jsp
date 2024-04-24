<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container w3-display-middle">
<div style = "background-color: #6D9EEB; width:500px;" class="w3-container w3-round-xlarge">
	<div class="w3-container">
    
  		<div style = "background-color: #6D9EEB;" class="w3-panel w3-border w3-round-xlarge">
    		<h2 style = "color: #FAF9F8">"Recommendation name"</h2>
  		</div>
        
        <p>
        <label style = "color: #FAF9F8">Select a place:</label>
        <input type="search" id="search" name="search" class="w3-input w3-border w3-round" placeholder="Actual name">
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Info:</label>
        <input type="text" class="w3-input w3-border w3-round" placeholder="Actual info">
        </p>
        
        <p>
        <label style = "color: #FAF9F8" for="rate">Rate (between 0 and 10):</label>
  		<input type="range" id="rate" name="vol" min="0" max="10">
        </p>
        
        <div style= "text-align: center;">
        <h3>
        <button style = "color:#FAF9F8; background-color: #93C47D;" class="w3-panel w3-border w3-round-xlarge w3-btn">Edit recommendation</button>
        </h3>
        </div>
        
        <p style = "color: #FAF9F8">Recommendations that don't respect the rules of TwitterLands will be delated</p>
    
	</div>

</div>
</div>

</body>