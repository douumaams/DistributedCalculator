package metier;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class OperationPI
{
	private static final int STEP = 100;
	private int idOperation;
	private int begin;
	private int end;
	private BigDecimal result;
	private ArrayList<WorkUnit> workUnits;
	public OperationPI(int idOperation, int end)
	{
		this.idOperation = idOperation;
		this.end = end;
		this.begin = 0;
		this.result = BigDecimal.ZERO;
		this.workUnits = new ArrayList<>();
	}
	
	public void update(WorkUnit work, BigDecimal bd)
	{
		this.result = this.result.add(bd);
		this.workUnits.add(work);
	}
	
	public WorkUnit getWork()
	{
		if(begin < end && begin + STEP <= end)
		{
			begin = begin + STEP;
		}else if( begin <= end && begin + STEP > end )
		{
			int tmp = begin;
			begin = end;
			return new WorkUnit(idOperation ,tmp , end);
		}
		System.out.println("(MiddleWare)from: "+begin+" to:"+ (begin + STEP));
		return new WorkUnit(idOperation ,begin - STEP, begin);
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

	public void prepare()
	{
		BigDecimal nbd = new BigDecimal(10.0).pow(end);
		result = result.multiply(nbd);
		BigInteger tempSomme = result.toBigInteger();
		result = new BigDecimal(tempSomme).divide(nbd);
		
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[OperationPI:"+ this.idOperation +"] order: " + end+"\n");
		sb.append("The servers contributed to the calculation are: \n");
		for (WorkUnit workUnit : workUnits)
		{
			sb.append(workUnit.toString());
		}
		sb.append("The final result of the calculation: \n");
		sb.append("PI = "+this.result.toString());
		return sb.toString();
	}
		
}
