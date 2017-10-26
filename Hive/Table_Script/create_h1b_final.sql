CREATE TABLE h1b_final(s_no int,case_status string, employer_name
string, soc_name string, job_title string, full_time_position
string,prevailing_wage bigint,year string, worksite string, longitute
double, latitute double )
row format delimited
fields terminated by '\t'
STORED AS TEXTFILE;

INSERT OVERWRITE TABLE h1b_final SELECT s_no,
case when trim(case_status) = "PENDING QUALITY AND COMPLIANCE REVIEW -
UNASSIGNED" then "DENIED"
when trim(case_status) = "REJECTED" then "DENIED"
when trim(case_status) = "INVALIDATED" then "DENIED"
else case_status end,
employer_name, soc_name, job_title, full_time_position,
case when prevailing_wage is null then 100000
else prevailing_wage end,
year, worksite, longitute, latitute
FROM h1b_app2;
