import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class PercentMapper extends Mapper<LongWritable, Text, Text, FloatWritable>
{
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		try {
			String[] rec = value.toString().split(";");
			
			String prod = rec[5];
			String catg = rec[4];
			float cost = Float.valueOf(rec[7]);
			float sales = Float.valueOf(rec[8]);
			float perprof = ((sales - cost)*100)/cost;
			String str = prod.concat("\t"+catg);
			context.write(new Text(str), new FloatWritable(perprof));			
		} catch (IndexOutOfBoundsException e) {
		} catch (ArithmeticException e1) {
		}
	}
}
