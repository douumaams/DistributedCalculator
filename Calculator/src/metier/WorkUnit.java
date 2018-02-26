package metier;

import java.io.Serializable;

public class WorkUnit implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int from;
	private int to;
	private String serverName;
	
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
	
	public void setServerName(String serverName)
	{
		this.serverName = serverName;
	}
	
	public String getServerName()
	{
		return serverName;
	}
	
	@Override
	public String toString()
	{
		return "serverName: "+ this.serverName + " calculated from: "+ this.from +" to: "+this.to+"\n";
	}
	
}
