package Day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    private static int result1 = 0;
    private static int result2 = 0;
    private static int result3 = 0;

    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("src/Day01/input.txt"));

            int tempMax = 0;

            while(sc.hasNextLine()){
                String input = sc.nextLine();
                if(input.equals("")){
                    //System.out.println("tempMax: " + tempMax);
                    compareResults(tempMax);
                    tempMax = 0;
                }else{
                    int temp = Integer.parseInt(input);
                    tempMax += temp;
                    //System.out.println("temp: " + temp + " (res " + tempMax + ")");
                }
            }

            System.out.println("3rd highest cal: " + result1);
            System.out.println("2nd highest cal: " + result2);
            System.out.println("1st highest cal: " + result3);

            int result = result1 + result2 + result3;

            System.out.println("Max calories: " + result);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void compareResults(int value){
        System.out.println("---------------------------");
        System.out.println("Value: " + value);
        System.out.println("__________________");
        System.out.println("Res1: " + result1);
        System.out.println("Res2: " + result2);
        System.out.println("Res3: " + result3);
        System.out.println("---------------------------");

        if(result1 == 0){
            result1 = value;

        }else if(result2 == 0){
            if(value > result1){
                result2 = value;
            }else{
                result2 = result1;
                result1 = value;
            }

        }else if(result3 == 0){
            if(value > result2){
                result3 = value;
            }else{
                result3 = result2;

                if(value > result1){
                    result2 = value;
                }else{
                    result2 = result1;
                    result1 = value;
                }
            }

        }else{
            if(value > result3){
                result1 = result2;
                result2 = result3;
                result3 = value;
            }else{
                if(value > result2){
                    result1 = result2;
                    result2 = value;
                }else{
                    if(value > result1){
                        result1 = value;
                    }
                }
            }
        }
    }
}
