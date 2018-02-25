package metier;

import java.math.BigDecimal;
import java.rmi.RemoteException;

public class MiddlewareImp implements IMiddleware
{

    @Override
    public BigDecimal distribute(int id, int n) throws RemoteException
    {
        /* notifier les esclaves */
        /* les serveurs dispo demandent du travail */
        /* lorsqu'ils ont fini le calcul il font un callback sur le middleware */

        return null;
    }

    @Override
    public WorkUnit getWork()
    {
        // TODO Auto-generated method stub
        return null;
    }

}
