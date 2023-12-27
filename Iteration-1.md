# Sudoku Vocabulary App

## Directory
- [Version](#version)
- [Introduction](#introduction)
- [Description](#description)
- [User Stories](#visuals)
  - [Login](#login)
  - [Register](#register)
  - [Popup](#popup)
  - [Scorekeeping](#scorekeeping)
  - [Gameboard](#gameboard)
  - [Mode](#mode)
  - [Hint](#hint)
  - [Lives](#lives)
  - [Definition](#definition)
  - [Database](#database)
  - [Leaderboard](#leaderboard)
- [TDD Examples](#tdd-examples)
- [Screen Mock Ups](#screen-mock-ups)
- [Authors](#authors)

## Version
1

## Introduction
The purpose of this iteration will be to describe user stories for novice, intermediate, and expert users of a Sudoku Vocabulary Practice Application and to develop test cases in order to follow the methodology of Test Driven Development (TDD).

## Description

Sudoku lets players learn new languages in an easy and fun way. It has 9x9 grid of cells each containing a word in your native language or
the language being studied. Players are asked filled the cells with the corresponding word in the other language.(If the cell is filled with your native language, enter the answer in the language you are studying. If the cell is filled with the language you are studying, enter the answer in your native language)

## User Stories
### Login
#### User Type: Novice

The novice user wants to log into their Sodoku account, in which the user has already registered an account. The user enters his email and password then presses the login button. This will send a request to the authetication server which will determine the novice users access rights. Once the system has matched the user identity and password with what is stored. The user will be redirected to the homepage of the application where they can check leaderboard or start a new game. 

### Register
#### User Type: Novice
The novice user is a new user that does not have an account in the authetication server. On the login page the novice user will press the register button. They will now be presented with a new activity that asks for their information. This new activity will ask for an email, username, and password. Once that has been inputted the user will press the register button. 

The application will send the inputted values to the authetication server and create a new account. Once this has been completed the user will be presented with the welcome screen. On the welcome screen the new user will be able to view the leaderboard or start a new game.

### Popup
#### User Type: Novice
A novice user is interested in learning the German language by using the Soduko Vocabulary Application. This user is already a registered user and is able to log in with their username and password. The user is able to start a new game and is presented with a standard 9x9 Soduko board. 

Once the user presses down on a square they will be presented with a popup. In the popup they will see the word in English and be able to enter the answer in German. Once they are content with their answer the user will press the confirmation button. 

The square will appear red if it is wrong and green if it is correct. So the user will know if they have gotten the correct or incorrect answer.

### Scorekeeping
#### User Type: Novice
The user is a novice level player and wishes to track their progress as they indulge in the game. The prior game they have played and their score may be presented on the leaderboard if they rank in the top ten. 

When the user starts a new game they will press the Play button. After starting the game the Play button it will turn into a Pause button. Once the game has begun a stopwatch will start from 0 until the User either finishes or pauses the game by pressing the Pause button. 

If the user presses Pause they will no longer be able to press on any squares and therefore prevented from inputting any words into the Sodoku board. If the user presses the Play button again the timer will continue to run until the game is completed. 

### Gameboard
#### User Type: Novice
A novice user wants to play the game and they are familiar with typical soduku puzzles. As a novice user they want to see this familiar formatting. After the novice user has logged in and pressed new game the novice user will see a 9x9 game board. 

This game board will be further divided into smaller 3x3 word puzzles, which are separated by bold borders from the other 3x3 squares. 

As a novice user they want to see a 9x9 game board as soon as they log in and start a new game. Upon pressing a square each will contain a word in it, which will be presented in a popup. 

Each of the squares in the rows, columns, which make up the 3x3 regions, and ultimately the entire 9x9 board will have words in it.

### Mode
#### User Type: Novice

This user is a novice who wants to use two different modes. In the first mode the novice user will have a English word appear as they press on one of the squares. The answer will need to be inputted in German, the language they are learning.

The second mode will be a inverse of the first mode. The user will press on a square in the board and be presented with a German word. The user will need to be able to identify the word and input the correct English translation.

By using these different modes the novice user will be able to progress their skills faster and reduce the learning curve.

### Hint
#### User Type: Intermediate
As an intermediate user I am getting better at the easier mode of the game. The mode in which I enter the english translation for the squares containing German words is not as difficult as it use to be. However, the other mode in which I need to enter the answer in German is proving to be difficult for the intermediate user. 

This is a high learning curve and to gain additional help the intermediate user presses on the hint button. This button is presented when the user presses on a square which displays a popup. In this popup they will see an input box for the answer and a confirmation button. They will also see an additional hint button which will provide the first letter of the word that will be the answer.

### Lives
#### User Type: Intermediate
As a intermediate user I want to be challenged by learning a new language is difficult at first. The game is oriented in a manner where if I enter in a wrong answer I will lose one of my lives. 

As an intermediate user I will have less chances to get the correct answer than a novice user and more than an expert user. As I am an intermediate user I will start with five lives. If I am a novice user I will have seven and an expert will have 3.

The players in all three difficulty settings will be able to incrementally challenge themselves by switching between game modes and adjust their difficulty level to have fewer or more lives.

### Definition
#### User Type: Intermediate
As a intermediate user, I do not want to blindly memorize the translated words. The intermediate user will want to see the meaning of the word in the language being studied. 

This will encourage the intermediate user to increase their knowledge of their native language by optionally being allowed to see definitions. After pressing on a square the user will see a popup. This will contain several options including a definition button. By pressing on the definition button the user will see a toast that contains the shown words definition in English.

This will allow the user to think about what the answer may be, with a more throrough understanding of the word in their native language.

### Database
#### User Type: Expert
I am a competitive expert user. I am developing a firm grasp of German but I want to be able to challenge myself further by competing against other users.

First I will start a new game and once I have finished the game I want my score to be saved into a database. I want to keep my game history and my best score.

### High Score
#### User Type: Expert
I am an expert level player and wish to know the time needed to beat the game. The highest scores from previous games should be displayed on the top left corner beside the “high score” text of the gameplay interface.

When the user entered the gameplay interface, the highest score is automatically displayed. It will be updated if the user manages to complete the game in a shorter time than their prior game(s). If they beat their high score, their new personal best will be compared to the high scores in the leaderboard.

If they are able to place in the top fifteen in the leaderboard they will now have the title as a top fifteen Soduko Vocabulary player.

### Leaderboard
#### User Type: Expert
An expert user is a fairly long time user of the application. They already have registered and have been autheticated as users of the application.

When the log in they are presented with the home activity. In this activity they are able to select between several options: new game, leaderboard, or logout.

If the user selects leaderboard they will see the top fifteen users. Each user will only have one score presented on the screen. So they cannot hold multiple high scores in the leaderboard.

### TDD Examples

| USER STORY | DESCRIPTION |
| --- | ----------------- |
| Register   | When a user presses the sign-in button, the system would call an activity that allows the user to create his or her own personal account.                |
| Register   | When a user enters an invalid password, the system would generate a pop-up informing the user about the wrong input, The user should be able to re-enter the password. |
|Register|When a user enters an invalid username, the system would generate a pop-up informing the user about the wrong input. The user should be able to re-enter the username.|
|Login|When a user enters a pre-existing username and the correct password, the system would switch the page to the user’s account.|
|Login|When a user enters a non-existing username, the system would generate a pop-up about the incorrect input and allows the user to re-enter.|
|Login|When a user enters a pre-existing username and a password that does not match the username, the system would generate a pop-up about the incorrect input and allows the user to re-enter.|
|Mode|When a user is on the home page, there is a toggle button. A user may use this to toggle between seeing either the word in English or German. A user is able to toggle between seeing either English or German, in which they will provide the answer in the opposing language.|
|Hint|When a user presses on a square. They will be presented with a popup. From this popup they will be able to press a hint button. Once they have pressed the hint button they will see the first letter of the word in the language being studied inside the cell.|
|Lives|Depending on the difficulty, a user has a different number of lives. Novice users have 7 lives. Intermediate users have 5 lives. Expert users have 3 lives. Everytime a user fails to input the correct answer, the user will lose one life. The number of lives they have at the moment is displayed at the top of the screen and a user can check it anytime while playing the game. When a user consumes all lives, the user loses the game. |
|Definition| The user can press on a square on the gameboard and is presented with a popup. From this popup the user can select the definitions button. When a user presses the definition button, they will be presented the definition of the word within that same popup.|
|Popup|When a user presses on a square which may contain the German word “Wagon” depending on the mode they are in. They will be presented with a popup. This popup will contain several buttons such as: hint, definition, an input for the answer, and confirm button. If they want to view a hint or definition but want to place the answer in at a later time they can press the X button to close the popup.|
|Scorekeeping|When a user starts the game and if they complete the game after two hours, the application would display 2:00:00 as their final score.|
|Scorekeeping|When a user starts and plays the game for 1 hour, presses the pause button at 1 hour, returns to the game after 30 minutes, and completes the game in 10 minutes, the system would display 1:10:00.|
|Gameboard|When the user presses "Play," on a new game the timer will start from zero and the play button will turn red and display the text “Pause.”|
|Gameboard|When the user enters the correct answer, “car,” in the popup for the cell at the first column first row, the cell would turn green. If they enter the wrong input ,”wood,” the cell would turn red and the user would lose a life.|
|Gameboard|When the user complete the game, the timer will stop. The time they finish will be their final score and will be entered into the database. If the score is higher than their "High Score" they will get a new high score and a toast congratulating them.|

## Screen Mock Ups
| INTERFACE | DESIGN | DESCRIPTION |
| --- | ----------------- | ------- |
| Register Interface | ![RegisterInterface](/uploads/8478d7610d7b85836f01fd39622e1ea1/RegisterInterface.png)| After the user presses the register button on the sign up page. They will be presented with the following activity. Here they will be asked to enter an email, unique username, and password. Once they have entered that information they will press the register button. If the user wants to go back they can use the general gesture or press on the back button on the phone's operating system. |
|Login Interface|![LoginInterface](/uploads/7c911346e9b1b630f8306a23efe27899/LoginInterface.png)|This activity asks a user to enter their username and password to login. It will check if the entered username and password match with the database. If yes, it will show the home page activity. If not, it will show an error and ask to enter again. Users can press "forgot password" in the case that they do not remember their password.|
|Welcome Interface|![WelcomeInterface](/uploads/4d9134ec911c7a2bc65b416fd09aa0e8/WelcomeInterface.png)|After the user logged in, the user would be directed to the home page. The top of the screen will address the username. The user would be presented with three buttons. By pressing on the “Logout” button, the current activity would be terminated. By pressing the “New Game” or “Leaderboard” button, the system would launch respective activity.|
|Gameplay Interface|![GameplayInterface](/uploads/effdf416d8e4089b387fcd78996fa334/GameplayInterface.png)|This is the gameplay screen. The user will see a game board that contains 9x9 cells that also contains 3x3 cells. By pressing the “Play” button, the system would initiate the game and start the timer.|
|Leaderboard Interface|![LeaderInterface](/uploads/64835ff5ef4e4304fb2f490b80830c05/LeaderInterface.png)|This is the leaderboard interface. It will show the top fifteen users who were able to complete the puzzle in the least amount of time. The user can return to their home screen by pressing the Home button on the top left of the screen.|
|Profile Interface|![ProfileInterface](/uploads/2e57d648b8d37b803b6918d5dbda0fad/ProfileInterface.png)|In this activity, a user can change the difficulty of the game. The levels of difficulty are Novice, Intermediate and Expert. The user can press the button of the level that they want to play game. This activity also has the mode button to switch two different modes as the user want. The user can also log out if they want to switch accounts by pressing the space where it says "log out" on the top right. |
|Popup Interface|![PopupInterface](/uploads/fc09c9e336f70074d26f162e1a0be374/PopupInterface.png)|Each cell of the 9x9 grid on the gamebord should display this popup interface when it is pressed by a user. This popup activity let the user input their answer for the word. By pressing the hint button, it will display the hint for the word. By pressing the definition button, it will display the definition of the word that is on the question. By pressing the confirm button, it will submit the answer|

## Authors

Gurjot Sandher  
Ethan Chen  
Nanako Shichinohe  





