package projects;

import java.io.File;
import java.util.Scanner;

/* Program that takes a file input.
Checks if file exists
reads its content and converts it to a string.
it replaces any spaces with no spaces
and creates an int[128][2] array where the 1st position is the Ascii number of a character and
2nd position is the frequency of appearance of character in the String extracted from file.
Finally it prints the elements of the array in Ascii number order by replacing the ascii value to a char next to the frequency.
 */

public class Project03 {

    public static void main(String[] args) {
        String fileName = option();
        File file = new File(fileName);
        int[][] charArr = new int[128][2];
        String contents = readFileToString(fileName);
        createArr(charArr, contents);
        printArray(charArr);
    }//end main

    /**
     * Takes input from user and either exits the program or tests if file exists
     * If file is found it return the string value of a file that actually exists
     *
     */

    public static String option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a filename to scan or type \"exit\" and press enter to exit the program: ");
        String choice = scanner.nextLine();
        File f = new File(choice);
        if (choice.equals("exit")) {
            System.out.println("Closing the program... Finished");
            System.exit(1);
        } else if (f.exists()) {
            return choice;
        } else if (!f.exists()) {
            System.out.println("the file doesn't exist");
            choice = option();
        }
        return choice;
    }//end option()

    public static String readFileToString(String filename) {
        File file = new File(filename);
        String contents="";
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                contents += reader.nextLine();
            }
        }
        catch (Exception e) {
            System.out.println("The was a problem finding or reading from file.");
        }
        String contentsClean = contents.replace(" ","");    //Replaces the spaces with no spaces
        return contentsClean;
    }//end readFileToString()

    public static int[][] createArr(int[][] arr, String contents) {
        char character;
        int value;
        int position;
        System.out.println("Ch Fr");
        for (int i = 0; i < contents.length(); i++) {
            //arr[i][0] = i;
            character = contents.charAt(i);
            value = charToAsci(character);
            if (value<128) {
                arr[value][0]  = value;
                arr[value][1] = arr[value][1]+1;
            }
            else {
                System.out.println("File contains non latin character: " + character + " and will not be added");
            }
        }
        return arr;
    }//end createArr()

    public static void printArray(int[][] arr) {
        char character;
        int times;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] !=0) {
                //System.out.print(arr[i][j] + " ");
                character = asciToChar(arr[i][0]);
                times = arr[i][1];

                System.out.print(character + " : " + times);
            }
            if (arr[i][0] !=0) {
                System.out.println();  // Move to the next row after each row is printed
            }
        }
    }//end printArray()

    public static int charToAsci(char c) {
        char character = c;
        int asci = (int) character;
        return asci;
    }//end charToAsci()

    public static char asciToChar(int asci) {
        char intConvertion = (char) asci;
        return intConvertion;
    }//end asciToChar()
}
