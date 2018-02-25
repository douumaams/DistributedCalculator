package service;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote
{
    public void printResult(BigDecimal bd) throws RemoteException;
	public int getID()throws RemoteException;
}
