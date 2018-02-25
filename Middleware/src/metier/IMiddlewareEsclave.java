package metier;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMiddlewareEsclave extends Remote
{
	public WorkUnit getWork() throws RemoteException;
	public void update(int id, BigDecimal res) throws RemoteException;
	
}
