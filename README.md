Dev Mind Speed 
---
##Requirements
-java.version > 17 
-DataBase > MySql
-MySQL Workbench
-IntelliJ

---
create database 
**use MySQL Workbench

file > new Query tap 
create database with name "game" > create database game;
----------------------------------------------------------------------------------
update (application.properties) file in project > \demo\src\main\resources\application.properties
spring.datasource.username=**root
spring.datasource.password=**2232002

// use your username && password

-----------------------------------------------------------------------------------------------
run project 
Run>DemoApplications

-------------------------------------------------------------------------------------------------
use postman to test api 

1- Start Game > method (post) > http://localhost:8080/game/start?name=&difficulty=  (*enter name and difficulty after = )
ex > http://localhost:8080/game/start?name=ansam&difficulty=1

2- Submit Answar > method (post) >http://localhost:8080/game/{game_id}/submit?answar=   (* replace {game_id} with actual gameid & enter answar after=)
ex > http://localhost:8080/game/1/submit?answar=4

3- End Game >method (Get) > http://localhost:8080/game/{game_id}/end    (* replace {game_id} with actual gameid )
ex > http://localhost:8080/game/100/end







