import java.awt.*;
import java.util.*;

public class Ball extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random random;//the random y location the ball will be spawning
	int xVelocity;//the x velocity
	int yVelocity;//the y velocity
	int initialSpeed = 5;//initial speed the ball will be moving before it speeds up

	Ball(int x, int y, int width, int height) //constructor
	{
		super(x, y, width, height);
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if (randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection * initialSpeed);

		int randomYDirection = random.nextInt(2);
		if (randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection * initialSpeed);

	}

	public void setXDirection(int randomXDirection) //this sets the x direction
	{
		xVelocity = randomXDirection;
	}

	public void setYDirection(int randomYDirection)//this sets the y direction 
	{
		yVelocity = randomYDirection;
	}

	public void move() //this moves that ball
	{
		x += xVelocity;
		y += yVelocity;
	}

	public void draw(Graphics g) //draws the ball into existence
	{
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
}