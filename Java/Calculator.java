package calculator;
import java.util.*;

public class Calculator 
{
  public static void calculate(int op)
  {
   int opt=op;
   double n1,n2;
   double f;

   Scanner sin=new Scanner(System.in);

   switch(opt)
  {
    case 1:
           System.out.print("\n\nEnter the first no. : ");
           n1=sin.nextInt();
           System.out.print("Enter the second no. : ");
           n2=sin.nextInt();
           f=n1+n2;
           System.out.println("Addition is : "+f);
           break;
    case 2:
           System.out.print("\n\nEnter the first no. : ");
           n1=sin.nextInt();
           System.out.print("Enter the second no. : ");
           n2=sin.nextInt();
           f=n1-n2;
           System.out.print("Subtraction is : "+f);
           break;
    case 3:
           System.out.print("\n\nEnter the first no. : ");
           n1=sin.nextInt();
           System.out.print("Enter the second no. : ");
           n2=sin.nextInt();
           f=n1*n2;
           System.out.print("Multiplication is : "+f);
           break;
    case 4:
           System.out.print("\n\nEnter the first no. : ");
           n1=sin.nextInt();
           System.out.print("Enter the second no. : ");
           n2=sin.nextInt();
           f=n1/n2;
           System.out.print("Division is : "+f);
           break;
    case 5:
           System.out.print("\n\nEnter the first no. : ");
           n1=sin.nextInt();
           System.out.print("Enter the second no. : ");
           n2=sin.nextInt();
           f=(n1*(n2/100));
           System.out.print("The Percentage is : "+f);
           break;
    case 6:
           break;
    default:
            System.out.println("Enter the correct no.");
            break;
   }
  }
    public static void main(String[] args)
    {
        int a;
        System.out.println("*********************Calculator*********************");
        Scanner ob=new Scanner(System.in);
        
        do
        {
          System.out.println("\n\n\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Percentage\n6.Exit");
          System.out.print("\nEnter operation you would like to perform : ");
          a=ob.nextInt();
          calculate(a);
        }while(a!=6);
    }   
}