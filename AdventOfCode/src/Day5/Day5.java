package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {

    private static List<Stack<Character>> stacks;
    private static List<String> rows;

    public static void main(String[] args) {

        reset();
        pushOntoStack();
        partA();

        System.out.println("--------------");

        reset();
        pushOntoStack();
        partB();
    }

    private static void partA(){
        try{
            Scanner sc = new Scanner(new File("src/Day5/input.txt"));

            while(sc.hasNextLine()){
                String input = sc.nextLine();

                if(input.contains("move")){
                    String[] moves = input.split(" ");
                    moveSingleUnits(Integer.parseInt(moves[1]), Integer.parseInt(moves[3])-1, Integer.parseInt(moves[5])-1);
                }
            }

            for(int k = 0; k < stacks.size(); k++){
                System.out.print("[" + k + "]: ");
                System.out.println(stacks.get(k).peek());
            }

        }catch (FileNotFoundException ignored){}
    }

    private static void partB(){
        try{
            Scanner sc = new Scanner(new File("src/Day5/input.txt"));

            while(sc.hasNextLine()){
                String input = sc.nextLine();

                if(input.contains("move")){
                    String[] moves = input.split(" ");
                    moveMultipleUnits(Integer.parseInt(moves[1]), Integer.parseInt(moves[3])-1, Integer.parseInt(moves[5])-1);
                }
            }

            for(int k = 0; k < stacks.size(); k++){
                System.out.print("[" + k + "]: ");
                System.out.println(stacks.get(k).peek());
            }

        }catch (FileNotFoundException ignored){}
    }

    private static void moveSingleUnits(int amountOfMoves, int source, int destination){
        for(int i = 0; i < amountOfMoves; i++){
            char c = stacks.get(source).pop();
            stacks.get(destination).push(c);
        }
    }

    private static void moveMultipleUnits(int amountOfMoves, int source, int destination){
        char[] arr = new char[amountOfMoves];
        for(int i = 0; i < amountOfMoves; i++){
            arr[i] = stacks.get(source).pop();
        }
        for(int i = amountOfMoves-1; i >= 0; i--){
            stacks.get(destination).push(arr[i]);
        }
    }

    private static void pushOntoStack(){
        try{
            Scanner sc = new Scanner(new File("src/Day5/input.txt"));

            while(sc.hasNextLine()){
                String input = sc.nextLine();

                if(input.contains("1")){
                    createStacks(input.replace(" ", "").length());
                    break;
                }else {
                    rows.add(input);
                }
            }

        }catch (FileNotFoundException ignored){}
    }

    private static void createStacks(int numberOfStacks){
        for(int k = 0; k < numberOfStacks; k++){
            stacks.add(new Stack<>());
        }

        for(int i = rows.size()-1; i >= 0; i--){
            //System.out.println(rows.get(i));

            String input = rows.get(i);
            for(int n = 0; n < input.length(); n++){
                for(int k = 0; k < numberOfStacks; k++){
                    if(n - 1 == k * 4 && !(input.charAt(n) == ' ')){
                        stacks.get(k).push(input.charAt(n));
                    }
                }
            }
        }

        /*for(int k = 0; k < numberOfStacks; k++){
            System.out.print("[" + k + "]: ");
            System.out.println(stacks.get(k).peek());
        }*/
    }

    private static void reset(){
        rows = new ArrayList<>();
        stacks = new ArrayList<>();
    }
}
