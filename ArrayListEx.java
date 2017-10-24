package arraylistex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListEx 
{
    public static void StudentDetails()
	{
	  String name,city,state,check="Yes";
          int age;
          Scanner sin = new Scanner(System.in);
          
          while(check.equalsIgnoreCase("Yes"))
                  {
	  System.out.println("Enter the Name");
          name = sin.next();

	  System.out.println("Enter the Age");
          age = sin.nextInt();

	  System.out.println("Enter the City");
          city = sin.next();

	  System.out.println("Enter the State");
          state = sin.next();

  	  ArrayList stu =new ArrayList();
          
	  stu.add(name);
	  stu.add(age);
          stu.add(city);
	  stu.add(state);

	  Iterator itr = stu.iterator();

	  while(itr.hasNext())
          {
	    System.out.println(itr.next());           
          }
          
          System.out.println("Do you wish to continue");
          check = sin.next();
                  }
	} 
    
    public static void main(String[] args) 
    {
      StudentDetails();
    }
    
}
