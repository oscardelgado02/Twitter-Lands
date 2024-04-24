<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="imgs/upf.jpg">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title> TwitterLands </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-red.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="shortcut icon" href="imgs/Logo.png">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript">
$(document).ready(function(){
	
	$.ajaxSetup({ cache: false }); //Avoids Internet Explorer caching!	
	$(document).on("click",".menu",function(event) {
		$('#content').load($(this).attr('id'));
		event.preventDefault();
	});
	$(document).on("submit","form", function(event) {
		$('#content').load($(this).attr('action'),$(this).serialize());
	    event.preventDefault();
	});
	/* Add tweet */
	$(document).on("click",".addtweet",function(event){
		$.post( "AddTweet", { content: $("#tweetContent").val(), countryId: $("#countryId").val() } , function(event) {
			location.reload(true);		
		});
		event.preventDefault();
	});
	/* Delete tweet */
	$(document).on("click",".delTweet",function(event){
		var tweet = $(this).parent();
		$.post( "DelTweet", { id: $(this).parent().attr("id") } , function(event) {
			$("#content").load("GetUserInfo");				
		});
		event.preventDefault();
	});
	/* Follow user */
    $(document).on("click",".followUser",function(event){
        var user = $(this).parent();
        $.post( "FollowUser", { user: $(this).parent().attr("id")}, function(event) { 
            location.reload(true)
        });
        event.preventDefault();
    });
    /* UnFollow user */
    $(document).on("click",".unfollowUser",function(event) {
        var user = $(this).parent();
        $.post( "UnFollowUser", { user: $(this).parent().attr("id")}, function(event) {
            location.reload(true)
        });
        event.preventDefault();
    });
    /* Follow country from search */
    $(document).on("click",".followCountrySearch",function(event){
        $.post( "FollowCountry", { id: $(this).parent().attr("id")}, function(event) { 
            location.reload(true)
        });
        event.preventDefault();
    });
    /* UnFollow country from search */
    $(document).on("click",".unfollowCountrySearch",function(event){
        $.post( "UnFollowCountry", { id: $(this).parent().attr("id")}, function(event) { 
            location.reload(true)
        });
        event.preventDefault();
    });
	/* Create Event */
    $(document).on("click",".eventCreation",function(event){
        $.post( "CreateEvent", { name: $(".nameEvent").val(), location: $(".locationEvent").val(),
        	info: $(".infoEvent").val(), countryId: $(".countryEvent").val(),
        	date: $(".dateEvent").val()}, function(event) {
            $("#content").load("GetOwnTimeline");
        });
        event.preventDefault();
    });
    /* Create Recommendation */
    $(document).on("click",".recommendationCreation",function(event){
        $.post( "CreateRecommendation", { name: $(".nameRecommendation").val(), location: $(".locationRecommendation").val(),
        	info: $(".infoRecommendation").val(), countryId: $(".countryRecommendation").val(),
        	rate: $(".rateRecommendation").val()}, function(event) {
            $("#content").load("GetOwnTimeline");
        });
        event.preventDefault();
    });
    /* Add Recommendation */
    $(document).on("click",".recommendationAdd",function(event){
        $.post( "AddRecommendation", { id: $(".idRecommendation").val(), 
        	info: $(".infoRecommendation").val(), rate: $(".rateRecommendation").val()}, function(event) {
            $("#content").load("GetOwnTimeline");
        });
        event.preventDefault();
    });
    /* See Followed Users Tweets */
	$(document).on("click",".seeFollowersTweets",function(event){
		$.post( "GetFollowersTweets", {}, function(event) {
			location.reload(true);	
		});
		event.preventDefault();
	});
    /* See Country Tweets */
	$(document).on("click",".seeCountryTweets",function(event){
		$.post( "GetCountryTweets", { id: $(this).attr("id")}, function(event) {
			location.reload(true);	
		});
		event.preventDefault();
	});
	/* See Country Events */
	$(document).on("click",".seeCountryEvents",function(event){
		$.post( "GetCountryEvents", { id: $(this).attr("id")}, function(event) {
			location.reload(true);	
		});
		event.preventDefault();
	});
	/* See Country Recommendations */
	$(document).on("click",".seeCountryRecommendations",function(event){
		$.post( "GetUserRecommendationsByCountry", { id: $(this).attr("id")}, function(event) {
			location.reload(true);	
		});
		event.preventDefault();
	});
	/* Search action */
	$(document).on("click",".doSearch",function(event){
		$.post( "GetSearchResults", { input: $(".searchInput").val(), status: 1}, function(event) {
			$("#content").load("GetSearchResults");
		});
		event.preventDefault();
	});
	/* View user profile */
	$(document).on("click",".viewProfile",function(event){
		$.post( "GetUserInfo", { user: $(this).attr("value")}, function(event) {
			$("#content").load("GetUserInfo");
		});
		event.preventDefault();
	});
	/* View country profile */
	$(document).on("click",".viewCountryProfile",function(event){
		$.post( "GetCountryInfo", { id: $(this).attr("value")}, function(event) {
			$("#content").load("GetCountryInfo");
		});
		event.preventDefault();
	});
	/* Edit User Info */
    $(document).on("click",".userEditing",function(event){
        $.post( "EditUserInfo", { mail: $(".mailUser").val(), pwd1: $(".pwd1User").val(),
            pwd2: $(".pwd2User").val(), date: $(".dateUser").val(),
            gender: $(".genderUser").val(), country: $(".countryUser").val(), user: $(".userName").val()}, function(event) {
            location.reload(true);  
        });
        event.preventDefault();
    });
    /* Like Tweet */
    $(document).on("click",".likeTweet",function(event){
        $.post( "AddLike", { id: $(this).parent().attr("id") } , function(event) {
            location.reload(true);        
        });
        event.preventDefault();
    });
});
</script>
</head>
<body>

 	<!-- Begin Navigation -->
 	<div class="w3-theme" id="navigation">
    <jsp:include page="${menu}" />
 	</div>
 	<!-- End Navigation -->
 
 	<!-- Begin Content -->
	<div id="content">
		<jsp:include page="${content}" />
	</div>
	<!-- End Content -->
	
	<script>
		function stack() {
  			var x = document.getElementById("stack");
  			if (x.className.indexOf("w3-show") == -1) {
    			x.className += " w3-show";
  			} else { 
    		x.className = x.className.replace(" w3-show", "");
  			}
		}
	</script>

  </body>
</html>