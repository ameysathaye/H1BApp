package arraylistempex;

import java.util.*;

public class ArrayListEmpEx 
{
     public static void EmpDetails() throws UserArrException
   {
       String name="";
       int maxsalary=0;
       
        ArrayList<Employee> emparr =new ArrayList<>();
        
        Employee row1 = new Employee(101,"Amey",36,10000);
        Employee row2 = new Employee(102,"Jayant",26,50000);
        Employee row3 = new Employee(103,"Piyush",24,7000);
        Employee row4 = new Employee(104,"Sachin",46,100000);
        Employee row5 = new Employee(105,"Krishna",45,150000);
        
          emparr.add(row1);
          emparr.add(row2);
	  emparr.add(row3);
          emparr.add(row4);
          emparr.add(row5);
          
         Iterator<Employee> i = emparr.iterator();
         
         System.out.println("\nEmployees list");
        
        while(i.hasNext())
        {
         System.out.println(i.next());
        }
          
          EmployeeSorter empsrt = new EmployeeSorter(emparr);
          
          ArrayList<Employee> emparr1 = empsrt.getSortedBySal();
          
          System.out.println("\n-----Sorted Employee by Salary: Descending-----");
          
          emparr1.forEach((emp2) -> {
              System.out.println(emp2);
         });       
          
        Iterator<Employee> i1 = emparr.iterator();
        
        if(i1.hasNext())
        {
         Employee e=i1.next();
         
         if(maxsalary <= e.EmpSal)
         {
            maxsalary=e.EmpSal;
            name=e.EmpName;
         }
        }
        
        System.out.println("\nEmploye name " + name + " with highest salary " + maxsalary);
          
	} 
     
    public static void main(String[] args) 
    {
        try
        {
          EmpDetails();
        }
        catch(UserArrException ee)
        {
          System.out.println(ee.getMessage());  
        }
}
}

class Employee implements Comparable<Employee>
{
  String EmpName;
  int EmpId=0,EmpAge=0,EmpSal=0;
  
 public Employee(int id,String name, int age, int sal)
 {
   this.EmpId = id;
   this.EmpName = name;
   this.EmpAge = age;
   this.EmpSal = sal;
 }
 
 @Override
 public int compareTo(Employee emp)
 {
    if(this.getSal() > emp.getSal())
    {
        return -1;
    }
    else
    {
        return 1;  
    }
 }
 
 public int getSal() 
 {         
    return EmpSal;     
  }    
 
  @Override
 public String toString() 
 {
        return "{ID is: " + EmpId + "; name is: " + EmpName + "; Age is: " + EmpAge + "; salary is: " + EmpSal + "}";
 }
 
}

class EmployeeSorter 
{     
  ArrayList<Employee> empSort = new ArrayList<>();       
  public EmployeeSorter(ArrayList<Employee> emp1) {         
    this.empSort = emp1;     
  }       
  public ArrayList<Employee> getSortedBySal()
  {         
    Collections.sort(empSort);         
    return empSort;     
  } 
} 

class UserArrException extends Exception
{
  UserArrException(String message)
  {
   super(message);
  }
}