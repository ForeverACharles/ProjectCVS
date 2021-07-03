package cvs.character;

public class CharacterInfo
{
	private String Name;
	private int Speed;
	private float HP;
	private float ATK;
	private float PhysicalDEF;
	private float ArcaneDEF; 
	private float CRITrate; 
	private float CRITdmg;
	
	//constructor for CharacterInfo object
	public CharacterInfo(String Name, int Speed, float HP, 
						float ATK, float PhysicalDEF, float ArcaneDEF, 
						float CRITrate, float CRITdmg) 
	{
									
		if(Speed < 0 || HP < 0 || ATK < 0 || PhysicalDEF < 0 || ArcaneDEF < 0 || CRITrate < 0 || CRITdmg < 0)
		{
			throw new IllegalArgumentException("Invalid Character arguments");
		}
		this.Name = Name;
		this.Speed = Speed;
		this.HP = HP;
		this.ATK = ATK;
		this.PhysicalDEF = PhysicalDEF;
		this.ArcaneDEF = ArcaneDEF;
		this.CRITrate = CRITrate;
		this.CRITdmg = CRITdmg;
	}
	
	//getters and setters
	public String getName()
	{
		return Name;
	}
	
	public int getSpeed()
	{
		return Speed;
	}
	
	public void setSpeed(int Speed)
	{
		this.Speed = Speed;
	}
	
	public float getHP()
	{
		return HP;
	}
	
	public float getATK()
	{
		return ATK;
	}
	
	public float getPhysicalDEF()
	{
		return PhysicalDEF;
	}
	
	public float getArcaneDEF()
	{
		return ArcaneDEF;
	}
	
	public float getCRITrate()
	{
		return CRITrate;
	}
	
	public float getCRITdmg()
	{
		return CRITdmg;
	}
}