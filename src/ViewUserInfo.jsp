<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
href="https://www.w3schools.com/w3css/4/w3.css">

<script type="text/javascript">
$(document).ready(function(){
$('#rcolumn').load('GetNotFollowedUsers');
$('#tl').load('GetUserTweets');
$('#followed').load('GetFollowedUsers');
$('#followers').load('GetFollowers');
$('#followed_countries').load('GetFollowedCountries');
});
</script>

<style>
	w3-btn:active{
    	background-color: #6D9EEB;
    }
    
	div span p {
    	background-image: none;
        text-indent:120px;
	}
    
    body{
    	background: url(https://www.technistone.com/color-range/image-slab/Starlight%20Black_SLAB_web.jpg);
  		background-repeat: no-repeat;
  		background-size: 1920px 1080px;
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

<!--USER INFO-->
<div class="banner">
    <div class="w3-container w3-display-topmiddle w3-padding-64">
    
    <div style = "background-color: #6D9EEB; height:150px; width:550px;" class="w3-container w3-round-xlarge" id="${selected_user.user}">
    <span>
            <br><img class="w3-circle" src="https://static.vecteezy.com/system/resources/previews/002/318/271/original/user-profile-icon-free-vector.jpg" style="width:20%; position:absolute">
            <br>
            <p class="w3-text-white">${selected_user.user}</p>
            <p class="w3-text-white">${country.getName()}<span style="float:right;">${followers} Followers</span>
            </p>
	</span>
	<br><button type="button" style = "color:#FAF9F8; background-color: #93C47D;" class="followUser w3-row w3-button w3-round-xlarge w3-section"><i class="fa fa-user-plus"></i> &nbsp;Follow</button>
	<button type="button" style = "color:#FAF9F8; background-color: #93C47D;" class="unfollowUser w3-row w3-button w3-round-xlarge w3-section"><i class="fa fa-user-minus"></i> &nbsp;Unfollow</button>
    </div>
    </div>
</div>

<br><br><br><br><br><br><br><br><br><br><br>
<!--USER/COUNTRY FOLLOWS-->
<div class="w3-container w3-display-topmiddle w3-padding-64" style="position: relative;">
    <div style = "background-color: #6D9EEB;" class="w3-container">
    
    <div class="w3-row-padding">
  		<div class="w3-quarter">
          <h4 class="w3-container w3-round-xlarge" style="background-color:#FAF9F8;height: 35px;color:#93C47D">Followed Users</h4>
          <div class="w3-container w3-round-xlarge" style="background-color:#93C47D;height: 175px;color:#6D9EEB">
          	<p></p>
          	
			<div class="scroll" style="height: 130px">
	        	<div id="followed">
				<p></p>
				</div>
	        </div>

          </div>
	
    <div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge">
        <h4 style = "color: #93C47D" align="left">Followed Countries</h4>
		</div>
    
    <!-- See followed Countries -->
    <div class="w3-container w3-round-xlarge" style = "background-color: #93C47D;">

		<br><div id="followed_countries">
			<p></p>
		</div>

    </div>
          
        </div>
        
        
<!--USER TWEETS-->
        <div class="w3-half w3-padding">
        <div class="w3-container w3-round-xlarge w3-padding-16" style="background-color: #FAF9F8;">
              <div style = "font-size:16px;background-color: #FAF9F8; color: #6D9EEB;">
              ${selected_user.user}'s Tweets
              </div>
          </div>
        <div class="scroll" style="height: 400px">
          <div id="tl">
			<p></p>
			</div>
			</div>
        </div>
<!--USERS SUGGESTIONS-->
        
        <div class="w3-quarter w3-padding">
        <!-- Followers -->
        <h4 class="w3-container w3-round-xlarge" style="background-color:#FAF9F8;height: 35px;color:#93C47D">Followers</h4>
          <div class="w3-container w3-round-xlarge" style="background-color:#93C47D;height: 175px;color:#6D9EEB">
          	<p></p>
          	
			<div class="scroll" style="height: 120px">
	        	<div id="followers">
				<p></p>
				</div>
	        </div>

          </div>
        <!-- Friend suggestion -->
    		<div id="rcolumn">
			<p></p>
			</div>
		</div>

</div>
</div>

</div>
</body>