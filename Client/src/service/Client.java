package service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import metier.IClient;
import metier.IMiddlewareClient;

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
    public void printResult(String result)
    {
        System.out.println(result);
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
            Registry registry =  LocateRegistry.getRegistry("localhost", 1099);
            
            System.out.println("Exporting the client " + client.getID());
            IClient stub = (IClient) UnicastRemoteObject.exportObject(client, 0);
            registry.rebind("client" + client.getID(), stub);
            IMiddlewareClient middleware = (IMiddlewareClient) registry.lookup("middlewareClient");

            Scanner sc = new Scanner(System.in);
            System.out.println("Choose how many decimals you want to calculate : ");
            int choice = sc.nextInt();
            middleware.distribute(client.getID(), choice);
            System.out.println(middleware.test());
            
        } catch (Exception e)
        {
            System.err.println("Exception occured " + "while ditributing the Pi calculus: " + "\n" + e.getMessage());
        }
    }

}
