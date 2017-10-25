import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CustomerReducer extends Reducer<Text,Text,NullWritable,Text>
{
   
    
    public void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException {
      //long tot = 0;
    	long max_amt=0;
    	   String custid="";
    	   String dt = "";
		
         for (Text val : values)
         {     
        	String[] token = val.toString().split(",");
        	if(Long.parseLong(token[2]) > max_amt)
        	{
        		max_amt=Long.parseLong(token[2]);
        		dt=token[0];
        		custid=token[1];
        	}
        	//tot += val.get();      
         }
         
      String myMaxValue = String.format("%d",max_amt);
      String myValue = dt + ',' + custid + ',' + myMaxValue;
      //context.write(key, result);
      context.write(NullWritable.get(),new Text(myValue));
      
    }
}
