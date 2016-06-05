public class Rook extends ChessPiece {
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
    public boolean checkLegalMove(int startRow, int startColumn, int desRow, int desColumn, int[][] playerMatrix, int currentPlayer) {

        if (startRow != desRow && startColumn != desColumn) //If moved diagonal
        {
            strErrorMsg = "Rock can only move Horiztonal or Vertical";
            return false;
        }
        //Since Queen shares the same movement as a bishop or rock, the path checking code is shared for all 3 of them
        //The boolean at the end is weather the piece is moving straight, or diagonally
        return axisMove(startRow, startColumn, desRow, desColumn, playerMatrix, true);

    }

}