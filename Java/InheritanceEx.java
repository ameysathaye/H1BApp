package inheritanceex;

public class InheritanceEx 
{
    public static void main(String[] args) 
    {
      sportscar cobj = new sportscar();
      cobj.Color = "Silver";
      cobj.brand = "Toyota";
      cobj.size = 30;
      cobj.gears = 5;
      cobj.cc = 1000;
      cobj.speed = 500;
      cobj.AutoDrive = "Yes";
      cobj.Security = "Yes";

      cobj.display();  
    }
    
}

class FourWheeler
{

  String Color;
  int speed;
  int size;

  public void display()
  {
   System.out.println("The Color is:"+Color);
   System.out.println("The Speed is:"+speed);
   System.out.println("The Size is:"+size);
  }
}

//class Truck extends FourWheeler{}

class car extends FourWheeler
{
 String brand;
 int cc;
 int gears;

 @Override
 public void display()
  {
   //code to use base class member
   super.display();

   //code to use child class member
   System.out.println("The Brand is:"+brand);
   System.out.println("The CC is:"+cc);
   System.out.println("The Gears is:"+gears);
  }
  
}

class sportscar extends car
{
 String Security;
 String AutoDrive;

 @Override
 public void display()
  {
   //code to use base class member
   super.display();

   //code to use child class member
   System.out.println("Security Support:"+Security);
   System.out.println("Autodrive is:"+AutoDrive);
  }
  
}