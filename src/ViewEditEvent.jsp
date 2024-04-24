<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container w3-display-middle">
<div style = "background-color: #6D9EEB; width:500px;" class="w3-container w3-round-xlarge">
	<div class="w3-container">
    
  		<div style = "background-color: #6D9EEB;" class="w3-panel w3-border w3-round-xlarge">
    		<h2 style = "color: #FAF9F8">"Event name"</h2>
  		</div>
        
        <p>
        <label style = "color: #FAF9F8">Name:</label>
        <input type="search" id="search" name="search" class="w3-input w3-border w3-round" placeholder="Actual name of the event">
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Location:</label>
        <input class="w3-input w3-border w3-round" type="text" placeholder="Actual location">
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Info:</label>
        <input class="w3-input w3-border w3-round" type="text" placeholder="Actual info">
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Country:</label>
        <select class="w3-select" name="option">
  			<option value="" disabled selected>Choose your option</option>
  			<option value="1">Option 1</option>
  			<option value="2">Option 2</option>
  			<option value="3">Option 3</option>
		</select>
        </p>
        
        <p>
        <label style = "color: #FAF9F8">Date:</label>
        <input type="date" id="birthday" name="birthday">
        </p>
        
        <div style= "text-align: center;">
        <h3>
        <button style = "color:#FAF9F8; background-color: #93C47D;" class="w3-panel w3-border w3-round-xlarge w3-btn">Edit</button>
        </h3>
        </div>
        
        <p style = "color: #FAF9F8">Fake events or events that don't respect the rules of TwitterLands will be delated</p>
    
	</div>

</div>
</div>

</body>