public class Queen extends ChessPiece {
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

        boolean axis = true;

        if (startRow == desRow ^ startColumn == desColumn) //XOR If ONE of these conditions match (if both true or false then false is returned)
        {
            axis = true; //Moving straight along axis
        } else if (startRow != desRow && startColumn != desColumn) {
            axis = false; //Moving diagonal
        } else {

            strErrorMsg = "Queen can move in a straight line in any direction";
            return false;

        }

        return axisMove(startRow, startColumn, desRow, desColumn, playerMatrix, axis);

    }

}