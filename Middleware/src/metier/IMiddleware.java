package metier;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMiddleware extends Remote
{
    public BigDecimal distribute(int n) throws RemoteException;
}
