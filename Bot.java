import java.util.Collections;

public class Bot {

    //TODO: HERE! IMPORTANT! Input your AUTH_KEY below!
    final static String AUTH_KEY = "BGEFI1490393931532";

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
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                if(gameBoard[i][j] == myPlayerNumber)
                {
                    myCurrentRow = i;
                    myCurrentColumn = j;
                }
            }
        }
        if (gameBoard == null || gameBoard.length == 0 || gameBoard[0].length == 0) {
            System.out.println("Game board was messed up coming into public void makeMove()");
            return "DOWN";
        }
        int[] moves = Weight.calculateWeight(); //0-up, 1-down, 2-left, 3-right
        int dir;
        dir = getMaxIndex(moves);
        String dirn = "";
        if (dir == 0)
            dirn = "UP";
        else if (dir == 1)
            dirn = "DOWN";
        else if (dir == 2)
            dirn = "LEFT";
        else
            dirn = "RIGHT";
        System.out.println(myCurrentColumn + "\n" + myCurrentRow + "\n" + myPlayerNumber);
        if(dirn.equals("UP") && !isInsideBoard(myCurrentRow -2,myCurrentColumn) && gameBoard[myCurrentRow-2][myCurrentColumn] != 0)
            dirn = "RIGHT";
        if(dirn.equals("DOWN")&& !isInsideBoard(myCurrentRow +2,myCurrentColumn) && gameBoard[myCurrentRow + 2][myCurrentColumn] != 0)
            dirn = "LEFT";
        if (dirn.equals("RIGHT") && !isInsideBoard(myCurrentRow,myCurrentColumn + 2) && gameBoard[myCurrentRow][myCurrentColumn + 2] != 0)
            dirn = "UP";
        if(dirn.equals("LEFT") && !isInsideBoard(myCurrentRow,myCurrentColumn - 2) && gameBoard[myCurrentRow][myCurrentColumn-2] != 0)
            dirn = "DOWN";
        System.out.println(myCurrentColumn + "\n" + myCurrentRow + "\n" + myPlayerNumber);
        if(dirn.equals("UP") && !isInsideBoard(myCurrentRow -2,myCurrentColumn) && gameBoard[myCurrentRow-2][myCurrentColumn] != 0)
            dirn = "RIGHT";
        if(dirn.equals("DOWN")&& !isInsideBoard(myCurrentRow +2,myCurrentColumn) && gameBoard[myCurrentRow + 2][myCurrentColumn] != 0)
            dirn = "LEFT";
        if (dirn.equals("RIGHT") && !isInsideBoard(myCurrentRow,myCurrentColumn + 2) && gameBoard[myCurrentRow][myCurrentColumn + 2] != 0)
            dirn = "UP";
        if(dirn.equals("LEFT") && !isInsideBoard(myCurrentRow,myCurrentColumn - 2) && gameBoard[myCurrentRow][myCurrentColumn-2] != 0)
            dirn = "DOWN";
        System.out.println(myCurrentColumn + "\n" + myCurrentRow + "\n" + myPlayerNumber);
        if(dirn.equals("UP") && !isInsideBoard(myCurrentRow -2,myCurrentColumn) && gameBoard[myCurrentRow-2][myCurrentColumn] != 0)
            dirn = "RIGHT";
        if(dirn.equals("DOWN")&& !isInsideBoard(myCurrentRow +2,myCurrentColumn) && gameBoard[myCurrentRow + 2][myCurrentColumn] != 0)
            dirn = "LEFT";
        if (dirn.equals("RIGHT") && !isInsideBoard(myCurrentRow,myCurrentColumn + 2) && gameBoard[myCurrentRow][myCurrentColumn + 2] != 0)
            dirn = "UP";
        if(dirn.equals("LEFT") && !isInsideBoard(myCurrentRow,myCurrentColumn - 2) && gameBoard[myCurrentRow][myCurrentColumn-2] != 0)
            dirn = "DOWN";
        System.out.println(myCurrentColumn + "\n" + myCurrentRow + "\n" + myPlayerNumber);
        if(dirn.equals("UP") && !isInsideBoard(myCurrentRow -2,myCurrentColumn) && gameBoard[myCurrentRow-2][myCurrentColumn] != 0)
            dirn = "RIGHT";
        if(dirn.equals("DOWN")&& !isInsideBoard(myCurrentRow +2,myCurrentColumn) && gameBoard[myCurrentRow + 2][myCurrentColumn] != 0)
            dirn = "LEFT";
        if (dirn.equals("RIGHT") && !isInsideBoard(myCurrentRow,myCurrentColumn + 2) && gameBoard[myCurrentRow][myCurrentColumn + 2] != 0)
            dirn = "UP";
        if(dirn.equals("LEFT") && !isInsideBoard(myCurrentRow,myCurrentColumn - 2) && gameBoard[myCurrentRow][myCurrentColumn-2] != 0)
            dirn = "DOWN";
        System.out.print(dirn);
        return dirn;
        //Return UP, DOWN, LEFT, or RIGHT to move that direction
        //Best of luck!
    }

    public static int getMaxIndex(int[] moves){
        int max = 0;

        for(int i = 1; i < moves.length; i++){
            if (moves[max] > moves[i])
                max = i;
        }

        return max;
    }

    //Small helper Method
    public static boolean isInsideBoard(int i, int j) {
        if (i >= gameBoard.length || j >= gameBoard.length) {
            return false;
        } else if (i < 0 || j < 0) {
            return false;
        }
        return true;
    }
}
