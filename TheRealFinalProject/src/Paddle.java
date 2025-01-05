import java.awt.*;
import java.awt.event.*;
//this is the class for the two paddles
public class Paddle extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;//id for box 1 or box 2 
	int yVelocity;//velocity of the paddle
	int speed = 10;//paddle

	Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) //constructor
	{
		super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		this.id = id;
	}

	public void keyPressed(KeyEvent e) {
		switch (id) {
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W)//if w is pressed move up
			{
				setYDirection(-speed);
			}
			if (e.getKeyCode() == KeyEvent.VK_S)//if s is pressed move down
			{
				setYDirection(speed);
			}
			break;
		case 2:
			if (e.getKeyCode() == KeyEvent.VK_UP)//if arrow up pressed then move up 
				{
				setYDirection(-speed);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN)//if arrow down pressed then move down 
				{
				setYDirection(speed);
			}
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (id) {
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W)//the same but when key is released instead
				{
				setYDirection(0);
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				setYDirection(0);
			}
			break;
		case 2:
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(0);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(0);
			}
			break;
		}
	}

	public void setYDirection(int yDirection) //set direction
	{
		yVelocity = yDirection;
	}

	public void move() //moving
	{
		y = y + yVelocity;
	}

	public void draw(Graphics g) //drawing the two boxes into existence
	{
		if (id == 1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}
}