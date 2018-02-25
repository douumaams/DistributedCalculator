package service;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import metier.IMiddlewareClient;
import metier.IMiddlewareEsclave;
import metier.MiddlewareClientimp;
import metier.MiddlewareEsclaveImp;


public class MiddlewareServer
{
    public static void main(String[] args)
    {
    	try
		{
    		System.out.println("Server started...");

			IMiddlewareEsclave middlewareEsclave = new MiddlewareEsclaveImp();
			IMiddlewareEsclave stubEsclave = (IMiddlewareEsclave) UnicastRemoteObject.exportObject(middlewareEsclave, 0);
			
			IMiddlewareClient middlewareClient = new MiddlewareClientimp(middlewareEsclave);
			IMiddlewareClient stubClient = (IMiddlewareClient) UnicastRemoteObject.exportObject(middlewareClient, 0);
			
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("middlewareEsclave", stubEsclave);
			registry.rebind("middlewareClient", stubClient);

			System.out.println("MiddleWare Server");
		}catch(Exception e)
		{
			System.err.println("Erreur: " + e.getMessage());
		}
    }
}
