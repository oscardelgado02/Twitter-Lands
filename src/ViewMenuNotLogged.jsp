<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
    
<div class="w3-bar w3-blue">
	<a class="w3-bar-item w3-button" id="LogoutController" style="width:5%; height:5%" href="MainController"> <img src="imgs/Logo_menu.png" style="width:50%; height:50%" > </a>
	<a class="menu w3-bar-item w3-button w3-hide-small" id="RegisterController" href=#> Registration </a> 
	<a class="menu w3-bar-item w3-button w3-hide-small" id="LoginController" href=#> Login </a> 
	<a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="stack()">&#9776;</a>
</div>

<div id="stack" class="w3-bar-block w3-blue w3-hide w3-hide-large w3-hide-medium">
	<a class="menu w3-bar-item w3-button" id="RegisterController" href=#> Registration </a> 
	<a class="menu w3-bar-item w3-button" id="LoginController" href=#> Login </a> 
</div>
