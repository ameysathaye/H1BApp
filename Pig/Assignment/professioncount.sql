use niit;

select profession,count(*) from customer where age >= ${hiveconf:myage} group by profession order by profession; 
