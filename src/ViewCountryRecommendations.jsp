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

<div class="scroll" style="height:500px">
<c:forEach var="r" items="${recommendations}">       
  <button id="${r.getId()}" class="seeCountryRecommendations w3-btn w3-margin-bottom w3-animate-opacity w3-round-xlarge" style="background-color:#6AA84F ;color:#FAF9F8;width:340px">
   <span class="w3-right w3-opacity"> ${r.getTotalRate()} </span>
   <h4> ${r.getName()} </h4> 
 </button>
 <br>
</c:forEach>
</div>