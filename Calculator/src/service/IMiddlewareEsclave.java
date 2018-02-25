package service;

import java.math.BigDecimal;
import java.rmi.RemoteException;

public interface IMiddlewareEsclave
{
	public WorkUnit getWork() throws RemoteException;
	public void update(int id, BigDecimal res) throws RemoteException;
}
