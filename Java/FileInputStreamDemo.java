package fileinputstreamdemo;

import java.io.*;

public class FileInputStreamDemo extends Exception
{
    public static void main(String[] args) 
    {
       int i;
       char c;
    
       try(FileInputStream f = new FileInputStream("D:\\test.txt"))
       {
                while((i = f.read()) != -1)
                {
                    c = (char) i;
                    System.out.println(c);
                }
       }
       catch(IOException e)
       {
          System.out.println(e);  
       }
    }
    
}
