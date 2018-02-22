package metier;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.AbstractMap.SimpleEntry;

import service.ICalculator;

public class CalculatorImp implements ICalculator
{

    @Override
    public SimpleEntry<String, BigDecimal> compute(int from, int to) throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

}
