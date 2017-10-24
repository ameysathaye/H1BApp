package reversenumber;
import java.util.*;

public class ReverseNumber 
{

    public static int reverse(int num)
   {
     int n,reverse = 0;
     n=num;
     while( n != 0 )
     {
       reverse = reverse * 10;
       reverse = reverse + n%10;
       n = n/10;
     }
     return reverse;
   }
    public static void main(String[] args) 
    {
        int n,revnum;
 
      Scanner in = new Scanner(System.in);
      
      System.out.println("Enter the number to be reverse");
      n = in.nextInt();
 
      revnum = reverse(n);
 
      System.out.println("Reverse of entered number is "+revnum);
    }
    
}
