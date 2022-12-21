package Day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4 {

    public static void main(String[] args) {
        partA();
        partB();
    }

    private static void partA(){
        try{
            Scanner sc = new Scanner(new File("src/Day04/input.txt"));

            int result = 0;

            while(sc.hasNextLine()){
                String input = sc.nextLine();
                String[] array = input.split(",|-");

                int a1 = Integer.parseInt(array[0]);
                int a2 = Integer.parseInt(array[1]);
                int b1 = Integer.parseInt(array[2]);
                int b2 = Integer.parseInt(array[3]);

                if(a1 >= b1 && b2 >= a2){
                    result++;
                }else if(b1 >= a1 && a2 >= b2){
                    result++;
                }
            }

            System.out.println("Result: " + result);

        }catch (FileNotFoundException ignored){}
    }



    private static void partB(){
        try{
            Scanner sc = new Scanner(new File("src/Day04/input.txt"));

            int result = 0;

            while(sc.hasNextLine()){
                String input = sc.nextLine();
                String[] array = input.split(",|-");

                int a1 = Integer.parseInt(array[0]);
                int a2 = Integer.parseInt(array[1]);
                int b1 = Integer.parseInt(array[2]);
                int b2 = Integer.parseInt(array[3]);

                if(a1 >= b1 && a1 <= b2 || a2 >= b1 && a2 <= b2){
                    result++;
                }else if(b1 >= a1 && b1 <= a2 || b2 >= a1 && b2 <= a2){
                    result++;
                }
            }

            System.out.println("Result: " + result);

        }catch (FileNotFoundException ignored){}
    }
}
