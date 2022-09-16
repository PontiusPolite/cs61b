# Overview

How to connect rooms?
- Rooms are stored in a disjoint set. Just check if connected or not.
- Every room needs to belong to the same set. 

When we do enemy pathfinding, we can then use an adjacency graph of every tile?  


# Classes and Data Structures

## Main
The entry point for our program. Main will read any command line arguments (if applicable), create an instance of the game `Engine` and call the relevant `Engine` methods to create the world / play the game.

### Fields
This class has no fields or associated state, it reads arguments and passes them to the `Engine` for execution. 

## Engine
The core execution class of the program, instantiated and called on by the `Main` class. The `Engine` reads inputs using the relevant `InputSource` and interacts with the `World` according to those inputs. This class is also responsible for setting up persistence, reading/saving `World` instances, and providing feedback to the player.

## Input Source

## StringInputSource
This class provides a means of processing string inputs by iterating through each character. 
### Fields
1. `private int index` the index of the next character to be examined
2. `private String input` the input string

## Position
Describes an (x,y) coordinate in the game world. 
###Fields
1. `public int x` the x coordinate
2. `public int y` the y coordinate

## World
This class maintains the state of the game world. The tiles of the game world are structured in a 2D array of `WorldTile`s. `World` is serializable into a save file. 

## WorldTile
This class ties a `Position` to a `TETile`. All `Structure` implementations consist of an array of `WorldTile`s, thus we can examine tile location data within these `Structure`s.

## Structure
An interface for any kind of structure (rooms and halls, for now). A `Structure` requires a `generate()` method for creating it. 



## Room

## RectangleRoom

## CircleRoom

## Hall

# Algorithms


# Persistence



