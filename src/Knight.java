import org.jcp.xml.dsig.internal.MacOutputStream;
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
    public boolean checkLegalMove(int startRow, int startColumn, int desRow, int desColumn, int[][] playerMatrix, int currentPlayer) {

        finalDesRow = desRow;
        finalDesColumn = desColumn;
        strErrorMsg = "Horse can only move in a L shape";
        int dr = Math.abs(startRow - desRow);
        int dc = Math.abs(startColumn - desColumn);

        return (dr == 1 && dc == 2) || (dr == 2 && dc == 1);
    }

}