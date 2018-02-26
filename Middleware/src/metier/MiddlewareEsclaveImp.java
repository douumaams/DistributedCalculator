package metier;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class MiddlewareEsclaveImp implements IMiddlewareEsclave
{
	private ArrayList<OperationPI> operations;
	public MiddlewareEsclaveImp()
	{
		operations = new ArrayList<>();
	}
	
	
	public void addOperation(OperationPI oPi)
	{
		operations.add(oPi);
	}

    @Override
	public synchronized WorkUnit getWork() throws RemoteException
	{
    	for (OperationPI operationPI : operations)
		{
			if(! operationPI.finished())
				return operationPI.getWork();
		}
    	
    	return null;
	}


	@Override
	public synchronized void update(WorkUnit work, int id, BigDecimal res) throws RemoteException
	{
		if(res == null)
			return;
		for (OperationPI operationPI : operations)
		{
			if(operationPI.getIdOperation() == id)
			{
				operationPI.update(work, res);
				break;
			}
		}
	}
    

	public ArrayList<OperationPI> getOperationsFinished()
	{
		ArrayList<OperationPI> returnValue = new ArrayList<>();;
		for (OperationPI operationPI : operations)
		{
			if(operationPI.finished())
			{
				operationPI.prepare();
				returnValue.add(operationPI);
			}
		}
		operations.removeAll(returnValue);
		
		return returnValue;
	}


	@Override
	public String test2() throws RemoteException
	{
		return "ça marche";
	}


}
