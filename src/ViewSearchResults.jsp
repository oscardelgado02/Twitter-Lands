<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge w3-animate-opacity">
	<h3 style = "color: #6D9EEB;">Results of ${search.input}</h3>
</div>

<h4 style = "color: #6D9EEB;">Users:</h4>

<c:forEach var="u" items="${searched_users}">       
 <div id="${u.user}" class="w3-container w3-card w3-section w3-round-xlarge w3-animate-opacity" style = "background-color: #FAF9F8;"><br>
   <h4 class= "username"><button class= "viewProfile w3-round-xlarge w3-btn w3-margin-bottom" style = "color:#6D9EEB; background-color: transparent;" value="${u.getUser()}" name="viewProfile" id="viewProfile"><strong> ${u.getUser()}</strong> </button></h4>
   <button type="button" style = "color:#FAF9F8; background-color: #93C47D;" class="followUser w3-row w3-button w3-round-xlarge w3-section"><i class="fa fa-user-plus"></i> &nbsp;Follow</button>
   <button type="button" style = "color:#FAF9F8; background-color: #93C47D;" class="unfollowUser w3-row w3-button w3-round-xlarge w3-section"><i class="fa fa-user-minus"></i> &nbsp;Unfollow</button>
   <br>
 </div>
</c:forEach>

<h4 style = "color: #6D9EEB;">Countries:</h4>

<c:forEach var="c" items="${searched_countries}">       
 <div id="${c.id}" class="w3-container w3-card w3-section w3-round-xlarge w3-animate-opacity" style = "background-color: #FAF9F8;"><br>
	<h4 class= "countryId"><button class= "viewCountryProfile w3-round-xlarge w3-btn w3-margin-bottom" style = "color:#6D9EEB; background-color: transparent;" value="${c.id}" name="viewCountryProfile" id="viewCountryProfile"><strong> ${c.name}</strong> </button></h4>
   <button type="button" style = "color:#FAF9F8; background-color: #93C47D;" class="followCountrySearch w3-row w3-button w3-round-xlarge w3-section"><i class="fa fa-user-plus"></i> &nbsp;Follow</button>
   <button type="button" style = "color:#FAF9F8; background-color: #93C47D;" class="unfollowCountrySearch w3-row w3-button w3-round-xlarge w3-section"><i class="fa fa-user-minus"></i> &nbsp;Unfollow</button>
   <br>
 </div>
</c:forEach>