import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	GameFrame() //the background for the game
	{
		
		GamePanel panel = new GamePanel();
		this.add(panel);//adds the background to existence
		this.setBackground(Color.black);//set background color
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setVisible(true);
	}
}