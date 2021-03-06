import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;

public class MaxCustomer 
{
	public static void main(String[] args) throws Exception {

		if (args.length != 2) {
			System.out
					.printf("Usage: TotalGrossProfit <input dir> <output dir>\n");
			System.exit(-1);
		}

		
		Configuration conf = new Configuration();
		//conf.set("","")
		Job job = Job.getInstance(conf, "Max Amount earned by Customer");

		job.setJarByClass(MaxCustomer.class);

		//job.setJobName("NYSE Stock");

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(CustomerMapper.class);
		//job.setCombinerClass(CustomerReducer.class);
		job.setReducerClass(CustomerReducer.class);
		//job.setNumReduceTasks(2);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}
}
