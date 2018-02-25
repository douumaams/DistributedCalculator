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
		
		
		
		
		
    
    	
    	/**
    	 * registry et company
    	 */
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
	public synchronized void update(int id, BigDecimal res) throws RemoteException
	{
		for (OperationPI operationPI : operations)
		{
			if(operationPI.getIdOperation() == id)
			{
				operationPI.update(res);
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
				returnValue.add(operationPI);
			}
		}
		operations.removeAll(returnValue);
		
		return returnValue;
	}


}
