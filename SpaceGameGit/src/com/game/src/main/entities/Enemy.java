package com.game.src.main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.game.src.main.Game;
import com.game.src.main.classes.EntityB;
import com.game.src.main.gfx.Animation;
import com.game.src.main.gfx.Textures;
import com.game.src.main.intermediary.Controller;
import com.game.src.main.intermediary.GameObject;
import com.game.src.main.logic.Physics;

public class Enemy extends GameObject implements EntityB
{
	Random r = new Random();
	
	private Textures tex;
	private Game game;
	private Controller c;
	private int speed = r.nextInt(3) + 1;
	Animation anim;
	LinkedList<BufferedImage> img = new LinkedList<BufferedImage>();
	
	public Enemy(double x, double y, Textures tex, Game game, Controller c)
	{
		super(x, y);
		this.tex = tex;
		this.game = game;
		this.c = c;
		
		for(int i = 0; i < tex.enemy.length; i++)
			img.add(tex.enemy[i]);
		
		anim = new Animation(5, img);
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
		
		if((Physics.Collision(this, game.ea)))
		{
			c.removeEntity(this);
			c.removeEntity(Physics.tempBullet);
			game.setEnemy_killed(game.getEnemy_killed() + 1);
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
