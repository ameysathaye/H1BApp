totalsales1 = Load '/home/hduser/2000.txt' USING PigStorage(',') as (categoryid:chararray,categoryname:chararray,jan:long,feb:long,mar:long,apr:long,may:long,jun:long,jul:long,aug:long,sep:long,oct:long,nov:long,dec:long);

totalmnth = foreach totalsales1 generate categoryid,categoryname,jan+feb+mar+apr+may+jun+jul+aug+sep+oct+nov+dec as month;

totalsales2 = Load '/home/hduser/2001.txt' USING PigStorage(',') as (categoryid:chararray,categoryname:chararray,jan:long,feb:long,mar:long,apr:long,may:long,jun:long,jul:long,aug:long,sep:long,oct:long,nov:long,dec:long);

totalmnth1 = foreach totalsales2 generate categoryid,categoryname,jan+feb+mar+apr+may+jun+jul+aug+sep+oct+nov+dec as month;

totalsales3 = Load '/home/hduser/2002.txt' USING PigStorage(',') as (categoryid:chararray,categoryname:chararray,jan:long,feb:long,mar:long,apr:long,may:long,jun:long,jul:long,aug:long,sep:long,oct:long,nov:long,dec:long);

totalmnth2 = foreach totalsales3 generate categoryid,categoryname,jan+feb+mar+apr+may+jun+jul+aug+sep+oct+nov+dec as month;

joined1 = join totalmnth by $0,totalmnth1 by $0,totalmnth2 by $0;

joined2 = foreach joined1 generate $0,$1,$2,$5,$8;

sumtotal = foreach joined2 generate $0,$1,ROUND_TO($2+$3+$4,2) as overallsales;

top5 = limit (order sumtotal by $2 desc) 5;

store top5 into '/home/hduser/niit/pig/top5' using PigStorage(',');

bottom5 = limit (order sumtotal by $2) 5;

store bottom5 into '/home/hduser/niit/pig/bottom5' using PigStorage(',');
