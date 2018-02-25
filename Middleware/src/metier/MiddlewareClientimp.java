package metier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
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
	public void actionPerformed(ActionEvent e)
	{
		ArrayList<OperationPI> tempList = middleWareEsclave.getOperationsFinished();
		
		if(tempList == null)
			return;
		
		for (OperationPI operationPI : tempList)
		{
			 try
			{
				IClient client = (IClient) Naming.lookup("client" + operationPI.getIdOperation());
				client.printResult(operationPI.getResult());
			} catch (MalformedURLException | RemoteException | NotBoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		tempList.clear();
	}



	@Override
	public String test() throws RemoteException
	{
		return "C'est bon !";
	}

}
