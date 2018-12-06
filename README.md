************************************

Assignment 8: Pirate Chess

By Mason Daniel

Completed 10/26/2018

************************************

This game is like chess, but the pieces have different properties than regular chess.


**Files used**
  
-BackgroundSquare.java
-BoardLocation.java
-BoardSquare.java
-CandidateSquare.java
-CirclePiece.java
	This class is the equivalent of the LongeRangePiece class, but for the pieces Pirate, Island, and Treasure. The difference in this class is that insted of creating a candidate path that goes until a blocking piece is found, it instead only creates a cnadidate path one location away (because of the Pirate piece only being able to move one space). 
-DrawableObject.java
-GamePiece.java
-Island.java
	This is one of the pieces that extends from the CirclePiece class. The island cannot move, cannot capture other pieces, and cannot be captured by other pieces. 
-LongRangePiece.java
-NeutralPirateShip.java
	The NeutralPirateShip class extends the PirateShip class. It can move up, down, left, or right, it cannot caputre other pieces, and it cannot be captured by other pieces.
-Parrot.java
	The Parrot class extends the LongRangePiece class. It can move diagonally, capture other pieces, and be captured by other pieces.
-Pirate.java
	The Pirate class extends the CirclePiece class. It can move in any direction (only once), 	can capture other pieces, and can be captured by other pieces.
-PirateChess.java
-PirateChessGame.java
	This class contains most of the base rules of the game. The first part implemented was placing all of the pieces on the board. Additionally, lists take in possible candidate locations for the piece and highlight them, and the un-highlights them whenever the piece has been moved.
-PirateShip.java	
	The PirateShip class extends LongRangePiece. It can move up, down, left and right, can capture other pieces, and can be captured by other pieces.
-README.md	
-SelectSquare.java	
-SquareObject.java	
-Treasure.java
	The Treasure class extends the CirclePiece class. It cannot move, cannot capture other pieces, but canbe captured by other pieces.
-acm.jar
	This is a library that contains many of the classes referenced, such as Graphics, gui, and util.


 
I received help from the following URLs:

For instanceof keyword:
*https://www.geeksforgeeks.org/java-instanceof-and-its-applications/*

Dr. Anthony provided the following files as starter code:
BackgroundSqaure.java
BoardLocation.java
BoardSquare.java
DrawableObject.java
GamePiece.java
LongRangePiece.java
PirateChess.java
PirateChessGame.java*
PirateShip.java*
SelectSquare.java
SquareObject.java

*PirateChessGame.java had starter code provided by Dr. Anthony; code implemented by me included initializing all pieces to the board in correct positions, highlighting and unhighlighting potential move paths for pieces, and checking if the game is over.
*PirateShip.java had starter code provided by Dr. Anthony; her code included al of the method headers, I implemented the body of each method.

The following files were added by me, inspired from Dr. Anthony's existing files but altered to correspond with each piece's properties:
CandidateSquare.java
CirclePiece.java
Island.java
NeutralPirateShip.java
Parrot.java
Pirate.java
Treasure.java
