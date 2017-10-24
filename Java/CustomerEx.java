package customerex;

import java.io.*;
import java.util.*;

public class CustomerEx 
{
   public static void writeData() throws IOException,NullPointerException
   {
      String CustomerId,CustomerName,CustomerGender,CustomerAddress="",CustomerCity="",CustomerCountry="",CustomerPin="",CustomerPhone="",CustomerAreaofInterest="",CustomerAreaofInterest1="",CustomerAreaofInterest2="",CustomerDOB="";     
      int CustomerAge=0,i,rec=0;

      try
      {     
                System.out.println("Enter number of records to be inserted");
                Scanner sin = new Scanner(System.in);
                rec = sin.nextInt();
                String fname = "d:/assignments/mycustomer.txt";
                BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
                FileWriter fw = new FileWriter(fname,true);
                BufferedWriter bw = new BufferedWriter(fw);

	        for(i=0;i<rec;i++)
                {
		System.out.println("Enter Customer Id");
		CustomerId = inp.readLine();

                if((CustomerId.length() > 4) && (!"C".equals(CustomerId.substring(0,1))))
                {
                  throw new CustomerException("Invalid Customer Id");  
                }
                bw.write(CustomerId+",");
                
		System.out.println("Enter Customer name");
		CustomerName = inp.readLine();
                
                if((CustomerName.equals("")))
                {
                  throw new CustomerException("Invalid Customer Name");  
                }
                
                bw.write(CustomerName+",");
                
		System.out.println("Enter Customer Gender");
		CustomerGender = inp.readLine();
                              
		if ((!"M".equalsIgnoreCase(CustomerGender.substring(0,1))) && (!"F".equalsIgnoreCase(CustomerGender.substring(0,1))))
		{
		   throw new CustomerException("Invalid Customer Gender"); 
		}

                bw.write(CustomerGender+",");
                
		System.out.println("Enter Customer Age");
		CustomerAge = Integer.parseInt(inp.readLine());
                bw.write(CustomerAge+",");

		System.out.println("Enter CustomerAddress");
		CustomerAddress = inp.readLine();
                bw.write(CustomerAddress+",");
		
		System.out.println("Enter CustomerCity");
		CustomerCity = inp.readLine();
                bw.write(CustomerCity+",");
			
		System.out.println("Enter CustomerCountry");
		CustomerCountry = inp.readLine();
                bw.write(CustomerCountry+",");
		
		System.out.println("Enter CustomerPin");
		CustomerPin = inp.readLine();
                bw.write(CustomerPin+",");

		System.out.println("Enter CustomerPhone");
		CustomerPhone = inp.readLine();
                if(CustomerPhone.equals(""))
                {
                 CustomerPhone=null;   
                }
                bw.write(CustomerPhone+",");
		
		System.out.println("Enter first CustomerAreaofInterest");
		CustomerAreaofInterest1 = inp.readLine();
                
                System.out.println("Enter second CustomerAreaofInterest");
		CustomerAreaofInterest2 = inp.readLine();
                
                CustomerAreaofInterest = CustomerAreaofInterest1.concat(CustomerAreaofInterest2);
                bw.write(CustomerAreaofInterest+",");
                
		System.out.println("Enter CustomerDOB");
		CustomerDOB=inp.readLine();
                
                if(CustomerDOB.length() > 8)
                {
                  throw new CustomerException("Invalid Birth Date");  
                }
                bw.write(CustomerDOB);
                bw.newLine();
                }
                bw.flush();
                bw.close();
                }
                catch(CustomerException ce)
                {
                    System.out.println(ce.getMessage());
                }
   }
   
   public static void readData() throws IOException,NullPointerException,ArrayIndexOutOfBoundsException
   {
      try
      {
          BufferedReader br = new BufferedReader(new FileReader("d:/assignments/mycustomer.txt"));
          String Id,Name,Gender,Address,City,Country,Pin,Phone,AreaofInterest,DOB;     
          int Age=0,malecount=0,femalecount=0,countInd=0,countUS=0,countreading=0,counttrav=0,countage=0,countphone=0;
          String str =null;
          String[] details;
          while((str = br.readLine()) != null)
          {
           details = str.split(",");
           Id = details[0];
           Name = details[1];
           Gender = details[2];
           Age = Integer.parseInt(details[3]);
           Address = details[4];
           City = details[5];
           Country = details[6];
           Pin = details[7];
           Phone = details[8];
           AreaofInterest = details[9];
           DOB = details[10];
           
           if(Gender.equalsIgnoreCase("Male"))
           {
             malecount+=1;
           }
           else
           {
             femalecount+=1;  
           }
           
           if(Country.equalsIgnoreCase("India"))
           {
             countInd+=1;
           }
           else
           {
             countUS+=1;  
           }
           
           if((AreaofInterest.substring(0,7).equalsIgnoreCase("reading")) || (AreaofInterest.substring(5,AreaofInterest.length()).equalsIgnoreCase("reading")) || (AreaofInterest.substring(6,AreaofInterest.length()).equalsIgnoreCase("reading")) || (AreaofInterest.substring(7,AreaofInterest.length()).equalsIgnoreCase("reading")) ||(AreaofInterest.substring(9,AreaofInterest.length()).equalsIgnoreCase("reading")))
           {
             countreading+=1;  
           }
           
           if((AreaofInterest.substring(0,9).equalsIgnoreCase("traveling")) || (AreaofInterest.substring(7,AreaofInterest.length()).equalsIgnoreCase("traveling")) || (AreaofInterest.substring(5,AreaofInterest.length()).equalsIgnoreCase("traveling")) || (AreaofInterest.substring(6,AreaofInterest.length()).equalsIgnoreCase("traveling")))
           {
             counttrav+=1;  
           }
           
           if(Age > 18)
           {
             countage+=1;
           }
           
           if(Phone.equals("null"))
           {
               countphone+=1;
           }
         }
         System.out.print("Total male customers are:\t"+malecount);
         System.out.print("\nTotal female customers are:\t"+femalecount); 
         System.out.print("\nTotal customers from India:\t"+countInd);
         System.out.print("\nTotal customers from US:\t"+countUS);
         System.out.print("\nTotal customers who like Traveling:\t"+counttrav);
         System.out.print("\nTotal customers who like reading:\t"+countreading);
         System.out.print("\nTotal customers who are above 18:\t"+countage);
         System.out.print("\nTotal customers who do not have phone:\t"+countphone+"\n");
         br.close();    
      }
      catch(IOException ce)
      {
        System.out.println(ce.getMessage());
      }
      catch(ArrayIndexOutOfBoundsException ae)
      {
        System.out.println(ae.getMessage());
      }
      catch(NullPointerException ne)
      {
        System.out.println(ne.getMessage());
      }
   }
   
   public static void main(String[] args) throws IOException,NullPointerException,ArrayIndexOutOfBoundsException 
   {
     try
     {
      writeData();
      readData();
     }
     catch(IOException ce)
      {
        System.out.println(ce.getMessage());
      }
      catch(ArrayIndexOutOfBoundsException ae)
      {
        System.out.println(ae.getMessage());
      }
     catch(NullPointerException ne)
      {
        System.out.println(ne.getMessage());
      }
   }    
}

class CustomerException extends Exception
{
  CustomerException(String message)
  {
   super(message);
  }
}