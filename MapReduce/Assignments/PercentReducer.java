import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class PercentReducer extends Reducer<Text, FloatWritable, Text, FloatWritable>
{
private FloatWritable res = new FloatWritable();
    
    public void reduce(Text key, Iterable<FloatWritable> values,Context context) throws IOException, InterruptedException {
      long tot = 0;
		
         for (FloatWritable val : values)
         {       	
        	tot += val.get();      
         }
         
      res.set(tot);		      
      //context.write(key, result);
      context.write(key, new FloatWritable(tot));
      
    }
}
