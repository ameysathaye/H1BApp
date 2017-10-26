CREATE TABLE h1b_app2(s_no int,case_status string, employer_name
string, soc_name string, job_title string, full_time_position
string,prevailing_wage bigint,year string, worksite string, longitute
double, latitute double )
row format delimited
fields terminated by '\t'
STORED AS TEXTFILE;


INSERT OVERWRITE TABLE h1b_app2 SELECT regexp_replace(s_no, "\t", ""),
regexp_replace(case_status, "\t", ""), regexp_replace(employer_name,
"\t", ""), regexp_replace(soc_name, "\t", ""),
regexp_replace(job_title, "\t", ""),
regexp_replace(full_time_position, "\t", ""), prevailing_wage,
regexp_replace(year, "\t", ""), regexp_replace(worksite, "\t", ""),
regexp_replace(longitute, "\t", ""), regexp_replace(latitute, "\t",
"") FROM h1b_applications where case_status != "NA";
