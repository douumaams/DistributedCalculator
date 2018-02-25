package service;

import java.math.BigDecimal;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client implements IClient
{
    private static int n = 0;
    private int id;

    public Client()
    {
        this.id = n;
        n++;
    }

    @Override
    public void printResult(BigDecimal bd)
    {
        System.out.println(bd);
    }

    @Override
    public int getID()
    {
        return this.id;
    }

    public static void main(String[] args)
    {
        try
        {
            IClient client = new Client();
            System.out.println("Exporting the client " + client.getID());
            IClient stub = (IClient) UnicastRemoteObject.exportObject(client, 0);

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("client" + client.getID(), stub);

            IMiddleware middleware = (IMiddleware) Naming.lookup("middleware");

            Scanner sc = new Scanner(System.in);
            System.out.println("Choose how many decimals you want to calculate : ");
            int choice = sc.nextInt();
            middleware.distribute(client.getID(), choice);

        } catch (Exception e)
        {
            System.out.println("Exception occured " + "while ditributing the Pi calculus: " + "\n" + e.getMessage());
        }
    }

}
