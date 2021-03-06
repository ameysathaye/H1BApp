package myudfs;
import java.io.IOException;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;


public class UPPERS extends EvalFunc<String>
{
 public String exec(Tuple input) throws IOException
 {
	 if (input==null || input.size()==0)
	 {
		 return null;
	 }
	 try
	 {
		 String str = (String)input.get(0);
		 if(str != null)
		 {
			 return str.toUpperCase();
		 }
		 else
		 {
			 return null;
		 }
	 }
	 catch(Exception e)
	 {
		 throw new IOException("Caught exception processing input row",e);
	 }
 }
}
