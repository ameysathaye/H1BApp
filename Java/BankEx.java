package bankex;

import java.io.*;
//import java.util.*;

public class BankEx 
{
  public static void checkDetails() throws PinException,InsufficientFundException,InvalidTransactionException,IOException
  {
    final int bal=10000; 
    BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
     
     System.out.println("Enter pin to withdraw amount");  
     int pin = Integer.parseInt(inp.readLine());
     String pinnum="";
     pinnum=Integer.toString(pin);
     int total=0;
     try
    {
        if((pinnum.length() > 4) || (pinnum.length() < 4) )
        {
          throw new PinException("Invalid Pin entered");  
        }
   System.out.println("Enter amount to withdraw");  
   int amount = Integer.parseInt(inp.readLine());
   
   if(amount > bal)
   {
    throw new InsufficientFundException("Insufficient fund in your account");
   }
    
   System.out.println("Enter Amount to be deposited");  
   int dep = Integer.parseInt(inp.readLine());   
   
   
   if(dep > 200000)
   {
     System.out.println("Enter PAN");  
     String pan = inp.readLine();  
     
     if (pan.length() < 1)
     {
      throw new InvalidTransactionException("Invalid PAN deatils");
     }
   }
   total = bal - amount + dep;
   System.out.println("Balance in account is\t"+total);
   }
   catch(InsufficientFundException | PinException | InvalidTransactionException ee)
   {
    System.out.println(ee.getMessage());
    System.exit(0);
   }
  }  
    public static void main(String[] args) throws PinException,InsufficientFundException,InvalidTransactionException,IOException 
    {
       checkDetails();
    }
    
}

class PinException extends Exception
{
  PinException(String message)
  {
   super(message);
  }
}

class InsufficientFundException extends Exception
{
  InsufficientFundException(String message)
  {
   super(message);
  }
}

class InvalidTransactionException extends Exception
{
  InvalidTransactionException(String message)
  {
   super(message);
  }
}
