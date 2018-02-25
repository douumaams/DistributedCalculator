package service;

import java.math.BigDecimal;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.AbstractMap.SimpleEntry;

import metier.CalculatorImp;
import metier.WorkUnit;

public class CalculatorServer
{
    public static void main(String[] args)
    {
        try
        {
            ICalculator calculator = new CalculatorImp();
            System.out.println("Exporting the calculator " + calculator.getID());
            ICalculator stub = (ICalculator) UnicastRemoteObject.exportObject(calculator, 0);

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("calculator" + calculator.getID(), stub);

            IMiddleware middleware = (IMiddleware) Naming.lookup("middleware");

            /* Timer timer = new Timer(10000, calculator); */

            while (true) /* a remplacer par un action performed */
            {
                WorkUnit work = middleware.getWork();
                SimpleEntry<Integer, BigDecimal> result = calculator.computePi(work);
                middleware.update(result.getKey(), result.getValue());
                Thread.sleep(10000);
            }

        } catch (Exception e)
        {
            System.out.println("Exception occured " + "while computing the Pi calculus: " + "\n" + e.getMessage());
        }
    }
}
