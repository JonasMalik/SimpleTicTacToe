import java.util.Random;
import java.util.Scanner;

/**
 * Created by jonas on 2015-09-24.
 */
public class Functions {

    static Scanner keybord = new Scanner(System.in);
    static String[][] board = { {"1","2","3"},
                                {"4","5","6"},
                                {"7","8","9"}};
    static boolean[][] checkBoard = { {false,false,false},
                                      {false,false,false},
                                      {false,false,false}};
    static int  turn = 1;
    static String player1;
    static String player2;
    static boolean win = false;
    static boolean playAgain;
    static boolean taken = false;
    static byte menuChoise;
    static int place;
    static  int places;
    static boolean checked = false;
    static int winsP1;
    static int winsP2;

    static void MainMenu(){


        System.out.print(Grafic.mainMenu);
        System.out.print("\nPlease type the number of game alternative you want to play: ");
        menuChoise = keybord.nextByte();

        switch (menuChoise){
            case 1: PlayerVsComputer();
                break;
            case 2: PlayerVsPlayer();
                break;
            case 3: Exit();
                break;
            default: System.out.println("Please try again! (only one number)");
                break;
        }
    }

    static void PlayerVsComputer(){

        System.out.print("Name player 1: ");
        player1 = keybord.next();
        player2 = "Computer";

        ClearScreen();
        System.out.println("Let the game begin!\n" + player1 + "  VS  " + player2);
        PlaceTheMark();
    }

    static void PlayerVsPlayer(){

        System.out.print("Name player 1: ");
        player1 = keybord.next();
        System.out.print("Name player 2: ");
        player2 = keybord.next();

        ClearScreen();
        System.out.println("Let the game begin!\n" + player1 + "  VS  " + player2);
        PlaceTheMark();

    }


    static void Exit(){

        int i = 0;

        ClearScreen();
        System.out.println("Thanks for playing!\nCreated by Jonas Malik");

        while (i != 2){
            System.out.println("\n");
            i++;
        }
    }
    static void WhoseTurn() {

        int whoIsIt;
        int arrayRow;
        int arrayColum;
        Random rand = new Random();
        int cpInput = rand.nextInt(9)+1;
        String circkleOrCross;

        whoIsIt = turn % 2;
        turn = turn + 1;

        if (menuChoise == 1){
            if (whoIsIt == 0){
                place = cpInput;
            }
            else{
                System.out.print("type the number you want to place your mark on: ");
                place = keybord.nextInt();
            }
        }
        else if (menuChoise == 2){
                 if (whoIsIt == 1){
                     System.out.print(player1+" type the number you want to place your mark on: ");
                     place = keybord.nextInt();
                    }
            else {
                     System.out.print(player2+" type the number you want to place your mark on: ");
                     place = keybord.nextInt();
                 }
        }
        CheckIfTaken();



        if (whoIsIt == 0){
            circkleOrCross = "X";
        }
        else {
            circkleOrCross = "O";
        }

        if (place <= 3) {
            arrayRow = 0;
            arrayColum = place - 1;
            board[arrayRow][arrayColum] = circkleOrCross;

            System.out.println(board[arrayRow][arrayColum]);
            checkBoard[arrayRow][arrayColum] = true;
        } else if (place <= 6) {
            arrayRow = 1;
            arrayColum = place - 4;
            board[arrayRow][arrayColum] = circkleOrCross;

            System.out.println(board[arrayRow][arrayColum]);
            checkBoard[arrayRow][arrayColum] = true;
        } else if (place <= 9) {
            arrayRow = 2;
            arrayColum = place - 7;
            board[arrayRow][arrayColum] = circkleOrCross;

            System.out.println(board[arrayRow][arrayColum]);
            checkBoard[arrayRow][arrayColum] = true;
        }

    }
    static void ClearScreen(){

        int i = 0;

        while (i != 50){
            System.out.println("\n");
            i++;
        }
    }

