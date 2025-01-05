import java.awt.*;

public class Score extends Rectangle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int GAME_WIDTH; //the width of the game
	static int GAME_HEIGHT;//the length of the game
	int player1;//player 1
	int player2;//player 2
	boolean player1wins;
	boolean player2wins;
	
	Score(int GAME_WIDTH, int GAME_HEIGHT)//constructor
	{
		Score.GAME_WIDTH = GAME_WIDTH;
		Score.GAME_HEIGHT = GAME_HEIGHT;
	}
	public void draw(Graphics g) //set the location and size of the score "image"
	{
		g.setColor(Color.white);
		g.setFont(new Font("Consolas",Font.PLAIN,60));//set what it looks like
		
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);//draws the middle line
		
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-85, 50);//the left score
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (GAME_WIDTH/2)+20, 50);//the right score
	}
}
