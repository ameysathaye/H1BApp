import java.io.*;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;

import org.apache.hadoop.util.*;

public class MyNewClass1 extends Configured implements Tool
{
	public static class MapClass extends Mapper<LongWritable,Text,Text,Text>
	   {
	      public void map(LongWritable key, Text value, Context context)
	      {
	         try{
	            String[] str = value.toString().split(";");
	            //String prod=str[5];
	            String ctg=str[4];
	            String age=str[2];
	            long loss=Long.parseLong(str[7])-Long.parseLong(str[8]);
	            String ls = String.format("%d", loss);
	            String myValue = age + ";" + ls;
	            context.write(new Text(ctg), new Text(myValue));
	         }
	         catch(Exception e)
	         {
	            System.out.println(e.getMessage());
	         }
	      }
	   }
	
	public static class CaderPartitioner extends
	   Partitioner < Text, Text >
	   {
	      @Override
	      public int getPartition(Text key, Text value, int numReduceTasks)
	      {
	         String[] str = value.toString().split(";");
	         String ag = null;
	         ag = str[0];	         
	         
	         if(ag.equalsIgnoreCase("A"))
	         {
	            return 0;
	         }
	         else if(ag.equalsIgnoreCase("B"))
	         {
	            return 1;
	         }
	         else if(ag.equalsIgnoreCase("C"))
	         {
	            return 2;
	         }
	         else if(ag.equalsIgnoreCase("D"))
	         {
	            return 3;
	         }
	         else if(ag.equalsIgnoreCase("E"))
	         {
	            return 4;
	         }
	         else if(ag.equalsIgnoreCase("F"))
	         {
	            return 5;
	         }
	         else if(ag.equalsIgnoreCase("G"))
	         {
	            return 6;
	         }
	         else if(ag.equalsIgnoreCase("H"))
	         {
	            return 7;
	         }
	         else if(ag.equalsIgnoreCase("I"))
	         {
	            return 8;
	         }
	         else
	         {
	        	 return 9;
	         }
	      }
	   }
	
	public static class ReduceClass extends Reducer<Text,Text,Text,Text>
	   {
	      long sum=0;
	      private Text outputKey = new Text();
	      String myValue="";
	      public void reduce(Text key, Iterable <Text> values, Context context) 
	      throws IOException, InterruptedException, NullPointerException
	      {
	    	  
		         for (Text val : values)
		         {   
		        	 String[] str = val.toString().split(";"); 
		        	 long val1 = Long.parseLong(str[1]);
		        	 if(val1 > 0)
		        	 {
		        	 sum+=val1; 
		        	 }
		        	 String myKey=str[0]+","+key;
		        	 myValue=String.format("%d", sum);
		        	 outputKey.set(myKey);
		         }
		         context.write(outputKey, new Text(myValue));
		         sum=0;
		         myValue="";
	      }
	   }
	
	public int run(String[] arg) throws Exception
	   {
		
		   
		  Configuration conf = new Configuration();
		  Job job = Job.getInstance(conf);
		  job.setJarByClass(MyNewClass1.class);
		  job.setJobName("Top Salaried Employees");
	      FileInputFormat.setInputPaths(job, new Path(arg[0]));
	      FileOutputFormat.setOutputPath(job,new Path(arg[1]));
			
	      job.setMapperClass(MapClass.class);
			
	      job.setMapOutputKeyClass(Text.class);
	      job.setMapOutputValueClass(Text.class);
	      
	      //set partitioner statement
			
	      job.setPartitionerClass(CaderPartitioner.class);
	      job.setReducerClass(ReduceClass.class);
	      job.setNumReduceTasks(10);
	      job.setInputFormatClass(TextInputFormat.class);
			
	      job.setOutputFormatClass(TextOutputFormat.class);
	      job.setOutputKeyClass(Text.class);
	      job.setOutputValueClass(Text.class);
			
	      System.exit(job.waitForCompletion(true)? 0 : 1);
	      return 0;
	   }
	   
	   public static void main(String ar[]) throws Exception
	   {
	      ToolRunner.run(new Configuration(), new MyNewClass1(),ar);
	      System.exit(0);
	   }
}
