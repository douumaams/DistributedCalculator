package service;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMiddleware extends Remote
{
    public BigDecimal distribute(int id, int n) throws RemoteException;

    public WorkUnit getWork() throws RemoteException;
}
