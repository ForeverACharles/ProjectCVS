package cvs.character;

import java.util.*;
import java.io.*;

public class Character
{	
	private CharacterInfo charInfo;
	
	protected char Rank;
	protected int Level;
	protected int Stars;
	
	//protected Arraylist<Talent> Talents;
	//protected Equipment equipment[4] = null;
	//Impression IMPweapon = null;
	//Psyche psyche;				//psyche object implemented as circular linked list
	
	public Character(String Name, int Speed, float HP, 
					float ATK, float PhysicalDEF, float ArcaneDEF, 
					float CRITrate, float CRITdmg, char Rank)
	{
		//create CharacterInfo object from passed-in parameters
		charInfo = new CharacterInfo(Name, Speed, HP, ATK, PhysicalDEF, ArcaneDEF, CRITrate, CRITdmg);
		this.Rank = Rank;
	}
	
	public CharacterInfo getCharInfo()
	{
		return charInfo;	
	}
	
	public String toString()
	{
		return charInfo.getName();
	}
	
	public String getName()
	{
		return charInfo.getName();
	}
	
	public int getSpeed()
	{
		return charInfo.getSpeed();
	}
	
	public void setSpeed(int Speed)
	{
		if(Speed < 0)
		{
			throw new IllegalArgumentException("Speed must be Non-Negative");
		}
		charInfo.setSpeed(Speed);
	}
	
	public float getHP()
	{
		return charInfo.getHP();
	}
	
	public float getATK()
	{
		return charInfo.getATK();
	}
	
	public float getPhysicalDEF()
	{
		return charInfo.getPhysicalDEF();
	}
	
	public float getArcaneDEF()
	{
		return charInfo.getArcaneDEF();
	}
	
	public float getCRITrate()
	{
		return charInfo.getCRITrate();
	}
	
	public float getCRITdmg()
	{
		return charInfo.getCRITdmg();
	}
}
