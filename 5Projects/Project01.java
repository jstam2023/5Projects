package projects;

import java.io.File;
import java.util.Scanner;

public class Project01 {

    public static void main(String[] args)  {
        String choice = option();
        File file = new File(choice);
        int[] arr = new int[countIntsInFile(choice)];
        arr = readFileToIntArr(choice, arr);
        arr = selectionSort(arr);
        printArray(arr);
    }//end main

    public static String option() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a filename to scan or type \"exit\" and press enter to exit the program: ");
        String choice = scanner.nextLine();
        File file = new File(choice);
        if (choice.equals("exit")) {
            System.out.println("Closing the program... Finished");
            System.exit(1);
        } else if (file.exists()) {
            return choice;
        } else if (!file.exists()) {
            System.out.println("the file doesn't exist");
            choice = option();
        }
        return choice;
    }//end option()

    public static int countIntsInFile(String filename) {
        int validInts = 0;
        File file = new File(filename);
        int num;
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                num = scanner.nextInt();
                if (num >= 1 && num < 50) {
                    validInts++;
                } else {
                    System.out.println("The file contains number lower than 1 or higher than 49.");
                    System.out.println("Exiting program.");
                    System.exit(1);
                }
            }
        }catch (Exception e) {
            System.out.println("There was an error");
        }
        if (validInts > 6 && validInts < 50) {
            System.out.println("Valid Integers found in file: " + validInts);
        }
        else if (validInts <= 6) {
            System.out.println("File contains less than 7 numbers");
            System.out.println("Exiting Program");
            System.exit(1);
        } else if (validInts > 49) {
            System.out.println("File Contains more than 49 numbers.Exiting Program");
            System.exit(1);

        }
        return validInts;
    }//end countIntsInFile()

        public static int[] readFileToIntArr(String filename, int[] arr) {
                int num;
                int pos = 0;
            try {
                File file = new File(filename);
                Scanner reader = new Scanner(file);
                while (reader.hasNextInt()) {
                    num = reader.nextInt();
                    arr[pos] = num;
                    pos++;
                }
            }catch (Exception e) {
                System.out.println("Error in readToIntArr");
            }
            return arr;
        }//end readFileToIntArr()

    public static int[] createArray(int[] arr) {
        int[] sortedArr= new int[5];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    System.out.println("Duplicate found " + arr[j]);
                }else {
                    //sortedArr[i] = arr[i];
                }
            }
        }
        return sortedArr;
    }//end createArray()

    public static void printArray(int[] arr) {
        for (int i =0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }//end printArray()

    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            // Find min
            int minPosition = i;
            int minValue = arr[minPosition];

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minValue) {
                    minValue = arr[j];
                    minPosition = j;
                }
            }
            // Swap(minPos, i)
            swap(arr, minPosition, i);
        }
        return arr;
    }//end selectionSort()

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }//end swap()

    // filtering
    public static int[] getEvens(int[] arr) {
        int count = 0;
        int pivot = 0;

        for (int el : arr) {
            if (el % 2 == 0) count++;
        }

        int[] evens = new int[count];

        for (int el : arr) {
            if (el % 2 == 0)
                evens[pivot++] = el;
        }
        return evens;
    }// end getEvens()

    public static boolean moreThanTwoEvens(int[] arr) {
        int count = 0;

        for (int el : arr) {
            if (el % 2 == 0) count++;
        }

        return count > 2;
    }// end moreThanTwoEvens()

    public static boolean moreThanTwoConsecutive(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i+1] - 1 && arr[i] == arr[i+2] - 2) {
                count++;
                break;
            }
        }
        return count >= 1;
    }// end moreThanTwoConsecutive()

    public static boolean moreThanTwoWithSameEnding(int[] arr) {
        int[] endings = new int[10];
        boolean isSameEnding = false;

        for (int num : arr) {
            endings[num % 10]++;
        }
        //        for (int i = 0; i < arr.length; i++) {
//            endings[arr[i] % 10]++;
//        }

        for (int count : endings) {
            if (count >= 3) {
                isSameEnding = true;
                break;
            }
        }
        return isSameEnding;
    }//end moreThanTwoWithSameEnding()
}
