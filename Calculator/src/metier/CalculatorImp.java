package metier;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.AbstractMap.SimpleEntry;

import service.ICalculator;

public class CalculatorImp implements ICalculator
{
    private static int n = 0;
    int idCalculator;

    public CalculatorImp()
    {
        this.idCalculator = n;
        n++;
    }

    @Override
    public int getID()
    {
        return this.idCalculator;
    }

    @Override
    public SimpleEntry<Integer, BigDecimal> computePi(WorkUnit work) throws RemoteException
    {
        BigDecimal bi = new BigDecimal(0);

        int from = work.getFrom();
        int to = work.getTo();

        for (int i = from; i < to; i++)
        {
            bi.add(new BigDecimal(Math.pow((1 / 16), i)
                    * ((4 / (8 * i) + 1) - (2 / (8 * i) + 4) - (1 / (8 * i) + 5) - (1 / (8 * i) + 6))));
        }

        return new SimpleEntry<Integer, BigDecimal>(this.getID(), bi);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
