<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>

<style type="text/css">

                    
            .desplegable > li {
                float:left;
                list-style:none;
                left:0px;
            }
            
            .desplegable > .profileinfo {
                float:right;
                list-style:none;
            }
                        
            .desplegable li a {
                backgroud-color:#2894f4;
                text-decoration:none;
                padding:5px 10px;
                display:block;
            }
                        
            .desplegable li a:hover {
                background-color:#2894f4;
            }
            
            .desplegable li ul {
                list-style:none;
                display:none;
                position:absolute;
                background-color:#2894f4;
                color:#fff;
                min-width:80px;
                top:55px;
                right:0px;
            }
            
            .desplegable li:hover > ul {
                display:block;
            }
            
            .desplegable li .searchInput{
                position: absolute;
				width: 20%;
				left: 40%;
            }
            
            .desplegable li .doSearch{
                position: absolute;
				left: 62%;
            }       
                 
        </style>

<div class="w3-bar w3-blue">

	<ul class="desplegable">
	<li> <a class="w3-bar-item w3-button w3-hide-small" id="LogoutController" style="width:8%; height:8%" href="MainController"> <img src="imgs/Logo_menu.png" style="width:100%; height:100%" > </a></li>    <!-- Buscador -->
	<li><input style = "background-color: #FAF9F8; color: #6D9EEB;" type="text" id="searchInput" name="searchInput" class="w3-input w3-border w3-round-xlarge searchInput" 
		value="${search.input}" placeholder = "Search countries and users">
		<input style = "color:#FAF9F8; background-color: #6D9EEB; float:right;" type="submit" class="w3-btn w3-submit w3-panel w3-border w3-round-large doSearch" name="doSearch" id="doSearch" value="Search">
	</li>
    <li class="profileinfo"><a class="menu w3-bar-item w3-button" id="Profile" href=#> <img src="https://bodegassanjorge.com/wp-content/uploads/2021/04/Iconos-13.png" width="25" height="25" > </a> 
         <ul class="w3-animate-right">
                    <li id="account"><a class= "menu w3-bar-item w3-button w3-hide-small" style="float: right;" id="EditUserInfo" href=#>Account</a></li>
                    <li id="Profile"><button class= "viewProfile w3-bar-item w3-button w3-hide-small" value="${user.user}" style="float: right;" name="viewProfile" id="viewProfile">Profile</button></li>
                    <li id="LogOut"><a class="menu w3-bar-item w3-button w3-hide-small" style="float: right;" id="LogoutController" href=#> Logout</a></li>
        </ul>
    <li> <a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="stack()">&#9776;</a> </li>
    </ul>
</div>
