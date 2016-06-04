
import javax.swing.JFrame;

public class Chess extends JFrame {

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true); //Make it look nice
        JFrame frame = new JFrame("Chess Game"); //Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ChessGUI chessWindow = new ChessGUI();
        frame.setContentPane(chessWindow.createGUI(frame));
        frame.addWindowFocusListener(chessWindow);

        frame.setSize(550, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();

    }

}