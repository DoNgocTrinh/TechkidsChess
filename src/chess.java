
import javax.swing.JFrame;

//Chess piece images from http://world.std.com/~wij/fixation/chess-sets.html

public class Chess extends JFrame
{
		
	public static void main(String[] args) //With applications, you have to specify a main method (not with applets)
	{
		
		JFrame.setDefaultLookAndFeelDecorated(true); //Make it look nice
        JFrame frame = new JFrame("Chess Game"); //Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ChessGUI chessWindow = new ChessGUI();
        frame.setContentPane(chessWindow.createGUI(frame));
        frame.addWindowFocusListener(chessWindow);
        
        frame.setSize(550,650);
        frame.setResizable(false);
        frame.setVisible(true);  
        frame.pack();       
        
    }	
	
}