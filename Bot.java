import java.util.Collections;

public class Bot {

    //TODO: HERE! IMPORTANT! Input your AUTH_KEY below!
    final static String AUTH_KEY = "XNQSS1490395092222";

    static Integer[][] gameBoard;
    static int myPlayerNumber;
    static int totalPlayers;
    static int myCurrentRow;
    static int myCurrentColumn;

    public static void main(String[] args) {
        System.out.println("I am alive");
        Connection.connect();
    }

    /*===========================================
      Start writing your code here!
      ===========================================*/
    public static String makeMove() {
        if (gameBoard == null || gameBoard.length == 0 || gameBoard[0].length == 0) {
            System.out.println("Game board was messed up coming into public void makeMove()");
            return "DOWN";
        }
        int[] moves = Weight.calculateWeight(); //0-up, 1-down, 2-left, 3-right

        int dir = getMaxIndex(moves);

        if (dir == 0)
            return "UP";
        else if (dir == 1)
            return "DOWN";
        else if (dir == 2)
            return "LEFT";
        else
            return "RIGHT";
        //Return UP, DOWN, LEFT, or RIGHT to move that direction
        //Best of luck!
    }

    public static int getMaxIndex(int[] moves){
        int max = 0;

        for(int i = 1; i < moves.length; i++){
            if (moves[max] < moves[i])
                max = i;
        }

        return max;
    }

    //Small helper Method
    public static boolean isInsideBoard(int i, int j) {
        if (i > gameBoard.length || j > gameBoard.length) {
            return false;
        } else if (i < 0 || j < 0) {
            return false;
        }
        return true;
    }
}
