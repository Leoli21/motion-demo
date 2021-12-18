import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MotionFrame extends JFrame implements ActionListener
{
	private ArrayList<Ball> balls;
	
	public MotionFrame()
	{
		balls = new ArrayList<Ball>();
		setBounds(100,100,800,600);
		setTitle("Cool");
		setLayout(null);
				
		Ball ball = new Ball(500,200);
		balls.add(ball);
		add(ball);
		
		Timer t = new Timer(25,this);
		t.start();
		
		
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) 
	{
		new MotionFrame();
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		for(int i = 0; i < balls.size();i++)
		{
			Ball ball = balls.get(0);
			Ball newJawn = null;
			ball.update();
			Insets insets = this.getInsets();
			if(ball.getX() < 0)
			{
				newJawn = new Ball((int)(Math.random()*this.getWidth()), 
						(int)(Math.random()*getHeight()));
				add(newJawn);
				balls.add(newJawn);
				ball.setDx(5);
			}
			else if(ball.getX() +ball.getWidth() > this.getWidth()-insets.right - insets.left)
			{
				newJawn = new Ball((int)(Math.random()*this.getWidth()), 
						(int)(Math.random()*getHeight()));
				add(newJawn);
				balls.add(newJawn);
				ball.setDx(-5);
			}
			else if(ball.getY() < 0)
			{
				newJawn = new Ball((int)(Math.random()*this.getWidth()), 
						(int)(Math.random()*getHeight()));
				add(newJawn);
				balls.add(newJawn);
				ball.setDy(5);
			}
			else if(ball.getY() + ball.getHeight() > this.getHeight()-insets.top - insets.bottom)
			{
				newJawn = new Ball((int)(Math.random()*this.getWidth()), 
						(int)(Math.random()*getHeight()));
				add(newJawn);
				balls.add(newJawn);
				ball.setDy(-5);
			}
			
			repaint();
		}
	}

}
