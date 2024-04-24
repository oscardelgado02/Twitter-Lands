<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="u" items="${users}">       
 <div id="${u.getUser()}" class="w3-container w3-card w3-section w3-round-xlarge w3-animate-opacity" style = "background-color: #6D9EEB;"><br>
   <button class= "viewProfile w3-round-xlarge w3-btn w3-margin-bottom" style = "color:#FAF9F8; background-color: transparent;" value="${u.getUser()}" name="viewProfile" id="viewProfile"><strong> ${u.getUser()}</strong> </button>
   <br><button type="button" style = "color:#FAF9F8; background-color: #93C47D;" class="followUser w3-row w3-button w3-round-xlarge w3-section"><i class="fa fa-user-plus"></i> &nbsp;Follow</button>
   <button type="button" style = "color:#FAF9F8; background-color: #93C47D;" class="unfollowUser w3-row w3-button w3-round-xlarge w3-section"><i class="fa fa-user-minus"></i> &nbsp;Unfollow</button>
 </div>
</c:forEach>