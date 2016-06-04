import java.awt.*;
import java.util.Vector;

public class ChessBoard extends Canvas {

    protected PaintInstruction currentInstruction = null;
    protected Vector vecPaintInstructions = new Vector();

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {

        if (vecPaintInstructions.size() == 0) {

            g.setColor(new Color(75, 141, 221)); //Light blue
            g.fillRect(0, 0, 500, 50); //North border
            g.fillRect(0, 0, 50, 500); //West border
            g.fillRect(0, 450, 500, 50); //South border
            g.fillRect(450, 0, 50, 500); //East border

            currentInstruction = new PaintInstruction(0, 0, 8);
            vecPaintInstructions.addElement(currentInstruction);

        }

        g.setColor(new Color(75, 141, 221));
        g.fillRect(50, 450, 450, 50); //Paint over the current status text

        for (int i = 0; i < vecPaintInstructions.size(); i++) {

            currentInstruction = (PaintInstruction) vecPaintInstructions.elementAt(i);
            int startRow = currentInstruction.getStartRow();
            int startColumn = currentInstruction.getStartColumn();
            int rowCells = currentInstruction.getRowCells();
            int columnCells = currentInstruction.getColumnCells();

            for (int row = startRow; row < (startRow + rowCells); row++) {

                for (int column = startColumn; column < (startColumn + columnCells); column++) {
                    drawTile(row, column, g);
                }

            }

        }

        drawExtra(g);

    }

    private void drawTile(int row, int column, Graphics g) {

        if ((row + 1) % 2 == 0) {

            if ((column + 1) % 2 == 0) {
                g.setColor(new Color(0xf0d9b5)); //white
            } else {
                g.setColor(new Color(0xb58863)); //black
            }

        } else {

            if ((column + 1) % 2 == 0) {
                g.setColor(new Color(0xb58863));
            } else {
                g.setColor(new Color(0xf0d9b5));
            }

        }

        g.fillRect((50 + (column * 50)), (50 + (row * 50)), 50, 50);

    }

    //Protected means it can only be used by this class, and classes extending it
    protected void drawExtra(Graphics g) //Any class extending the Chess board can use this method to add extra things like player pieces
    {
    }

    protected int findWhichTileSelected(int coor) //Finds which tile the mouse is over
    {

        for (int i = 0; i < 8; i++) {

            if ((coor >= (50 + (i * 50))) && (coor <= (100 + (i * 50)))) {
                return i;
            }

        }

        return -1;

    }

}