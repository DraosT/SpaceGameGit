package com.game.src.main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.Game;
import com.game.src.main.classes.EntityA;
import com.game.src.main.gfx.Animation;
import com.game.src.main.gfx.Textures;
import com.game.src.main.intermediary.GameObject;
import com.game.src.main.logic.Physics;

public class Bullet extends GameObject implements EntityA
{
	private Textures tex;
	private Game game;
	Animation anim;
	
	public Bullet(double x, double y, Textures tex, Game game)
	{
		super(x, y);
		this.tex = tex;
		this.game = game;
		
		anim = new Animation(1, tex.missile[0], tex.missile[1], tex.missile[2]);
	}
	
	public void tick()
	{
		y -= 10;
		
		if(Physics.Collision(this, game.eb))
		{
			System.out.println("Collision Detected");
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
