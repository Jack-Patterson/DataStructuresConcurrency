package Lab8.Ball;//Ball without threads

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Ball implements Runnable
{  
	private JPanel panel;
	private Color color = new Color(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256));
	private final int XSIZE = 10;
	private final int YSIZE = 10;
	private int x = 0;
	private int y = 0;
	private int dx = 2;
	private int dy = 2;
	private boolean stopThread = false;
	
	public Ball(JPanel p) {
		panel = p;
	}

	public void draw(){
		Graphics g = panel.getGraphics();
		g.fillOval(x, y, XSIZE, YSIZE);
		g.dispose();
	}
	
	public void move(){
		Graphics g = panel.getGraphics();
		Color c = panel.getBackground();
		g.setColor(c);
		g.fillOval(x, y, XSIZE, YSIZE);
		
		//update ball coordinates for redrawing
		x += dx;
		y += dy;
		Dimension d = panel.getSize();
		if (x < 0){
			x = 0;
			dx = -dx;
		}
		if (x + XSIZE >= d.width){
			x = d.width - XSIZE;
			dx = -dx;
		}
		if (y < 0){
			y = 0;
			dy = -dy;
		}
		if (y + YSIZE >= d.height){
			y = d.height - YSIZE; 
			dy = -dy;
		}

		checkCollision(this);
		
		g.setColor(color);
		g.fillOval(x, y, XSIZE, YSIZE);
		g.dispose();
	}

	private void checkCollision(Ball ball){
		for (Ball b : BounceFrame.getBalls()){
			if (b == ball) return;
			if (x + XSIZE/2 <= b.x + XSIZE/2){
				x = b.x - XSIZE/2;
				dx = -dx;
			}
			if (y + YSIZE/2 <= b.y + YSIZE/2){
				y = b.y - YSIZE/2;
				dy = -dy;
			}
		}
	}
	
	public void bounce() {
		draw();
		//for (int i = 1; i <= 1000; i++){
           while (!stopThread) {
			move();
			try { Thread.sleep(5); } // makes ball run really fast as it moves every revolution of loop
			catch(InterruptedException e) {}
		}
	}

	@Override
	public void run()
	{
		bounce();
	}

	public boolean isStopThread()
	{
		return stopThread;
	}

	public void setStopThread(boolean stopThread)
	{
		this.stopThread = stopThread;
	}
}

