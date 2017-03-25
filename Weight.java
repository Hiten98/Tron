import java.math.MathContext;

/**
 * Created by hiten on 3/24/2017.
 */
public class Weight {
    static Integer[][] weightedBoard = new Integer[Bot.gameBoard.length][Bot.gameBoard.length];
    static int row = Bot.myCurrentRow;
    static int col = Bot.myCurrentColumn;

    public static void calculateWeigh(Integer[][] gameBoard) {
        int centreX = gameBoard.length / 2;
        int centreY = gameBoard[0].length / 2;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                int distance = (int) Math.ceil(Math.sqrt((i - centreX) * (i - centreX) + (j - centreY) * (j - centreY)));
                if (gameBoard[i][j] != 0)
                    weightedBoard[i][j] = -100000;
                else
                    weightedBoard[i][j] = 100 - distance * 5 - distancePlayer(gameBoard, i, j) * 10;
            }
        }
    }

    public static int distancePlayer(Integer[][] gameBoard, int i, int j)
    {
        int distance = 0;

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if(Bot.isInsideBoard(k,l) && gameBoard[i][j] > 0)
                {
                    distance += (int) Math.ceil(Math.sqrt((i - k) * (i - k) + (j - l) * (j - l)));
                }
            }

        }
        return distance;
    }
    //0-Up,1-down,2-left,3-right
    public static int[] calculateWeight()
    {
        int[] a = new int[4];
        calculateWeigh(Bot.gameBoard);
        a[0] = 0;
        a[1] = 0;
        a[2] = 0;
        a[3] = 0;
        //calculate a[3]
        for (int i = 0; i < 2; i++) {
            if(Bot.isInsideBoard(i+row,col))
                a[3] += weightedBoard[row+i][col];
        }

        //calculate a[0]
        for (int i = 0; i < 2; i++) {
            if(Bot.isInsideBoard(row,col+i))
                a[0] += weightedBoard[row][col+i];
        }

        //calculate a[1]
        for (int i = 0; i < 2; i++) {
            int begin = col;
            if(Bot.isInsideBoard(row,begin-i))
                a[0] += weightedBoard[row][begin-i];
        }

        //calculate a[2]
        for (int i = 0; i < 2; i++) {
            int begin = row;
            if(Bot.isInsideBoard(begin-i,col))
                a[0] += weightedBoard[begin-i][col];
        }
        return a;
    }
}
