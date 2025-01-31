package projects;

import java.util.Scanner;

public class Project05 {
    static boolean[][] theater = new boolean[30][12];
   
    public static void main(String[] args) {
        seatChoice();
        seatChoice();
        printTheater();
    }//end main

    static void seatChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Δωστε Στήλη και σειρά:");
        String seat;
        seat = scanner.nextLine();
        isValidSeat(seat);
    }//end seatChoice()

    static void isValidSeat(String seat) {
        char column = seat.charAt(0);
        int col =charColumns(column);
        if (col > 11 || col < 0) {
            System.out.println("Όχι έγκυρη στήλη");
            seatChoice();
        }else {
            try {
                int row = Integer.parseInt(seat.substring(1));
                row=row-1;
                if (row <= 30 && row >= 0) {
                    option(column, row);

                }else {
                    System.out.println("Όχι έγκυρη θέση");
                    seatChoice();
                }
            }catch (Exception e) {
                System.out.println("Όχι έγκυρη θέση");
                seatChoice();
            }
        }
    }//end isValidSeat()

    static void option(char column, int row) {
        System.out.println("1.Κράτηση\n2.Ακύρωση\n3.Έξοδος");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            book(column,row);
            //printTheater();
        } else if (choice.equals("2")) {
            cancel(column,row);
            //printTheater();
        } else if (choice.equals("3")) {
            System.exit(0);
        }else {
            option(column, row);
        }
    }//end option()

    static void printTheater() {
        for (int i = 0; i < theater.length; i++) {
            for (int j = 0; j < theater[i].length; j++) {
                System.out.print(theater[i][j] + " ");
            }
            System.out.println();
        }
    }//end printTheater()

    static void book(char column, int row) {
        int col = charColumns(column);
        boolean isBooked = checkSeat(column, row);
        if (isBooked == false) {
            theater[row][col] = true;
            System.out.println("Seat " + column + row+1 + " was booked.");
        }else {
            System.err.println("Seat " + column + row+1 + " is already booked.");
        }
    }//end book()

    static void cancel(char column, int row) {
        boolean isBooked = checkSeat(column, row);
        int col = charColumns(column);
        if (isBooked == true) {
            theater[row][col] = false;
            System.out.println("Booking on seat " + column + row+1 + " was cancelled.");
        }else {
            System.err.println("Seat " + column + row+1 + " is not booked.");
        }
    }//end cancel()

    static boolean checkSeat(char column, int row) {
        int col = charColumns(column);
        boolean isBooked = theater[row][col];
        return isBooked;
    }//end checkSeat()

    static int charColumns(char column) {
        char[] theaterSeats = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'I', 'J', 'K', 'L', 'M'};
        int pos =-1;
        for (int i = 0; i < theaterSeats.length; i++) {
            if (column == theaterSeats[i]) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }//end charColumns()
}
