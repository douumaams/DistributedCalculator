package service;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.AbstractMap.SimpleEntry;

import metier.WorkUnit;

public interface ICalculator extends Remote, ActionListener
{
    public SimpleEntry<Integer, BigDecimal> computePi(WorkUnit work) throws RemoteException;

    public int getID() throws RemoteException;
}
