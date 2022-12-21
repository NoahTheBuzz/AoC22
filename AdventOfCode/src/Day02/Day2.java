package Day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {

    private static final int A = 1; // (A) ROCK
    private static final int B = 2; // (B) PAPER
    private static final int C = 3; // (C) SCISSORS

    private static final int X = 1; // (A) ROCK
    private static final int Y = 2; // (B) PAPER
    private static final int Z = 3; // (C) SCISSORS

    private static final int LOSS = 0;
    private static final int DRAW = 3;
    private static final int VICTORY = 6;

    public static void main(String[] args) {
        partA();
        partB();
    }

    private static void partA(){
        try{
            Scanner sc = new Scanner(new File("src/Day02/input.txt"));

            int score = 0;

            while(sc.hasNextLine()){
                String input = sc.nextLine();
                String[] array = input.split(" ");
                if(array[0].equals("A")){
                    switch (array[1]){
                        case "X":
                            score += X;
                            score += DRAW;
                            break;
                        case "Y":
                            score += Y;
                            score += VICTORY;
                            break;
                        case "Z":
                            score += Z;
                            score += LOSS;
                            break;
                    }
                }else if(array[0].equals("B")){
                    switch (array[1]){
                        case "X":
                            score += X;
                            score += LOSS;
                            break;
                        case "Y":
                            score += Y;
                            score += DRAW;
                            break;
                        case "Z":
                            score += Z;
                            score += VICTORY;
                            break;
                    }
                }else{
                    switch (array[1]){
                        case "X":
                            score += X;
                            score += VICTORY;
                            break;
                        case "Y":
                            score += Y;
                            score += LOSS;
                            break;
                        case "Z":
                            score += Z;
                            score += DRAW;
                            break;
                    }
                }
            }

            System.out.println("----------------------");
            System.out.println("Score (part A): " + score);
            System.out.println("----------------------");

        }catch (FileNotFoundException e){

        }
    }

    private static void partB(){
        try{
            Scanner sc = new Scanner(new File("src/Day02/input.txt"));

            int score = 0;

            while(sc.hasNextLine()){
                String input = sc.nextLine();
                String[] array = input.split(" ");
                if(array[0].equals("A")){
                    switch (array[1]){
                        case "X":
                            score += C;
                            score += LOSS;
                            break;
                        case "Y":
                            score += A;
                            score += DRAW;
                            break;
                        case "Z":
                            score += B;
                            score += VICTORY;
                            break;
                    }
                }else if(array[0].equals("B")){
                    switch (array[1]){
                        case "X":
                            score += A;
                            score += LOSS;
                            break;
                        case "Y":
                            score += B;
                            score += DRAW;
                            break;
                        case "Z":
                            score += C;
                            score += VICTORY;
                            break;
                    }
                }else{
                    switch (array[1]){
                        case "X":
                            score += B;
                            score += LOSS;
                            break;
                        case "Y":
                            score += C;
                            score += DRAW;
                            break;
                        case "Z":
                            score += A;
                            score += VICTORY;
                            break;
                    }
                }
            }

            System.out.println("----------------------");
            System.out.println("Score (part B): " + score);
            System.out.println("----------------------");

        }catch (FileNotFoundException e){

        }
    }
}
