package projects;

import java.util.Scanner;

public class Project04 {

    public static void main(String[] args) {
        char[][] board = {{'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}};

        System.out.println("Θέσεις 1-9:");

        printBoard(board);
        clearBoard(board);

        while(true) {
            playerATurn(board);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
            playerBTurn(board);
            if(isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }//end while
    }//end main

    public static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }//end printGameBoard()


    public static void playerATurn(char[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1ος Παίκτης δώσε θέση 1-9: ");
        String pos = scanner.nextLine();
        //scanner.close();
        while(true) {
            if (isValidMove(board, pos)) {
                break;
            }
            else {
                System.out.println("2ος Παίχτης δώσε θέση 1-9: ");
                pos = scanner.nextLine();
            }

        }//end while
        placeMove(board,pos,'X');
    }//end playerATurn()

    public static void playerBTurn(char[][] board) {
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("2ος Παίχτης δώσε θέση 1-9: ");
        String pos = scanner2.nextLine();
        while(true) {
            if (isValidMove(board, pos)) {
                break;
            }
            else {
                System.out.println("2ος Παίχτης δώσε θέση 1-9: ");
                pos = scanner2.nextLine();
            }

        }//end while
        placeMove(board,pos,'O');
    }//end playerBTurn()



    public static void clearBoard(char[][] board) {
        //Clears the board after instructions
        for(int i=0; i<board.length;i++) {
            for(int j=0; j<board.length;j++){
                board[i][j]= ' ';
            }
        }
    }//end clearBoard()

    public static boolean isValidMove(char[][] board, String position) {
        switch (position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }//end switch
    }//end isdValidMove()

    public static void placeMove(char[][] board, String pos, char player) {
        switch (pos) {
            case "1":
                board[0][0] = player;
                break;
            case "2":
                board[0][1] = player;
                break;
            case "3":
                board[0][2] = player;
                break;
            case "4":
                board[1][0] = player;
                break;
            case "5":
                board[1][1] = player;
                break;
            case "6":
                board[1][2] = player;
                break;
            case "7":
                board[2][0] = player;
                break;
            case "8":
                board[2][1] = player;
                break;
            case "9":
                board[2][2] = player;
                break;
            default:
                System.out.println(":(");
        }//end switch
    }//end placeMove()

    public static boolean isGameFinished(char[][] board) {

        if ((board[0][0] == 'X' && board[0][1] == 'X' && board [0][2] =='X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board [1][2] =='X') ||
                (board[2][0] == 'X' && board[2][1] == 'X' && board [2][2] =='X') ||

                (board[0][0] == 'X' && board[1][1] == 'X' && board [2][0] =='X') ||
                (board[0][1] == 'X' && board[1][1] == 'X' && board [2][1] =='X') ||
                (board[0][2] == 'X' && board[1][2] == 'X' && board [2][2] =='X') ||

                (board[0][0] == 'X' && board[1][1] == 'X' && board [2][2] =='X') ||
                (board[0][2] == 'X' && board[1][1] == 'X' && board [2][0] =='X')) {
            printBoard(board);
            System.out.println("Ο παίκτης 1 Κέρδισε!!!");
            return true;
        }
        else if ((board[0][0] == 'O' && board[0][1] == 'O' && board [0][2] =='O') ||
                (board[1][0] == 'O' && board[1][1] == 'O' && board [1][2] =='O') ||
                (board[2][0] == 'O' && board[2][1] == 'O' && board [2][2] =='O') ||

                (board[0][0] == 'O' && board[1][1] == 'O' && board [2][0] =='O') ||
                (board[0][1] == 'O' && board[1][1] == 'O' && board [2][1] =='O') ||
                (board[0][2] == 'O' && board[1][2] == 'O' && board [2][2] =='O') ||

                (board[0][0] == 'O' && board[1][1] == 'O' && board [2][2] =='O') ||
                (board[0][2] == 'O' && board[1][1] == 'O' && board [2][0] =='O')) {
            printBoard(board);
            System.out.println("Κέρδισε ο Παίκτης 2!");
            return true;
        }


        for (int i = 0; i < board.length; i++) {
            for (int j =0; j < board.length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("Ισοπαλία!");

        return true;
    }//end isGameFinished()

}
