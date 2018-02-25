package service;

public class WorkUnit
{
	private int id;
	private int from;
	private int to;
	
	public WorkUnit(int id,int from, int to)
	{
		this.id = id;
		this.from = from;
		this.to = to;
	}
	
	public int getTo()
	{
		return to;
	}
	
	public int getFrom()
	{
		return from;
	}
	
	public int getId()
	{
		return id;
	}
	
}
