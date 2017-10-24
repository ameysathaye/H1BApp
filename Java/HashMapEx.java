package hashmapex;

import java.util.*;

public class HashMapEx 
{
   public static void EmployeeData()
   {
    Employee row1 = new Employee("1","Amey","35","50000");
    Employee row2= new Employee("2","Jayant","26","100000");
    Employee row3 = new Employee("3","Piyush","23","5000");
    Employee row4 = new Employee("4","Sachin","40","40000");
    Employee row5 = new Employee("5","Krishna","45","35000");
    
    HashMap<Employee,Integer> EmpDetails = new HashMap<>();
    
    EmpDetails.put(row1,1);
    EmpDetails.put(row2,2);
    EmpDetails.put(row3,3);
    EmpDetails.put(row4,4);
    EmpDetails.put(row5,5);
       
    System.out.println("\nAfter adding element");
    
    Set set = EmpDetails.entrySet();
        
        Iterator itr1 = set.iterator();

        while(itr1.hasNext())
        {
         Map.Entry amapentry = (Map.Entry)itr1.next();
         System.out.println("Key is  :"+amapentry.getKey());
         System.out.println("Value is  :"+amapentry.getValue());
        }                      

        
        
        EmpDetails.remove(row5);
        EmpDetails.remove(row4);
        
        System.out.println("\nAfter removing element");
        
        Set set1 = EmpDetails.entrySet();
        
        Iterator itr2 = set1.iterator();
        
        while(itr2.hasNext())
        {
         Map.Entry amapentry = (Map.Entry)itr2.next();
         System.out.println("Key is  :"+amapentry.getKey());
         System.out.println("Value is  :"+amapentry.getValue());
        }    
        
        
        row3.setID("31");
        
        row2.setName("Jayant K");
        
        row1.setAge("36");
        
        EmpDetails.replace(row3, 3, 100);
        
        Set set2 = EmpDetails.entrySet();
        
        Iterator itr = set2.iterator();
        
        System.out.println("\nAfter updating element");

        while(itr.hasNext())
        {
         Map.Entry mapentry = (Map.Entry)itr.next();
         System.out.println("Key is  :"+mapentry.getKey());
         System.out.println("Value is  :"+mapentry.getValue());
        }       
   }
   public static void main(String[] args) 
   {
      EmployeeData(); 
   }
    
}

class Employee
{
  String EmpId,EmpName,EmpAge,EmpSal;

 public Employee(String id,String name, String age, String sal)
 {
   this.EmpId = id;
   this.EmpName = name;
   this.EmpAge = age;
   this.EmpSal = sal;
 }
 
 public String setName(String nm)
 {
    return this.EmpName=nm; 
 }
 
 public String setID(String empid)
 {
    return this.EmpId=empid; 
 }
 
 public String setAge(String ag)
 {
    return this.EmpAge=ag; 
 }
 
 public String setSalary(String s)
 {
    return this.EmpSal=s; 
 }
 
  @Override
 public String toString() 
 {
        return "{ID is: " + EmpId + "; name is: " + EmpName + "; Age is: " + EmpAge + "; salary is: " + EmpSal + "}";
 }
}