import java.io.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;

public class ProductViable 
{
	public static class PVMapper extends Mapper<LongWritable, Text, Text, Text>
	{
		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException 
				{
			try {
				String[] record = value.toString().split(";");			
				String prod = record[5];
				//String catg = record[4];
				context.write(new Text(prod),value);				
			} catch (IndexOutOfBoundsException e) {
			} catch (ArithmeticException e1) {
			}
		}

	}
	
	public static class ProductViableReducer extends Reducer<Text, Text, Text, LongWritable>
	{		    
	    public void reduce(Text key, Iterable<Text> values,Context context) throws IOException, InterruptedException 
	    {
	      long cost=0;
	      long sales=0;
	      long profit=0;
	      long sum=0;
	         for (Text val : values)
	         {   
	        	 String[] str = val.toString().split(";"); 
	        	 cost=Long.parseLong(str[7]);
	        	 sales=Long.parseLong(str[8]);
	        	 profit = sales-cost;
	        	 if(profit > 0)
	        	 {
		        	sum+=profit; 
	        	 }
	        	
	         }
	         
	         context.write(key, new LongWritable(sum));
	    }
	}
	
	public static class CaderPartitioner extends
	   Partitioner < Text, Text >
	   {
	      @Override
	      public int getPartition(Text key, Text value, int numReduceTasks)
	      {
	         String[] str = value.toString().split(",");
	         String age = str[2];	         
	         
	         if(age.equalsIgnoreCase("A"))
	         {
	            return 0;
	         }
	         else if(age.equalsIgnoreCase("B"))
	         {
	            return 1;
	         }
	         else if(age.equalsIgnoreCase("C"))
	         {
	            return 2;
	         }
	         else if(age.equalsIgnoreCase("D"))
	         {
	            return 3;
	         }
	         else if(age.equalsIgnoreCase("E"))
	         {
	            return 4;
	         }
	         else if(age.equalsIgnoreCase("F"))
	         {
	            return 5;
	         }
	         else if(age.equalsIgnoreCase("G"))
	         {
	            return 6;
	         }
	         else if(age.equalsIgnoreCase("H"))
	         {
	            return 7;
	         }
	         else if(age.equalsIgnoreCase("I"))
	         {
	            return 8;
	         }
	         else
	         {
	        	 return 9;
	         }
	      }
	   }
	
	public static void main(String arg[]) throws Exception,IllegalStateException
	   {
		      Configuration conf = new Configuration();
			  Job job = Job.getInstance(conf);
			  job.setJarByClass(ProductViable.class);
			  job.setJobName("Profit Products");
		      FileInputFormat.setInputPaths(job, new Path(arg[0]));
		      FileOutputFormat.setOutputPath(job,new Path(arg[1]));
				
		      job.setMapperClass(PVMapper.class);
				
		      job.setMapOutputKeyClass(Text.class);
		      job.setMapOutputValueClass(Text.class);
		      
		      //set partitioner statement
				
		      job.setPartitionerClass(CaderPartitioner.class);
		      //job.setReducerClass(ProductViableReducer.class);
		      job.setNumReduceTasks(10);
		      job.setInputFormatClass(TextInputFormat.class);
				
		      job.setOutputFormatClass(TextOutputFormat.class);
		      job.setOutputKeyClass(Text.class);
		      job.setOutputValueClass(LongWritable.class);
				
		      System.exit(job.waitForCompletion(true)? 0 : 1);
	   }
}
	
