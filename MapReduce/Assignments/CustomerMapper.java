import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CustomerMapper extends Mapper<LongWritable, Text, Text, Text>
{
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		try {
			String[] rec = value.toString().split(";");
			
			String mykey = "all";
		    String dt = rec[0];
			String custid= rec[1];
	        String sales = rec[8];
			String myValue = dt + ',' + custid + ',' + sales;
			context.write(new Text(mykey), new Text(myValue));			
		} catch (IndexOutOfBoundsException e) {
		} catch (ArithmeticException e1) {
		}
	}
}
