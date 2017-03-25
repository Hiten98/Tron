public static void checkPos() {
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard[0].length; j++) {
                if(gameBoard[i][j] == myPlayerNumber) {
                    myCurrentRow = i;
                    myCurrentColumn = j;
                }
            }
        }
    }
