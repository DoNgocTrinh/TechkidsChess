import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class ChessGUI implements ActionListener, KeyListener, WindowFocusListener {

    private WindowChessBoard mainChessBoard;
    private CreateAppletImage createImage;
    private JButton cmdNewGame;
    private String[] strBlackPieces = {"blackPawn.png", "blackRock.png", "blackKnight.png", "blackBishop.png", "blackQueen.png", "blackKing.png"};
    private String[] strWhitePieces = {"whitePawn.png", "whiteRock.png", "whiteKnight.png", "whiteBishop.png", "whiteQueen.png", "whiteKing.png"};
    private Color colorGreen = new Color(0x4CAF50);
    private MediaTracker mt;

    public Container createGUI(JFrame mainApp) {

        JPanel panRoot = new JPanel(new BorderLayout());
        panRoot.setOpaque(true);
        panRoot.setPreferredSize(new Dimension(500, 520));

        mainChessBoard = new WindowChessBoard();
        createImage = new CreateAppletImage();

        mainChessBoard.setSize(new Dimension(450, 450));

        cmdNewGame = new JButton("New Game");

        cmdNewGame.addActionListener(this);

        try {

            Image[] imgRed = new Image[6];
            Image[] imgBlue = new Image[6];
            mt = new MediaTracker(mainApp);

            for (int i = 0; i < 6; i++) {

                imgRed[i] = createImage.getImage(this, "images/" + strBlackPieces[i], 5000);
                imgBlue[i] = createImage.getImage(this, "images/" + strWhitePieces[i], 5000);
                mt.addImage(imgRed[i], 0);
                mt.addImage(imgBlue[i], 0);

            }

            try {
                mt.waitForID(0);
            } catch (InterruptedException e) {
            }

            mainChessBoard.setupImages(imgRed, imgBlue);

        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(null, "Unable to load images. There should be a folder called images with all the Chess pieces in it. Try downloading this programme again", "Unable to load images", JOptionPane.WARNING_MESSAGE);
            cmdNewGame.setEnabled(false);

        }

        JPanel panBottomHalf = new JPanel(new BorderLayout());

        JPanel panNewGame = new JPanel();

        panRoot.add(mainChessBoard, BorderLayout.NORTH);
        panRoot.add(panBottomHalf, BorderLayout.SOUTH);
        panBottomHalf.add(panNewGame, BorderLayout.SOUTH);
        panNewGame.add(cmdNewGame);
        panRoot.setBackground(colorGreen);
        panNewGame.setBackground(colorGreen);

        cmdNewGame.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        return panRoot;

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == cmdNewGame) {
            mainChessBoard.newGame();
        }

    }

    public void keyTyped(KeyEvent e) {

        String strBuffer = "";
        char c = e.getKeyChar();

        if (strBuffer.length() > 10 && !((c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            e.consume();
        }

    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void windowGainedFocus(WindowEvent e) {
        mainChessBoard.gotFocus();
    }

    public void windowLostFocus(WindowEvent e) {
    }

}