import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static final long serialVersionUID = 1L;
	static final int GAME_WIDTH = (int) screenSize.getWidth();//the width of the screen as an int.
	static final int GAME_HEIGHT = (int) screenSize.getHeight() - 25;//the height of the screen as an int
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);//to get the screen size
	static final int BALL_DIAMETER = 20;//diameter of the ball
	static final int PADDLE_WIDTH = 25;//the width of the paddle
	static final int PADDLE_HEIGHT = 100;//the height of the paddle
	Thread gameThread;//game thread
	Image image;//image
	Graphics graphics;//graphics
	Random random;//random number
	Paddle paddle1;//paddle1
	Paddle paddle2;//paddle2
	Ball ball;//the ball
	Score score;//the score


	GamePanel() //constructor
	{
		newPaddles();
		newBall();
		score = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall() //this places the ball in a random location every new game
	{
		random = new Random();
		ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), random.nextInt(GAME_HEIGHT - BALL_DIAMETER),
				BALL_DIAMETER, BALL_DIAMETER);
	}

	public void newPaddles() //creates two paddles at the middle of the screen
	{
		paddle1 = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
		paddle2 = new Paddle(GAME_WIDTH - PADDLE_WIDTH, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH,
				PADDLE_HEIGHT, 2);
	}

	public void paint(Graphics g) //the function that helps the object becomes visible
	{
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}

	public void draw(Graphics g) //makes these the objects visible
	{
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		score.draw(g);
		Toolkit.getDefaultToolkit().sync();

	}

	public void move() //moving the ball and paddles
	{
		paddle1.move();
		paddle2.move();
		ball.move();
	}

	public void checkCollision() //checking collision
	{

		// bounce ball off top & bottom window edges
		if (ball.y <= 0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}
		// bounce ball off paddles
		if (ball.intersects(paddle1)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // optional for more difficulty
			if (ball.yVelocity > 0)
				ball.yVelocity++; // optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		if (ball.intersects(paddle2)) {
			ball.xVelocity = Math.abs(ball.xVelocity);
			ball.xVelocity++; // optional for more difficulty
			if (ball.yVelocity > 0)
				ball.yVelocity++; // optional for more difficulty
			else
				ball.yVelocity--;
			ball.setXDirection(-ball.xVelocity);
			ball.setYDirection(ball.yVelocity);
		}
		// stops paddles at window edges
		if (paddle1.y <= 0)
			paddle1.y = 0;
		if (paddle1.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
			paddle1.y = GAME_HEIGHT - PADDLE_HEIGHT;
		if (paddle2.y <= 0)
			paddle2.y = 0;
		if (paddle2.y >= (GAME_HEIGHT - PADDLE_HEIGHT))
			paddle2.y = GAME_HEIGHT - PADDLE_HEIGHT;
		// give a player 1 point and creates new paddles & ball
		if (ball.x <= 0) {
			score.player2++;
			newPaddles();
			newBall();
			System.out.println("Player 2: " + score.player2);
		}
		if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
			score.player1++;
			newPaddles();
			newBall();
			System.out.println("Player 1: " + score.player1);
		}
	}

	public void run() //control the speed of the game and makes sure the ball moves
	{
		// game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 120.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while (score.player1 < 5 && score.player2 < 5) 
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if (delta >= 1) {
				move();
				checkCollision();
				repaint();
				delta--;
			}
		}
		if(score.player1 == 5)
		{
			score.player2wins = true;
		}
		else
		{
			score.player1wins = true;
		}
		EndingScreen ending = new EndingScreen();
		GameFrame gameFrame = new GameFrame();
		gameFrame.dispose();
		
	}

	public class AL extends KeyAdapter //moves the paddles
	{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}