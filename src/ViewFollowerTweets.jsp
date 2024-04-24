<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
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
<div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge w3-animate-opacity">
	<h3 style = "color: #6D9EEB;">${selected_country.getName()} Tweet List</h3>
</div>

<div class="scroll" style="height:500px">
<c:forEach var="t" items="${tweets}">       
 <div id="${t.id}" class="w3-container w3-card w3-section w3-round-xlarge w3-animate-opacity" style = "background-color: #FAF9F8;"><br>
   <span class="w3-right w3-opacity"> ${t.postDateTime} </span>
   <h4 style = "color: #6D9EEB;"> ${t.uname} </h4><br>
   <hr class="w3-clear">
   <p style = "color: #6D9EEB;"> ${t.content} </p>
   <button type="button" class="likeTweet w3-btn w3-margin-bottom" style="background-color:#93C47D; color:#FAF9F8"><i class="fa fa-thumbs-up" style="color:#FAF9F8"></i> &nbsp;${t.likes} </button>
 </div>
</c:forEach>
</div>
