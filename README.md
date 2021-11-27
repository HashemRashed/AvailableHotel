# What is Mancala Game and How Play it ?

The mancala is a board game that consists of two-player, board and stones
and these board consists are made up of two rows with small pits called "Pockets" and large pit called "Mancala".

![Mancala](https://user-images.githubusercontent.com/83239737/143691871-bb3be380-aba9-415c-bdc3-f51f15ce8631.png)

---

#Game Rules

#How Play Mancala Game ?

1. One player will start the game by picking any pit containing stones from their own side.

2. The player will remove all the stones from that pit,
   and deposit one stone at a time into neighboring pits going counter-clockwise until the stones run out.

3. If a player encounters their own pit, a stone is deposited in it.

4. If there are enough stones to go past the player’s own pit, stones are deposited continuing on the other side’s pits. However, if they encounter the other player’s pit, that store is skipped over.

5. If the last stone is deposited in the player’s own store, the player gets another turn.

6. If the last stone is placed in an empty pit on the player’s own side, the player takes this stone as well as the other player’s stones across from the empty pit landed in, and places them in their own pit.


#Winning the Game

When all six pits on one side are emptied the game ends. Each player will count the number of stones in their the own pit.
The player who has the most stones in their him pit wins.

---


# Mancala API Implementaion

### Java8, Maven, Spring Boot, Rest API, Swagger, H2 DB , Cache , Junit Test


## Technology used

1. Java 8

2. Maven

3. Spring Boot

4. Swagger

5. Lombok

6. H2 DB



The app will start running at <http://localhost:8090>.  
You can use inbuilt swagger ui to test the app or you go for the postman/curl clients.

Swagger: <http://localhost:8090/swagger-ui.html>.  
Swagger-docs:<http://localhost:8090/v2/api-docs>.

## Explore Rest APIs

The app defines following APIs.

- **`POST`** http://localhost:8090/games/mancala/create (for create mancala game by default take 6 stones in every pit),
- **`POST`** http://localhost:8090/games/mancala/create/{numberPitStones} (for create mancala game and specific number of stone in every pit, (Minimum is 4 stones) (Maximum is 10 stones))
- **`PUT`**  http://localhost:8090/games/mancala/sow/{gameId}/pits/{pitId} (sowing stones by game id and pit id)
- **`GET`**  http://localhost:8090/games/mancala/status/{gameId} (get status game by game id)
- **`GET`**  http://localhost:8090/games/mancala/reset/{gameId} (reset same game by game id)

You can test them using postman.


## Game Play With API's
Actions:
+ Call **`POST`** `/games/mancala/create` for create mancala game by default take 6 stones in every pit.
+ Call **`POST`** `/games/mancala/create/{numberPitStones}` for create mancala game and specific number of stone in every pit. (Minimum is 4 stones) (Maximum is 10 stones)
+ Call **`PUT`** `/games/mancala/sow/{gameId}/pits/{pitId}` for sowing stones by game id and pit id.
+ Call **`GET`** `/games/mancala/status/{gameId}` for get status game by game id.
+ Call **`GET`** `/games/mancala/reset/{gameId}` for reset same game by game id.

+ Check the `playerTurn` in the response.
+ Based on playerTurn, call **`PUT`** `http://localhost:8090/games/mancala/{gameId}/pits/{pitId}` with respective player till you get the winner
+ Keep checking Game `status`.
+ when game is finish `gameStatus` field in the response will tell you the winner in this game.
+ when game is finish you can not sow the stones you will get a message for it.

## Key points to note

+ API implementation and validation of parameters.
+ Using lombok library.
+ Using Junit Test.
+ Using Cache for store game  
+ Using H2 DB.
+ Swagger.



## Test Cases Covered :

1. Test Create New Mancala Game.
2. Test Create New Mancala Game with specific number of stones in every pit.
3. Test failure Create New Mancala Game because chosen number less than minimum number of stones.
4. Test failure Create New Mancala Game chosen number greater than max number of stones.
5. Test Get status of Mancala Game after created directly.
6. Test sowing stones by PlayerOne.
7. Test sowing stones by PlayerTwo.
8. Test reset Mancala Game exists.
9. Test sowing last stone by PlayerOne and finish game and winner is PlayerOne because he has more stones than the PlayerTwo.
10. Test sowing last stone by PlayerOne and finish game and winner is PlayerTwo because he has more stones than the PlayerOne.
11. Test sowing last stone on empty pit and got opposite stones.
12. Test failure Get Mancala game status when game id not found.
13. Test failure sowing stone when invalid pit index.
14. Test failure sowing stone from house pit for PlayerOne.
15. Test failure sowing stone from house pit for PlayerTwo.
16. Test failure sowing stone when the game is finish.


## Possible improvements

+ Registration API for play.
+ Finish the game.
+ Add Admin user.
+ History for the game.
