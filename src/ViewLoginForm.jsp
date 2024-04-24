<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul class="server-errors-list">
<c:if test = "${login.error[0]}">
    <li> Entered user name doesn't exist </li>
</c:if>
<c:if test = "${login.error[1]}">
    <li> Password isn't correct </li>
</c:if>
</ul>
<style>

span a{

    list-style: none;
    
}
body{

    background-image: url(imgs/background.jpg);
   	background-position: top center;
}

img {
  display: block;
  margin-left: auto;
  margin-right: auto;
}

</style>
<body>
<div class="w3-container w3-display-middle">
<div style = "background-color: #6D9EEB; width:500px;" class="w3-container w3-round-xlarge">
    <div class="w3-container">
    
    <div style = "background-color: #6D9EEB;" class="w3-panel w3-border w3-round-xlarge">
    	<h2 style = "color: #FAF9F8" align="center">Login</h2>
    </div>
  		<p style="text-align:center;"><img src="imgs/Logo.png"style="width:40%"></p>
    <form action="LoginController" method="POST">
        <p>
        <label class="w3-text-white" for="user"> User name:</label>
          <br>
          <input class="w3-input w3-border w3-light-grey" type="text" id="user" name="user" placeholder="Name" value="${login.user}" required>
          <br><br>
          <label class="w3-text-white" for="pwd1"> Password: </label>
          <br>
          <input class="w3-input w3-border w3-light-grey" type="password" id="password" name="password" placeholder="Password" value="${login.password}" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{6,}$">
          <br>
           <p style = "color: #FAF9F8">Don't have an account?<span><a class="menu w3-btn w3-panel w3-border w3-round-large" style="float: center;" id="RegisterController" href=#> Register</a></span></p>
          <br>
        <input class="w3-btn w3-panel w3-text-white w3-border w3-round-large" style="background-color: #6D9EEB" type="submit" name="sumbit" value="Submit">
    </form>

    </div>
</div>
</div>