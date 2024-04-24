<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script type="text/javascript">
$(document).ready(function(){
$('#navigation').load('MenuController');
$('#rcolumn').load('GetNotFollowedUsers');
$('#tl').load('GetFollowersTweets');
$('#tlc').load('GetCountryTweets');
$('#tle').load('GetCountryEvents');
$('#tlr').load('GetUserRecommendationsByCountry');
$('#followed_countries').load('GetFollowedCountries');
$('#recom').load('GetCountryRecommendations');
});
</script>

<script type="text/javascript">
const activeButton = true; //change this value to false and the button will be clickable
const button = document.getElementById('checkout-button');

if flag=1: 
    document.getElementById("your-btn").disabled = true;
else: 
    document.getElementById("your-btn").disabled = false;

if (activeButton) button.focus = "focus";
</script>

<style>
	w3-btn:focus{
		background-color: #6D9EEB;
	}
    div.scroll{
         overflow: auto;
    }
    /* width */
    ::-webkit-scrollbar {
      width: 10px;
    }
    
    /* Track */
    ::-webkit-scrollbar-track {
      background: #f1f1f1;
    }
    
    /* Handle */
    ::-webkit-scrollbar-thumb {
      background: #888;
      border-radius: 10px;
    }
    
    /* Handle on hover */
    ::-webkit-scrollbar-thumb:hover {
      background: #555;
    }
</style>

<body>

<!-- Above row -->
<div class="w3-row-padding">

<!-- Left column -->
<div class="w3-quarter w3-container">
	
    <!-- Create events or recommendations -->
    <div class="w3-padding-16">
    <div class="w3-container w3-round-xlarge" style = "background-color: #6D9EEB;">

		<div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge">
        <h6 style = "color: #6D9EEB;">Create events or recommendations:</h6>
		</div>

        <div style= "text-align:center">
        <h3><a class = "menu" id="CreateEvent" href=#><button style = "width:70%;color:#FAF9F8; background-color: #6D9EEB;"class="w3-panel w3-border w3-round-large w3-btn">Create a new event</button></a></h3>
        <h3><a class = "menu" id="AddRecommendation" href=#><button style = "width:90%;color:#FAF9F8; background-color: #6D9EEB;"class="w3-panel w3-border w3-round-large w3-btn">Create a new recommendation</button></a></h3>
        </div>

    </div>
    </div>
    
</div>

<!-- Middle column -->
<div class="w3-half w3-container">
	
    <!-- Tweet creator -->
    <div class="w3-padding-16">
    <div class="w3-container w3-round-xlarge" style="float:middle; background-color: #93C47D;">
	    
	    <div class="addTweet">
	        <p>
	        <input style = "background-color: #FAF9F8; color: #6D9EEB;" type="text" id="tweetContent" name="tweetContent" class="w3-input w3-border w3-round-xlarge tweetContent" 
	        value="${tweet.content}" placeholder = "${sessionScope.username}, what are you thinking?">
	        </p>
	        
	        <p>
	        <span style="float:left;">
	        <select class="countryId" name="countryId" id="countryId">
	              <option value="" disabled selected>Select country</option>
					<c:forEach var="c" items="${f_countries}"> 
						<option value="${c.id}">${c.name}</option>
					</c:forEach>
	        </select>
	        </span>
	        <input style = "color:#FAF9F8; background-color: #6D9EEB; float:right;" type="submit" class="w3-btn w3-submit w3-panel w3-border w3-round-large addtweet" name="addtweet" value="Tweet">
	        </p>
	    </div>
    </div>
    </div>
    
</div>

<!-- Right column -->
<div class="w3-quarter w3-container">
    <!-- Friend suggestion -->
    <div id="rcolumn">
		<p></p>
	</div>
    
</div>


</div>

<br>

<!-- Below row -->
<div class="w3-row-padding" style = "background-color: #6D9EEB;">

<!-- Left column -->
<div class="w3-quarter w3-container">
	
		<!-- See Tweets -->
    	<div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge">
        	<h4 style = "color: #6AA84F" align="left">Tweet list editor</h4>
		</div>
		
		<!-- See followers Tweets -->
	    <button id="seeFollowersTweets" style = "background-color: #6AA84F;" class="seeFollowersTweets w3-btn w3-panel w3-border w3-round-xlarge w3-animate-opacity">
	   		<h4 style = "color: #FAF9F8" align="left">See follower tweets</h4>
	 	</button>
    
    <div class="w3-container w3-round-xlarge" style = "background-color: #93C47D;">
    
		<div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge">
        <h6 style = "color: #6D9EEB;"><b>Select a country to see Tweets:</b> </h6>
		</div>
		
		<div id="followed_countries">
			<p></p>
		</div>
		
    </div>
    
</div>

<!-- Middle column -->

<div class="w3-half w3-container">
	
<!-- Tweet list -->
	<div id="${sessionScope.selected_tl}">
		<p></p>
	</div>
</div>


<!-- Right column -->
<div class="w3-quarter w3-container">

	<div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge">
        <h4 style = "color: #6AA84F" align="left">See another type of content</h4>
	</div>

    <!-- Filter by events -->
    <button id="seeCountryEvents" style = "background-color: #6AA84F;" class="seeCountryEvents w3-btn w3-panel w3-border w3-round-xlarge w3-animate-opacity">
   		<h4 style = "color: #FAF9F8" align="left">Filter by events</h4>
 	</button>
    
    <!-- Create events or recommendations -->
    <div class="w3-container w3-round-xlarge" style = "background-color: #93C47D;">
    
    	<div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge">
        	<h6 style = "color: #6D9EEB" align="left"><b>See latests recommendations</b></h6>
		</div>
    
        <div style = "background-color: #93C47D;" class="w3-panel w3-round-xlarge">
        
        <div id="recom">
			<p></p>
		</div>
        
		</div>

    </div>
    
</div>

</div>

</body>