claims = Load '/home/hduser/employee.txt' using PigStorage(',') as (name:chararray,department:chararray,salary:double);

emp_claims = group claims by $0;

avgsal = foreach emp_claims generate group,ROUND_TO(AVG(claims.$2),2);

store avgsal into '/home/hduser/niit/pig/medicalclaim' using PigStorage(',');
