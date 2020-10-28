# Tic Tac Toe Game

README file for Tic Tac Toe project.

This is the first entry point to my code. It will tell you how you can use it. 


## Table of Contents

- [Background](#background)
- [Usage](#usage)
- [Design](#design)
- [Example input](#example input)
- [Extendability](#extendability)
- [Contributor](#contributor)
- [License](#license)

## Background

My first TTT homework does not use object-oriented programming. Now this TTT HW2 is an improvement over the first job. While changing to object-oriented programming, this project simplified the main function and accurately used the private/public variables/functions. Second, this project added comments to the code to explain my coding methods. Finally, this project standardized functions and variables naming in the right way.

> This program can use different sizes of checkerboards and run seamlessly.
However, the board's scalability is not infinite, with an upper limit of 9 for both 
length and width.

> This program allows teams to play turn-based games.
Two players are allowed to play in each round. Before the game, each player 
needs to register his/her name and team number. At the end of the team
game, the system announces the list of players for each team, how many 
games each team has won, lost, and drawn.


## Usage

You can input simple lines on your command line to run the code.

```sh
javac TTTGame.java
java TTTGame
```

### Design

Class TTTPlayer is used to define the player and to record the team that the player belongs to. 

Class TTTCell is used to define the space for each of the rows and columns in the board that can be placed with a piece.

Class TTTBoard is used to define a board. It will do this by initializing the board, determining whether it is full, determining whether it is winning or losing based on the state of pieces of the board, and painting the board out at the command line.

Class TTTGame is used to control the game. It performs a series of initializations, records the player's options and updates the game's status. The only main function is in this class. The entry to the program is here.

Class GameState, Class PlayerState, and Class Seed are enums I've enumerated that record PlayerState, GameState, and pieces.

## Example input
Run the code, you can see:
```sh
Welcome to Tic Tac Toe!
We now have a more diverse chessboard:
~~~You can choose any rectangular checkerboard size (3<=length, width<=9) you like
~~~You can set up how many pieces to connect to win(must bigger than 3 and smaller than the length and width)
~~~You can play on behalf of your team as long as you enter your team number(1-9),we support 9 teams playing at the same time

Player1, please tell me your name
```
Input the name zoe;
```shell script
zoe
```

Output
```shell script
You will use piece 'O'
zoe, what is your team number(1-9)?
```

Input
```shell script
3
```

Output
```shell script
Player2, please tell me your name
```

Input
```shell script
Deb
```

Output
```shell script
You will use piece 'X'
Deb, what is your team number(1-9)?
```

Input
```shell script
7
```

Output
```shell script
who wants go first? zoe (O) or Deb (X)?
```

Input
```shell script
zoe
```

Output
```shell script
zoe(O) go first
Please input the width of board(3<=width<=9)
```

Input
```shell script
3
```

Output
```shell script
Please input the length of board(3<=length<=9)
```

Input
```shell script
4
```

Output
```shell script
+--+--+--+--+
|1 |2 |3 |4 |
+--+--+--+--+
|5 |6 |7 |8 |
+--+--+--+--+
|9 |10|11|12|
+--+--+--+--+

How many pieces do you need to connect to win?(3<=pieces<=min(length,width))


```

Input
```shell script
3
```
Output
```shell script
+--+--+--+--+
|1 |2 |3 |4 |
+--+--+--+--+
|5 |6 |7 |8 |
+--+--+--+--+
|9 |10|11|12|
+--+--+--+--+

zoe, enter your move(input the number): 
```

Input
```shell script
1
```

Output
```shell script
+--+--+--+--+
|O |2 |3 |4 |
+--+--+--+--+
|5 |6 |7 |8 |
+--+--+--+--+
|9 |10|11|12|
+--+--+--+--+

Deb, enter your move(input the number): 
```

Input
```shell script
2
```
Output
```shell script
+--+--+--+--+
|O |X |3 |4 |
+--+--+--+--+
|5 |6 |7 |8 |
+--+--+--+--+
|9 |10|11|12|
+--+--+--+--+

zoe, enter your move(input the number): 
```

Input
```shell script
6
```

Output
```shell script
+--+--+--+--+
|O |X |3 |4 |
+--+--+--+--+
|5 |O |7 |8 |
+--+--+--+--+
|9 |10|11|12|
+--+--+--+--+

Deb, enter your move(input the number): 
```

Input
```shell script
3
```
Output
```shell script
+--+--+--+--+
|O |X |X |4 |
+--+--+--+--+
|5 |O |7 |8 |
+--+--+--+--+
|9 |10|11|12|
+--+--+--+--+

zoe, enter your move(input the number): 
```

Input
```shell script
kk
```

Output
```shell script
This move is not valid. Try again
zoe, enter your move(input the number): 
```

Input
```shell script
11
```

Output
```shell script
+--+--+--+--+
|O |X |X |4 |
+--+--+--+--+
|5 |O |7 |8 |
+--+--+--+--+
|9 |10|O |12|
+--+--+--+--+

zoe won
Continue the game? (y/n)
```

Input
```shell script
n
```
Output
```shell script
Team 3 has player: 
{zoe; }
They total win: 1
They total lose: 0
Stalemate: 0

Team 7 has player: 
{Deb; }
They total win: 0
They total lose: 1
Stalemate: 0

Bye
```



## Extendability

My class design could be extend to used in other game like sudoku and Mine Sweeper with some revise.


### Contributor

U82144100

siyuzhou@bu.edu

Siyu Zhou


## License

[BU](LICENSE) © Siyu Zhou
