package metier;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMiddlewareEsclave extends Remote
{
	public WorkUnit getWork() throws RemoteException;
	public void update(WorkUnit work, int id, BigDecimal res) throws RemoteException;
	public String test2() throws RemoteException;
}
