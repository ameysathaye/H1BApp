package empbonusex;
import java.util.*;

public class EmpBonusEx {

    public static int Bonus(int sal)
	{
          int bonus;
          if(sal == 10000)
	  {
	    bonus = ((sal*30)/100);
	    return bonus;
	  }
	  else if(sal == 50000)
	  {
	    bonus = ((sal*20)/100);
	    return bonus;	
	  }
	  else if(sal == 100000)
	  {
            bonus = ((sal*10)/100);
	    return bonus;
	  }
	  else
	  {
            return 0;
	  }
	}
    public static void main(String[] args) {
        // TODO code application logic here
                String EmpName;
		int EmpSal,total=0,bonus;
		Scanner sin=new Scanner(System.in);
	
		
		for(int i=0;i<10;i++)
		{
			System.out.println("Enter the Employee Name");
			EmpName = sin.next();

			System.out.println("Enter the Employee Salary");
			EmpSal = sin.nextInt();


			bonus = Bonus(EmpSal);
		
			total = total + bonus;

		}
		System.out.println("Total Bonus given to employees during festival season "+total);
    }   
}