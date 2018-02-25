package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMiddlewareClient extends Remote
{
    public void distribute(int id, int n) throws RemoteException;	
    public String test() throws RemoteException;

}