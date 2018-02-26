package service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import metier.CalculatorImp;
import metier.IMiddlewareEsclave;

public class CalculatorServer
{
    public static void main(String[] args)
    {
        try
        {
        	 Scanner sc = new Scanner(System.in);
        	 System.out.println("Configuration of the calculator");
        	 System.out.println("Enter the calculator name : ");
             String name = sc.nextLine();
            
        	 
            Registry registry = LocateRegistry.getRegistry(1099);
            IMiddlewareEsclave middleware = (IMiddlewareEsclave) registry.lookup("middlewareEsclave");
            CalculatorImp calculator = new CalculatorImp(name ,middleware, 1000);
            calculator.start();
            
            System.out.println("Calculator "+ name +" is connecting...");
            System.out.println("Connected");
            while(true);

        } catch (Exception e)
        {
            System.out.println("Exception occured " + "while computing the Pi calculus: " + "\n" + e.getMessage());
        }
    }
}
