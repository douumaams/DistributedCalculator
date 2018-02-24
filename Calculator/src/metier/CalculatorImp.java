package metier;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.AbstractMap.SimpleEntry;

import service.ICalculator;

public class CalculatorImp implements ICalculator
{
    String name;

    public CalculatorImp(String name)
    {
        this.name = name;
    }

    @Override
    public SimpleEntry<String, BigDecimal> computePi() throws RemoteException
    {
        BigDecimal bi = new BigDecimal(0);

        int from = 0;
        int to = 0;

        for (int i = from; i < to; i++)
        {
            bi.add(new BigDecimal(Math.pow((1 / 16), i)
                    * ((4 / (8 * i) + 1) - (2 / (8 * i) + 4) - (1 / (8 * i) + 5) - (1 / (8 * i) + 6))));
        }

        // update
        return new SimpleEntry<String, BigDecimal>(this.name, bi);
    }
}
