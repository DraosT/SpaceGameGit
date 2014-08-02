package com.game.src.main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.src.main.Game;
import com.game.src.main.classes.EntityB;
import com.game.src.main.gfx.Animation;
import com.game.src.main.gfx.Textures;
import com.game.src.main.intermediary.GameObject;

public class Enemy extends GameObject implements EntityB
{
	Random r = new Random();
	
	private Textures tex;
	private int speed = r.nextInt(3) + 1;
	
	Animation anim;
	
	public Enemy(double x, double y, Textures tex)
	{
		super(x, y);
		this.tex = tex;
		
		anim = new Animation(5, tex.enemy[0], tex.enemy[1], tex.enemy[2]);
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
}
