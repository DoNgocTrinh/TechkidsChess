public class Pawn extends ChessPiece {

    /**
     * @param startRow      The row where the piece currently stands
     * @param startColumn   The column where the piece currently stands
     * @param desRow        The row where the piece attempt to move
     * @param desColumn     The column where the piece attempt to move
     * @param playerMatrix  The matrix represent all of player's alive pieces
     * @param currentPlayer
     * @return true if the move is possible, false if not
     */
    public boolean checkLegalMove(int startRow, int startColumn, int desRow, int desColumn, int[][] playerMatrix, int currentPlayer) {
        boolean legalMove = true;
        int[] playerPawnStart = {6, 1};

        if(desColumn == startColumn && playerMatrix[desRow][desColumn] != 0) {
            return false;
        }

        if ((currentPlayer == 1 && desRow >= startRow) || (currentPlayer == 2 && desRow <= startRow)) //If moving in wrong direction
        {
            strErrorMsg = "Can not move in that direction";
            legalMove = false;
        } else if (desColumn != startColumn) //If moving sideways
        {
            if ((desColumn > startColumn && desColumn == (startColumn + 1)) || (desColumn < startColumn && desColumn == (startColumn - 1))) //If only moving one place side ways
            {
                if ((desRow == (startRow + 1) && currentPlayer == 2) || (desRow == (startRow - 1) && currentPlayer == 1)) {
                    if (playerMatrix[desRow][desColumn] == 0) //If cell is empty
                    {
                        strErrorMsg = "Can only move diagonal when taking an enemy piece";
                        legalMove = false;
                    }
                } else {
                    strErrorMsg = "Can not move that far";
                    legalMove = false;
                }
            } else {
                strErrorMsg = "Can not move that far";
                legalMove = false;
            }
        } else if ((currentPlayer == 1 && desRow < (startRow - 1)) || (currentPlayer == 2 && desRow > (startRow + 1))) //If moved two or more places
        {
            if ((currentPlayer == 1 && desRow == (startRow - 2)) || (currentPlayer == 2 && desRow == (startRow + 2))) //If moved two places
            {
                if (playerPawnStart[currentPlayer - 1] != startRow) //If not at pawn starting place
                {
                    strErrorMsg = "Can not move that far";
                    legalMove = false;
                }
            } else {
                strErrorMsg = "Can not move that far";
                legalMove = false;
            }
        }
        if (legalMove) {
            finalDesRow = desRow;
            finalDesColumn = desColumn;
        }
        return legalMove;
    }
}