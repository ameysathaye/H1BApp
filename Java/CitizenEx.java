package citizenex;

import java.io.*;
import java.util.*;

public class CitizenEx 
{
    public static void writeData() throws IOException,NullPointerException
   {
     String AadharCardNumber,Name,Gender,DateOfBirth,Address,City,Country,Pin,Phone,EducationDetails,WorkingStatus,MaritalStatus,Nodep;     
     int Age=0,Salary=0,i,rec=0;
     
      try
      { 
                System.out.println("Enter number of records to be inserted");
                Scanner sin = new Scanner(System.in);
                rec = sin.nextInt();
                String fname = "d:/assignments/mycitizen.txt";
                InputStreamReader ins = new InputStreamReader(System.in,"ISO-8859-1");
                BufferedReader inp = new BufferedReader (ins);
                FileWriter fw = new FileWriter(fname,true);
                BufferedWriter bw = new BufferedWriter(fw);

	        for(i=0;i<rec;i++)
                {
		System.out.println("Enter AadharCard Number");
		AadharCardNumber = inp.readLine();

                if((AadharCardNumber.length() > 12) || (AadharCardNumber.length() < 12))
                {
                  throw new CitizenException("Invalid Aadhar Card number");  
                }
                bw.write(AadharCardNumber+",");
                
		System.out.println("Enter Citizen name");
		Name = inp.readLine();
                
                if((Name.equals("")))
                {
                  throw new CitizenException("Invalid Citizen Name");  
                }               
                bw.write(Name+",");
                
		System.out.println("Enter Citizen Gender");
		Gender = inp.readLine();
                              
		if ((!"M".equalsIgnoreCase(Gender.substring(0,1))) && (!"F".equalsIgnoreCase(Gender.substring(0,1))))
		{
		   throw new CitizenException("Invalid Citizen Gender"); 
		}
                bw.write(Gender+",");
                
                System.out.println("Enter DateOfBirth");
		DateOfBirth=inp.readLine();
                
                if(DateOfBirth.length() > 8)
                {
                  throw new CitizenException("Invalid Birth Date");  
                }
                bw.write(DateOfBirth+",");
                
		System.out.println("Enter Citizen Address");
		Address = inp.readLine();
                bw.write(Address+",");
		
		System.out.println("Enter Citizen City");
		City = inp.readLine();
                bw.write(City+",");
			
		System.out.println("Enter Citizen Country");
		Country = inp.readLine();
                bw.write(Country+",");
		
		System.out.println("Enter Citizen Pin");
		Pin = inp.readLine();
                bw.write(Pin+",");

		System.out.println("Enter Citizen Phone");
		Phone = inp.readLine();
                if(Phone.equals(""))
                {
                 throw new CitizenException("Invalid Phone");   
                }
                bw.write(Phone+",");
		
		System.out.println("Enter Citizen Education Details");
		EducationDetails = inp.readLine();
                bw.write(EducationDetails+",");
                
                System.out.println("Enter Citizen Age");
		Age = Integer.parseInt(inp.readLine());
                bw.write(Age+",");
                
                System.out.println("Enter Citizen Working Status");
		WorkingStatus = inp.readLine();
                bw.write(WorkingStatus+",");
                
		System.out.println("Enter Citizen Marital Status");
		MaritalStatus = inp.readLine();
                bw.write(MaritalStatus+",");
                
                System.out.println("Enter Citizen Salary");
		Salary = Integer.parseInt(inp.readLine());
                bw.write(Salary+",");
                
                System.out.println("Enter Dependents for Citizen");
		Nodep = inp.readLine();
                bw.write(Nodep);
                bw.newLine();
                }
                bw.flush();
                bw.close();
     }
     catch(CitizenException ce)
     {
       System.out.println(ce.getMessage());
     }
   }
   
   public static void readData() throws IOException,NullPointerException
   {
      try
      {
          //Scanner sin = new Scanner(new File("d:/assignments/test.txt"));
          BufferedReader br = new BufferedReader(new FileReader("d:/assignments/mycitizen.txt"));
          String AadharCardNumber,Name,Gender,DateOfBirth,Address,City,Country,Pin,Phone,EducationDetails,WorkingStatus,MaritalStatus,Nodep;     
          int Age=0,Salary=0,dep=0,malecount=0,femalecount=0,totcount=0,totnotwrk=0,countmar=0,countsal=0,countpension=0,countdeps=0,countgrad=0;
          String str =null;
          String[] details;
          while((str = br.readLine()) != null)
          {
           details = str.split(",");
           AadharCardNumber = details[0];
           Name = details[1];
           Gender = details[2];
           DateOfBirth = details[3];
           Address = details[4];
           City = details[5];
           Country = details[6];
           Pin = details[7];
           Phone = details[8];
           EducationDetails = details[9];
           Age = Integer.parseInt(details[10]);
           WorkingStatus = details[11];
           MaritalStatus = details[12];
           Salary = Integer.parseInt(details[13]);
           Nodep = details[14];
           
           dep = Integer.parseInt(Nodep);
           
           if(Age > 18)
           {
             totcount+=1;
           }
           
           if((Gender.equalsIgnoreCase("Male")) && (Age > 18))
           {
             malecount+=1;
           }
           
           if((Gender.equalsIgnoreCase("Female")) && (Age > 18))
           {
             femalecount+=1;  
           }
           
           if(WorkingStatus.equalsIgnoreCase("NotWorking"))
           {
             totnotwrk+=1;
           }
           
           if((MaritalStatus.equalsIgnoreCase("Married")) && (Age > 18))
           {
             countmar+=1;
           }
           
           if(Salary > 10000)
           {
             countsal+=1;  
           }
           
           if(Age > 60)
           {
             countpension+=1;  
           }
           
           if(dep > 4)
           {
             countdeps+=1;
           }
           
           if((EducationDetails.equalsIgnoreCase("Graduate")) || (EducationDetails.equalsIgnoreCase("PostGraduate")))
           {
               countgrad+=1;
           }
         }
         System.out.print("Total citizens eligible for voting:\t"+totcount); 
         System.out.print("\nTotal male citizens eligible for voting:\t"+malecount);
         System.out.print("\nTotal female citizens eligible for voting:\t"+femalecount); 
         System.out.print("\nTotal citizens who are not working:\t"+totnotwrk);
         System.out.print("\nTotal citizens who are married:\t"+countmar);
         System.out.print("\nTotal citizens are earning more than 10000:\t"+countsal);
         System.out.print("\nTotal citizens who are eligible for pension under Senior Citizen category:\t"+countpension);
         System.out.print("\nTotal citizens having more than 4 dependents:\t"+countdeps);
         System.out.print("\nTotal citizens who are graduate:\t"+countgrad+"\n");
         br.close();    
      }
      catch(IOException ce)
      {
        System.out.println(ce.getMessage());
      }
   }
    public static void main(String[] args) throws IOException,ArrayIndexOutOfBoundsException,NullPointerException 
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

class CitizenException extends Exception
{
  CitizenException(String message)
  {
   super(message);
  }
}
