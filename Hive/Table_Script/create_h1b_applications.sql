CREATE TABLE h1b_applications(s_no int,case_status string,
employer_name string, soc_name string, job_title string,
full_time_position string,prevailing_wage bigint,year string, worksite
string, longitute double, latitute double )
ROW FORMAT SERDE 'org.apache.hadoop.hive.serde2.OpenCSVSerde'
WITH SERDEPROPERTIES (
"separatorChar" = ",",
"quoteChar" = "\""
) STORED AS TEXTFILE;

load data local inpath '/home/hduser/h1b.csv' overwrite into table
h1b_applications;
