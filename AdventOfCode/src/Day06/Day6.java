package Day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {

    public static void main(String[] args) {
        partA();
        partB();
    }

    private static void partA(){
        try{
            Scanner sc = new Scanner(new File("src/Day06/input.txt"));
            System.out.println("Part A:");

            String input = "";

            if(sc.hasNext()){
                input = sc.next();
            }

            char[] arr = new char[4];
            int marker = 0;

            while(marker + 4 < input.length()) {
                for (int i = marker; i < arr.length + marker; i++) {
                    arr[i - marker] = input.charAt(i);
                }

                if (checkForMarker(arr)) {
                    marker = marker + 4;
                    break;
                }
                //System.out.println("Current marker: " + marker);
                marker++;
            }

            System.out.println("Marker at: " + marker);

        }catch (FileNotFoundException ignored){}
    }

    private static void partB(){
        try{
            Scanner sc = new Scanner(new File("src/Day06/input.txt"));
            System.out.println("Part B:");

            String input = "";

            if(sc.hasNext()){
                input = sc.next();
            }

            char[] arr = new char[14];
            int marker = 0;

            while(marker + 14 < input.length()) {
                for (int i = marker; i < arr.length + marker; i++) {
                    arr[i - marker] = input.charAt(i);
                }

                if (checkForMarker(arr)) {
                    marker = marker + 14;
                    break;
                }
                //System.out.println("Current marker: " + marker);
                marker++;
            }

            System.out.println("Marker at: " + marker);

        }catch (FileNotFoundException ignored){}
    }

    private static boolean checkForMarker(char[] input){
        for(int i = 0; i < input.length-1; i++){
            for(int n = i+1; n < input.length; n++){
                if(input[i] == input[n]){
                    return false;
                }
            }
        }
        return true;
    }
}
