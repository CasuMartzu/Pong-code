import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EndingScreen extends JPanel implements ActionListener
{
	/**
	 * @return 
	 * 
	 */
	public static Score score;
	public static String whoeverwins;
	public void run()
	{
		if(score.player1wins = true)
		{
			String player1 = ("Player 1 wins");
			whoeverwins = player1;
		}
		else
		{
			String player2 = ("Player 2 wins");
			whoeverwins = player2;
		}
		System.out.println(whoeverwins);
	}
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();//the background
	JButton button = new JButton("Start");//the start button
	JButton button2 = new JButton (whoeverwins);//the title
	JButton button3 = new JButton("Exit");//the exit button
	int buttonheight = 350;//the height of the button
	int buttonwidth = 150;//the width of the button
	int title = 800;//the length of the title
	private String imagePath = "MSbackground.png";//directory to the picture
	
	public EndingScreen()
	{
		button.setBounds((GamePanel.GAME_WIDTH/2)-(buttonheight/2),300,buttonheight,buttonwidth);//set the size and where the button will be
		button.setFocusable(false);//makes sure there's not a weird box in the button
		button.addActionListener(this);//makes the button click-able
		button.setFont(new Font("Consolas",Font.PLAIN, 40));//set the font for the text in the button
		
		button2.setBounds((GamePanel.GAME_WIDTH/2)-(title/2),100,800,100);//set the size and where the button button will be
		button2.setFocusable(false);//makes sure there's not a weird box in the button
		button2.addActionListener(null);//makes the button un-clickable
		button2.setFont(new Font("Consolas",Font.PLAIN,40));//set the font for the text in the button
		
		button3.setBounds((GamePanel.GAME_WIDTH/2)-(buttonheight/2),500,buttonheight,buttonwidth);//set the size and where the button will be
		button3.setFocusable(false);//makes sure there's not a weird box in the button
		button3.addActionListener(this);//makes the button click-able
		button3.setFont(new Font("Consolas",Font.PLAIN,40));//set the font for the text in the button
		
		frame.add(button);//adds the button to existence
		frame.add(button2);//adds the button to existence
		frame.add(button3);//adds the button to existence


		frame.add(this);//makes sure everything is displayed properly
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//makes sure it closes when x is clicked
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);//makes it full screen
		frame.setVisible(true);//makes the thing visible 
	}
	public void paint(Graphics graphic)
	{
		graphic.drawImage(new ImageIcon(imagePath).getImage(), 10,10,null);//creates the background
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==button)//if button is clicked then launch the game and dispose the current intro
		{

			@SuppressWarnings("unused")
			GameFrame frame1 = new GameFrame();//launches the game
			frame.dispose();
			
		}
		//this is to close the frame, the screen, the gui
		if(e.getSource()==button3)
		{
			frame.dispose();//close the application
			
		}

	
	}
}
