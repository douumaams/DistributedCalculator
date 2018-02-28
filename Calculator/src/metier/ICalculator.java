package metier;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.AbstractMap.SimpleEntry;

public interface ICalculator extends  ActionListener
{
    public BigDecimal computePi(WorkUnit work)throws RemoteException;

}
