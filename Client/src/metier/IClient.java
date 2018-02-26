package metier;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClient extends Remote
{
    public void printResult(String result) throws RemoteException;
	public int getID()throws RemoteException;
}
