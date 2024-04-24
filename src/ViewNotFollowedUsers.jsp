<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
	div.scroll{
         overflow: auto;
    }
    /* width */
    ::-webkit-scrollbar {
      width: 10px;
    }
    
    /* Track */
    ::-webkit-scrollbar-track {
      background: #00000;
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

<div class="scroll" style="height:300px">
<c:forEach var="u" items="${users}">       
<div id="${u.user}" class="w3-container w3-round-xlarge w3-card w3-round w3-center w3-section" style = "background-color: #4A86E8;">
    <div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge">
    <h4 style = "color: #6D9EEB" align="center">Friend Suggestion</h4>
    </div>
    <div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge">
    <h4 class="fuser" id="fuser" style = "color: #6D9EEB"><strong>${u.user}</strong></h4>
    </div>
       <button type="button" style = "color:#FAF9F8; background-color: #93C47D;" class="followUser w3-row w3-button w3-round-xlarge w3-section"><i class="fa fa-user-plus"></i> &nbsp;Follow</button> 
</div>
</c:forEach>
</div>