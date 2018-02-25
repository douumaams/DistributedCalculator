package metier;

import java.math.BigDecimal;

public class OperationPI
{
	private static final int STEP = 1000;
	private int idOperation;
	private int begin;
	private int end;
	private BigDecimal result;
	
	public OperationPI(int idOperation, int end)
	{
		this.idOperation = idOperation;
		this.end = end;
		this.begin = 0;
		this.result = new BigDecimal(0);
	}
	
	public void update(BigDecimal bd)
	{
		this.result.add(bd);
	}
	
	public WorkUnit getWork()
	{
		if(begin < end && begin + STEP <= end)
		{
			begin = begin + STEP;
		}else if( begin < end && begin + STEP > end )
		{
			begin = end;
		}
		return new WorkUnit(idOperation ,begin, begin + STEP);
	}
	
	public boolean finished()
	{
		return begin == end;
	}
	
	public BigDecimal getResult()
	{
		return result;
	}
	
	public int getIdOperation()
	{
		return idOperation;
	}
		
}
