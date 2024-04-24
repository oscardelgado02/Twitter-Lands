<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="t" items="${tweets}">       
 <div id="${t.id}" class="w3-container w3-card w3-section w3-round-xlarge w3-animate-opacity" style = "background-color: #FAF9F8;"><br>
   <span class="w3-right w3-opacity"> ${t.postDateTime} </span>
   <h4 style = "color: #6D9EEB;"> ${t.uname} </h4><br>
   <hr class="w3-clear">
   <p style = "color: #6D9EEB;"> ${t.content} </p>
   <button type="button" class="likeTweet w3-btn w3-margin-bottom" style="background-color:#93C47D; color:#FAF9F8"><i class="fa fa-thumbs-up" style="color:#FAF9F8"></i> &nbsp;${t.likes} </button>
   <c:if test = "${user.user == selected_user.user}">
   	<button type="button" style = "color:#FAF9F8; background-color: #4A86E8;" class="delTweet w3-btn w3-margin-bottom w3-round-xlarge"><i class="fa fa-trash"></i> &nbsp;Delete</button>   
   </c:if>
 </div>
</c:forEach>
