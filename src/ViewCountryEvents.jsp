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
<div style = "background-color: #FAF9F8;" class="w3-panel w3-border w3-round-xlarge w3-animate-opacity">
	<h3 style = "color: #6D9EEB;">Events from ${selected_country.getName()}</h3>
</div>


<div class="scroll" style="height:500px">
<c:forEach var="e" items="${events}">       
 <div id="${e.id}" class="w3-container w3-card w3-section w3-round-xlarge w3-animate-opacity" style = "background-color: #FAF9F8;"><br>
   <h4 style = "color: #6D9EEB;"> ${e.name} </h4>
   <hr class="w3-clear">
   <p style = "color: #6D9EEB;"><strong>Location:</strong> ${e.location} </p>
   <p style = "color: #6D9EEB;"><strong>Date:</strong> ${e.date} </p>
   <p style = "color: #6D9EEB;"><strong>Info:</strong> ${e.info} </p>
 </div>
</c:forEach>
</div>
