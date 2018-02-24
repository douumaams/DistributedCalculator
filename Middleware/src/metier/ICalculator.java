package metier;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.AbstractMap.SimpleEntry;

public interface ICalculator extends Remote
{
    public SimpleEntry<String, BigDecimal> compute(int from, int to) throws RemoteException;

}
