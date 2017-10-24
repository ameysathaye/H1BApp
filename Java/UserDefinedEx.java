package userdefinedex;

import java.util.*;

public class UserDefinedEx 
{
  public void checkAge() throws AgeException
  {
   Scanner sin =new Scanner(System.in);
   
   String EmployeeName;
   int EmployeeAge;
   
   System.out.println("Enter Employee Name");
   EmployeeName = sin.next();

   System.out.println("Enter Employee Age");
   EmployeeAge = sin.nextInt();

   if(EmployeeAge >=40)
   {
    throw new AgeException("Age cannot be greater than 40");
   }
 
  }  
    
  public void checkNumber() throws NumberGreaterException
  {
   Scanner sin =new Scanner(System.in);
   
   int num;
   
   System.out.println("Enter number");
   num = sin.nextInt();

   if(num > 10)
   {
    throw new NumberGreaterException("Number cannot be greater than 10");
   }
 
  }
    
  public static void main(String[] args) 
  {
      UserDefinedEx eobj = new UserDefinedEx();
   try
   {
    eobj.checkNumber();
   }
   catch(NumberGreaterException ae)
   {
    System.out.println(ae.getMessage());
   }
   
   try
   {
    eobj.checkAge();
   }
   catch(AgeException ae)
   {
    System.out.println(ae.getMessage());
   }
  }
    
}

class AgeException extends Exception
{
  AgeException(String message)
  {
   super(message);
  }
}

class NumberGreaterException extends Exception
{
  NumberGreaterException(String message)
  {
   super(message);
  }
}