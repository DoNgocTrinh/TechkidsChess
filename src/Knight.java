public class Knight extends ChessPiece {
    /**
     *
     * @param startRow The row where the piece currently stands
     * @param startColumn The column where the piece currently stands
     * @param desRow The row where the piece attempt to move
     * @param desColumn The column where the piece attempt to move
     * @param playerMatrix The matrix represent all of player's alive pieces
     * @param currentPlayer
     * @return true if the move is possible, false if not
     */
    public boolean legalMove(int startRow, int startColumn, int desRow, int desColumn, int[][] playerMatrix, int currentPlayer) {

        finalDesRow = desRow;
        finalDesColumn = desColumn;
        strErrorMsg = "Horse can only move in a L shape";

        if (desRow == (startRow - 2) && desColumn == (startColumn - 1)) //2N, 1E
        {
            return true;
        } else if (desRow == (startRow - 2) && desColumn == (startColumn + 1)) //2N, 1W
        {
            return true;
        } else if (desRow == (startRow + 2) && desColumn == (startColumn - 1)) //2S, 1E
        {
            return true;
        } else if (desRow == (startRow + 2) && desColumn == (startColumn + 1)) //2S, 1W
        {
            return true;
        } else if (desRow == (startRow - 1) && desColumn == (startColumn - 2)) //1N, 2E
        {
            return true;
        } else if (desRow == (startRow - 1) && desColumn == (startColumn + 2)) //1N, 2W
        {
            return true;
        } else if (desRow == (startRow + 1) && desColumn == (startColumn - 2)) //1S, 2E
        {
            return true;
        } else if (desRow == (startRow + 1) && desColumn == (startColumn + 2)) //1S, 2W
        {
            return true;
        }

        return false;

    }

}