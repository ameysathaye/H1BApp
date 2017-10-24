package employeesalarybuffex;

import java.io.*;

public class EmployeeSalaryBuffEx 
{
  public static void checkSal() throws SalaryException, IOException
  {
    
   try
   {
     System.out.println("Enter salary");  
     
     BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
    int sal = Integer.parseInt(inp.readLine());

   if(sal < 0 || sal <= 10000)
   {
    throw new SalaryException("You are not eligible for Loan");
   }
   else if (sal > 10000)
   {
       System.out.println("you are eligible for Loan of 100000");
   }
   else if (sal > 50000)
   {
       System.out.println("you are eligible for Loan of 500000");
   }
   else if (sal > 100000)
   {
       System.out.println("you are eligible for Loan of 1000000");
   }
   }
   catch(SalaryException ee)
   {
    System.out.println(ee.getMessage());
   }
   catch(IOException e)
   {
    System.out.println(e.getMessage());
   }
  }
  public static void main(String[] args) throws SalaryException, IOException 
  {
    checkSal();
  }
    
}

class SalaryException extends Exception
{
  SalaryException(String message)
  {
   super(message);
  }
}