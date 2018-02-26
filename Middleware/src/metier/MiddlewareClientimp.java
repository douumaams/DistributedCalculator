package metier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.Timer;

public class MiddlewareClientimp implements IMiddlewareClient, ActionListener
{
	private MiddlewareEsclaveImp middleWareEsclave;
	private Timer timer;

	public MiddlewareClientimp(IMiddlewareEsclave middlewareEsclave)
	{
		this.middleWareEsclave = (MiddlewareEsclaveImp) middlewareEsclave;
		this.timer = new Timer(1000, this);
    	timer.start();
	}
	
	
	
	@Override
	public void distribute(int id, int n) throws RemoteException
	{
		/* les serveurs dispo demandent du travail */
		/* lorsqu'ils ont fini le calcul il font un callback sur le middleware */
		middleWareEsclave.addOperation(new OperationPI(id, n));	    	
	 }



	@Override
	public void actionPerformed(ActionEvent event)
	{
		ArrayList<OperationPI> tempList = middleWareEsclave.getOperationsFinished();
		
		if(tempList == null)
			return;
        try
		{
			Registry registry =  LocateRegistry.getRegistry("localhost", 1099);
			
			for (OperationPI operationPI : tempList)
			{		
					IClient client = (IClient) registry.lookup("client" + operationPI.getIdOperation());
					client.printResult(operationPI.toString());
			}
		} catch (RemoteException | NotBoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tempList.clear();
	}



	@Override
	public String test() throws RemoteException
	{
		return "C'est bon !";
	}

}
