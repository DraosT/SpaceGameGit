package com.game.src.main.logic;

import java.util.LinkedList;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

public class Physics
{	
	private static int num;
	
	public static boolean Collision(EntityA enta, LinkedList<EntityB> entb)
	{
		for(int i = 0; i < entb.size(); i++)
		{
			if(enta.getBounds().intersects(entb.get(i).getBounds()))
				num = i;
				return true;
		}
		
		return false;
	}
	
	public static boolean Collision(EntityB entb, LinkedList<EntityA> enta)
	{
		for(int i = 0; i < enta.size(); i++)
		{
			if(entb.getBounds().intersects(enta.get(i).getBounds()))
			{
				num = i;
				return true;
			}
		}
		
		return false;
	}
	
	public static int CollisionIndex()
	{
		return num;
	}
}
