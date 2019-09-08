package com.isaacarenas.main;

import java.io.*;
import java.util.*;


public class antMover {

    /*
    Your previous Plain Text content is preserved below:

    Langton's Ant is a simulation that consists of an ant moving around a grid of cells. Each cell can be either colored black or white, and the grid starts off completely white. The ant is facing one of four directions (up, down, left or right), and follows a set of rules to move based on the color of the cell it is currently on.

    1. If the ant is on a white cell, it turns 90 degrees clockwise, and moves one space forwards
    2. If the ant is on a black cell, it turns 90 degrees counterclockwise, and moves one space forwards
    3. The ant flips the color of the cell it has just left.

    An example of a possible grid evolution is detailed below, with step 0 being the initial condition.


    “#”: black cell
    “.”: white cell
    “^, v, <, >”: ant (with direction that it’s facing)

    steps:        0      1      2      3      4      5      6      7
    ant colour:   .      .      .      .      #      .      .      .

                 ....   .^..   .#>.   .##.   .##.   .##.   .##.   .##.
                 .<..   .#..   .#..   .#v.   .<#.   ..#.   ..#.   ^.#.
                 ....   ....   ....   ....   ....   .v..   <#..   ##..


    Given an input of an initial condition, and the number of steps for the ant to take, print out the state of the grid.

    (# rows, # columns, starting row and column of ant, starting direction of ant, # steps)


    Input:
    ....
    .<..
    ....
    steps=7

    Output:
    .##.
    ^.#.
    ##..
     */

        static char[] ant = {'^','>','v','<'};

        public static int rotateClk(int antIndex){
            antIndex = antIndex < 3 ? antIndex+1 : 0;
            return antIndex;

        }

        public static int rotateInClk(int antIndex){
            antIndex = antIndex > 1 ? antIndex-1 : 3;
            return antIndex;

        }

        public static void antWalker(char[][] currentMatrix, int  currPosiY , int  currPosiX , int antIndex, int steps) {
            for (int i = 0; i < steps; i++) {
                printMatrix(currentMatrix, currPosiY, currPosiX, antIndex);
                if (currentMatrix[currPosiY][currPosiX] == '.') {
                    antIndex=rotateClk(antIndex);
                } else {
                    antIndex=rotateInClk(antIndex);
                }

                currentMatrix[currPosiY][currPosiX] = currentMatrix[currPosiY][currPosiX] == '.' ? '#' : '.';

                if (ant[antIndex] == '^') {
                    currPosiY--;
                }else if (ant[antIndex] == '<') {
                    currPosiX--;
                }else if (ant[antIndex] == 'v') {
                    currPosiY++;
                }else if (ant[antIndex] == '>') {
                    currPosiX++;
                }

                System.out.println("\n");
            }


        }


    public static  void printMatrix(char[][] matrix, int  currPosiY , int  currPosiX , int antIndex){
        for (int i=0 ; i < matrix.length ; i++){
            for (int j=0 ; j < matrix[i].length ; j++){
                char printable = ((i == currPosiY) && (j== currPosiX)) ? ant[ antIndex]: matrix[i][j];
                System.out.print( printable + " ");
            }
            System.out.print("\n");
        }
    }


    public static  char[][] initMatrix(int initialY , int initialX){
        char [][] matrix = new char[initialY][initialX];
        for (int i=0 ; i < matrix.length ; i++){
            for (int j=0 ; j < matrix[i].length ; j++){
                matrix[i][j]='.';
            }
        }
        return matrix;
    }


    public static void main(String[] args) {
        int initialX =1;
        int initialY =1;
        int initialSizeY =3;
        int initialSizeX =4;
        int antIndex =3;
        int steps = 7;

        char[][] matrix = initMatrix(initialSizeY,initialSizeX);
        antWalker(matrix,initialY,initialX,antIndex,steps );


    }
}