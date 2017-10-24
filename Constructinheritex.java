package constructinheritex;

import java.util.*;

public class Constructinheritex
{
    public static void main(String[] args) 
    {
     int alg,trg,geo,stst,bottheo,botprct,zootheo,zooprct,elctheo,elcprct;   
     Scanner sin=new Scanner(System.in);
  
     System.out.println("Enter Algebra Marks");
     alg=sin.nextInt();
     
     System.out.println("Enter Trignometry Marks");
     trg=sin.nextInt();
     
     System.out.println("Enter Geometry Marks");
     geo=sin.nextInt(); 
     
     System.out.println("Enter Statistics Marks");
     stst=sin.nextInt(); 
      
     System.out.println("Enter Botany Theory Marks");
     bottheo=sin.nextInt();
     
     System.out.println("Enter Botany Practical Marks");
     botprct=sin.nextInt();
     
     System.out.println("Enter Zoology Theory Marks");
     zootheo=sin.nextInt(); 
     
     System.out.println("Enter Zoology Practical Marks");
     zooprct=sin.nextInt(); 
     
     System.out.println("Enter Electronics Theory Marks");
     elctheo=sin.nextInt(); 
     
     System.out.println("Enter Electronics Practical Marks");
     elcprct=sin.nextInt();
     
      Maths ma = new Maths(alg,trg,geo,stst);
      ma.display();
      
      Botany bot = new Botany(bottheo,botprct);
      bot.display();
      
      Zoology zoo = new Zoology(zootheo,zooprct);
      zoo.display();
      
      Software sw = new Software();
      sw.display();
      
      Hardware hw = new Hardware();
      hw.display();
      
      Electronics elc = new Electronics(elctheo,elcprct);
      elc.display(); 
    }
    
}

class Science_Stream
{
   String id,name;
   int total;
   
   public Science_Stream(String sid,String sname)
    {
       System.out.println("Constructor of Science"); 
       this.id=sid;
       this.name=sname;
    }
   
   public void display()
  {
       System.out.println(id);
       System.out.println(name);
  }
}

class Maths extends Science_Stream
{
  int Algebra,Trignometry,Geometry,Statistics,totmks=0;
  
  public Maths(int Al,int TG,int GE,int STS)
  {
   super("1","Amey");
   this.Algebra=Al;
   this.Trignometry=TG;
   this.Geometry=GE;
   this.Statistics=STS;
   System.out.println("Constructor of Maths"); 
   totmks = this.Algebra + this.Trignometry + this.Geometry + this.Statistics; 
  }
  
  @Override
  public void display()
  {
   super.display();
   System.out.println("Total Marks obtained in Maths\t"+totmks);
  }
}

class Biology extends Science_Stream
{
   String biostream;
   public Biology(String str)
   {
     super("2","Amey");
     System.out.println("Constructor of Biology");
     this.biostream=str;
   }

   @Override
  public void display()
  {
   super.display();
   System.out.println(biostream);
  }
}

class Botany extends Biology
{
 int theorymks,prctmarks,totmks;
 public Botany(int th,int pr)
 {
  super("Botany");
  System.out.println("Constructor of Botany");
  this.theorymks = th;
  this.prctmarks = pr;
  totmks = this.theorymks + this.prctmarks;
 }

 @Override
 public void display()
  {
   super.display();
   System.out.println("Total Marks obtained in Botany\t"+totmks);
  }
}
class Zoology extends Biology
{
 int theomks,prctmks,totmks;
  public  Zoology(int th,int pr)
  {
   super("Zoology"); 
   System.out.println("Constructor of Zoology");
   this.theomks=th;
   this.prctmks=pr;
   totmks=theomks+prctmks;
  }

 @Override
  public void display()
  {
   super.display();
   System.out.println("Total Marks obtained in Zoology\t"+totmks);
  }
}

class Computers extends Science_Stream
{
  String Architecture;
  public Computers()
  {
    super("3","Amey");
    System.out.println("Constructor of Computers");
    Architecture="Two Tier";
  }

  @Override
  public void display()
  {
   super.display();
   System.out.println(Architecture);
  }
}

class Software extends Computers
{
 String Programming_languages;
 public Software()
 {
   System.out.println("Constructor of Software");  
   Architecture="Three Tier";
 }

 @Override
 public void display()
  {
    super.display();
    Programming_languages="Java";
    System.out.println(Programming_languages);
  }
}

class Hardware extends Computers
{
  String AssemblyLanguage,Networking;
  public Hardware()
 {
    System.out.println("Constructor of Hardware"); 
    Architecture="Multi level";
 }

  @Override
 public void display()
  {
   super.display();
   AssemblyLanguage="Yes";
   Networking="Yes";
   System.out.println(AssemblyLanguage);
   System.out.println(Networking);
  }
}

class Electronics extends Science_Stream
{
  int theomks,prctmks,totmks;
  public Electronics(int th,int pr)
  {
      super("4","Amey");
      System.out.println("Constructor of Electronics");
      this.theomks = th;
      this.prctmks = pr;
      totmks = theomks + prctmks;
  }

  @Override
  public void display()
  {
   super.display();
   System.out.println("Total Marks obtained in Electronics\t"+totmks);
  }
}
