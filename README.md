# Twitter Lands
 Twitter Lands is a web page project that is really similar to Twitter, but it is organized by countries and users can add events and recommendations to each country.

<div align="center">
<img src="https://github.com/oscardelgado02/oscardelgado02/blob/main/images/Twitter-Lands-Preview.png" align="center" style="width: 80%" />
</div>
<br>

## Steps to install properly

1- Open MYSQL.

2- Go to "Server->Users and privileges", and create an user called "mysql" with password "1234".

3- Give to the new user DBManagement permissions in Administrative Roles.

4- Create a connection called "epaw" attached to that user.

5- Now, in any connection, go to "Management->Data Import/Restore" and select "Import from Self-Contained File" and browse to get the "epaw.sql" file that is in the delivery.

6- Click in Start Import

7- After the process is finished, go to Eclipse.

8- Go to "File->Import" and select "WAR file".

9- Now browse the WAR file "Lab4_modified.war" that is in the delivery and click "Finish".

10- Now, open the "MainController.java" file, that is in the "controllers" folder in the Web Project and run it.

11- You can now navigate throught our app!

## Team
 - Óscar Delgado Rueda: https://www.linkedin.com/in/óscar-delgado-rueda-579834228/
 - Eduardo Ruiz Martinez: https://www.linkedin.com/in/eduardo-ruiz-martinez-0b7a27271/
 - Arnau Camarero Liebanes: https://www.linkedin.com/in/arnau-camarero-liebanes-23a365269/
 - Víctor Alcaide Rodríguez: https://www.linkedin.com/in/víctor-alcaide-rodríguez-272895253/

## License

Shield: [![CC BY-NC-SA 4.0][cc-by-nc-sa-shield]][cc-by-nc-sa]

<p xmlns:cc="http://creativecommons.org/ns#" xmlns:dct="http://purl.org/dc/terms/"><a property="dct:title" rel="cc:attributionURL" href="https://github.com/oscardelgado02/Twitter-Lands">Twitter Lands</a> © 2022 by <a rel="cc:attributionURL dct:creator" property="cc:attributionName" href="https://github.com/oscardelgado02">Óscar Delgado Rueda, Eduardo Ruiz Martinez, Arnau Camarero Liebanes, Víctor Alcaide Rodríguez</a> is licensed under <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/?ref=chooser-v1" target="_blank" rel="license noopener noreferrer" style="display:inline-block;">Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International</a></p>

[![CC BY-NC-SA 4.0][cc-by-nc-sa-image]][cc-by-nc-sa]

[cc-by-nc-sa]: http://creativecommons.org/licenses/by-nc-sa/4.0/
[cc-by-nc-sa-image]: https://licensebuttons.net/l/by-nc-sa/4.0/88x31.png
[cc-by-nc-sa-shield]: https://img.shields.io/badge/License-CC%20BY--NC--SA%204.0-lightgrey.svg
