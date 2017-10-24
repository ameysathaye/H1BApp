insert overwrite table niit_h1b.question5a select job_title,year,count(case_status ) as temp from niit_h1b.h1b_final where year = '2011' group by job_title,year order by temp desc limit 10;
insert into table niit_h1b.question5a select job_title,year,count(case_status ) as temp from niit_h1b.h1b_final where year = '2012' group by job_title,year order by temp desc limit 10; 
insert into table niit_h1b.question5a select job_title,year,count(case_status ) as temp from niit_h1b.h1b_final where year = '2013' group by job_title,year order by temp desc limit 10;
insert into table niit_h1b.question5a select job_title,year,count(case_status ) as temp from niit_h1b.h1b_final where year = '2014' group by job_title,year order by temp desc limit 10;
insert into table niit_h1b.question5a select job_title,year,count(case_status ) as temp from niit_h1b.h1b_final where year = '2015' group by job_title,year order by temp desc limit 10;
insert into table niit_h1b.question5a select job_title,year,count(case_status ) as temp from niit_h1b.h1b_final where year = '2016' group by job_title,year order by temp desc limit 10;
