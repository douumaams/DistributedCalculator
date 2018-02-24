package service;

import java.math.BigDecimal;

public class Client implements IClient
{
    public static void main(String[] args)
    {

    }

    @Override
    public void printResult(BigDecimal bd)
    {
        System.out.println(bd);
    }
}
