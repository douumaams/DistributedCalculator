package metier;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.AbstractMap.SimpleEntry;

import javax.swing.Timer;

public class CalculatorImp implements ICalculator
{
	private String name;
	private Timer timer;
	IMiddlewareEsclave middlewareEsclave;

	public CalculatorImp(String name, IMiddlewareEsclave middlewareEsclave, int delay)
	{
		this.name = name;

		this.middlewareEsclave = middlewareEsclave;
		timer = new Timer(delay, this);
	}


	@Override
	public  BigDecimal computePi(WorkUnit work) throws RemoteException
	{
		if (work == null)
			return null;
		int from = work.getFrom();
		int to = work.getTo();
		BigDecimal somme = BigDecimal.ZERO;

		for (int i = from; i < to; i++)
		{
			BigDecimal part1 = new BigDecimal(4.0 / (8 * i + 1));
			BigDecimal part2 = new BigDecimal(2.0 / (8 * i + 4));
			BigDecimal part3 = new BigDecimal(1.0 / (8 * i + 5));
			BigDecimal part4 = new BigDecimal(1.0 / (8 * i + 6));
			BigInteger part5 = BigInteger.valueOf(16).pow(i);
			part1 = part1.subtract(part2);
			part1 = part1.subtract(part3);
			part1 = part1.subtract(part4);
			part1 = part1.divide(new BigDecimal(part5));
			somme = somme.add(part1);
		}
		
		return somme;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		WorkUnit work;
		try
		{
			if ((work = middlewareEsclave.getWork()) == null) return;
			work.setServerName(name);
			middlewareEsclave.update(work, work.getId(), computePi(work));
		} catch (RemoteException e1)
		{
			e1.printStackTrace();
		}
	}

	public void start()
	{
		timer.start();
	}

	public void stop()
	{
		timer.stop();
	}

}
