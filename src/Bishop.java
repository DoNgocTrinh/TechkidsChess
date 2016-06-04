public class Bishop extends ChessPiece {

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
        this.finalDesRow = desRow;
        this.finalDesColumn = desColumn;
        return this.axisMove(startRow, startColumn, desRow, desColumn, playerMatrix, false);
    }

}