    static void PlaceTheMark(){

        while ( win == false) {
            ClearScreen();

            System.out.print("+---+---+---+\n" +
                    "| " + Functions.board[0][0] + " | " + Functions.board[0][1] + " | " + Functions.board[0][2] + " |\n" +
                    "+---+---+---+\n" +
                    "| " + Functions.board[1][0] + " | " + Functions.board[1][1] + " | " + Functions.board[1][2] + " |\n" +
                    "+---+---+---+\n" +
                    "| " + Functions.board[2][0] + " | " + Functions.board[2][1] + " | " + Functions.board[2][2] + " |\n" +
                    "+---+---+---+\n");
            WhoseTurn();
            ClearScreen();
            CheckIfWin();
        }

    }

    static void PlayAgain(){
        String yesOrNo;
        System.out.println("PLAY AGAIN ? \nY/N");
        yesOrNo = keybord.next();


        if (yesOrNo.equals("y")){
            Reset();
            PlaceTheMark();

        }
        if (yesOrNo.equals("n")){
            Exit();
        }

    }
    static void CheckIfWin(){

        if (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O") ||
                board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O") ||
                board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O") ||
                board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O") ||
                board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O") ||
                board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O") ||
                board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O") ||
                board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")){
            System.out.println(player1+" WIN!");
            winsP1++;
            System.out.println("\n\nSCORE\n"+player1+" WINS: "+winsP1+"\n"+player2+" WINS: "+winsP2);
            PlayAgain();
            win = true;
        }
        else if (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X") ||
                board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X") ||
                board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X") ||
                board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X") ||
                board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X") ||
                board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X") ||
                board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X") ||
                board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")){
            System.out.println(player2+" WIN!");
            winsP2++;
            System.out.println("\n\nSCORE\n"+player1+" WINS: "+winsP1+"\n"+player2+" WINS: "+winsP2);
            PlayAgain();
            win = true;
        }
        else if (places == 8){
            System.out.println("TIE!");
            PlayAgain();
            win = true;
        }
        if (places<9){
            places++;
        }

    }

    static void CheckIfTaken() {

        if (place == 1 && checkBoard[0][0] == true) {
            System.out.println("Alredy taken, please try again!");
            turn = turn - 1;
            WhoseTurn();
        }
        else if (place == 2 && checkBoard[0][1] == true) {
            System.out.println("Alredy taken, please try again!");
            turn = turn - 1;
            WhoseTurn();
        }
        else if (place == 3 && checkBoard[0][2] == true) {
            System.out.println("Alredy taken, please try again!");
            turn = turn - 1;
            WhoseTurn();
        }
        else if (place == 4 && checkBoard[1][0] == true) {
            turn = turn - 1;
            WhoseTurn();
        }
        else if (place == 5 && checkBoard[1][1] == true) {
            System.out.println("Alredy taken, please try again!");
            turn = turn - 1;
            WhoseTurn();
        }
        else if (place == 6 && checkBoard[1][2] == true) {
            System.out.println("Alredy taken, please try again!");
            turn = turn - 1;
            WhoseTurn();
        }
        else if (place == 7 && checkBoard[2][0] == true) {
            System.out.println("Alredy taken, please try again!");
            turn = turn - 1;

            WhoseTurn();
        }
        else if (place == 8 && checkBoard[2][1] == true) {
            System.out.println("Alredy taken, please try again!");
            turn = turn - 1;
            WhoseTurn();
        }
        else if (place == 9 && checkBoard[2][2] == true) {
            System.out.println("Alredy taken, please try again!");
            turn = turn - 1;
            WhoseTurn();
        }




    }
    static void Reset(){
        int b = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                b++;
                board[i][j] = Integer.toString(b);
            }
        }
        for(int i = 0; i < checkBoard.length; i++) {
            for(int j = 0; j < checkBoard[i].length; j++) {
                b++;
                checkBoard[i][j] = false;
            }
        }
        places = 0;

    }
}
