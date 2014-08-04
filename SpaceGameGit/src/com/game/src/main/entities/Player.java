package com.game.src.main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.game.src.main.classes.EntityA;
import com.game.src.main.gfx.Animation;
import com.game.src.main.gfx.Textures;
import com.game.src.main.intermediary.GameObject;

public class Player extends GameObject implements EntityA
{
	private double velX = 0;
	private double velY = 0;
		
	private Textures tex;
	
	Animation anim;
	LinkedList<BufferedImage> img = new LinkedList<BufferedImage>();

	public Player(double x, double y, Textures tex)
	{
		super(x,y);
		
		this.tex = tex;
		
		for(int i = 0; i < 3; i++)
			img.add(tex.player[i]);
		
		anim = new Animation(5, img);
	}
	
	public void tick()
	{
		x += velX;
		y += velY;
		
		if(x <= 0)
			x = 0;
		if(x >= 640 - 18)
			x = 640 - 18;
		if(y <= 0)
			y = 0;
		if(y >= 480 - 32)
			y = 480 - 32;
		
		anim.runAnimation();
	}
	
	public void render(Graphics g)
	{
		anim.drawAnimation(g, x, y, 0);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x, (int)y, 32, 32);
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
	
	public void setVelX(double velX)
	{
		this.velX = velX;
	}
	
	public void setVelY(double velY)
	{
		this.velY = velY;
	}
}
