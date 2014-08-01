package com.game.src.main;

import java.awt.Graphics;
import java.util.Random;

public class Enemy implements Entity
{
	private double x, y;
	Random r = new Random();
	
	private Textures tex;
	
	private int speed = r.nextInt(3) + 1;
	
	public Enemy(double x, double y, Textures tex)
	{
		this.x = x;
		this.y = y;
		this.tex = tex;
	}
	
	public void tick()
	{
		y+=speed;
		
		if(y > Game.HEIGHT * Game.SCALE)
		{
			speed = r.nextInt(3) + 1;
			y = -10;
			x = r.nextInt(Game.WIDTH * Game.SCALE);
		}
	}
	
	public void render(Graphics g)
	{
		g.drawImage(tex.enemy, (int)x, (int)y, null);
	}
	
	public double getX()
	{
		return x;
	}

	public void setX(double x)
	{
		this.x = x;
	}

	public double getY()
	{
		return y;
	}

	public void setY(double y)
	{
		this.y = y;
	}
}
