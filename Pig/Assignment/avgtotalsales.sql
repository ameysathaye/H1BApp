totalsales1 = Load '/home/hduser/2000.txt' USING PigStorage(',') as (categoryid:chararray,categoryname:chararray,jan:double,feb:double,mar:double,apr:double,may:double,jun:double,jul:double,aug:double,sep:double,oct:double,nov:double,dec:double);

totalmnth = foreach totalsales1 generate categoryid,categoryname,jan+feb+mar+apr+may+jun+jul+aug+sep+oct+nov+dec as month;

totalsales2 = Load '/home/hduser/2001.txt' USING PigStorage(',') as (categoryid:chararray,categoryname:chararray,jan:double,feb:double,mar:double,apr:double,may:double,jun:double,jul:double,aug:double,sep:double,oct:double,nov:double,dec:double);

totalmnth1 = foreach totalsales2 generate categoryid,categoryname,jan+feb+mar+apr+may+jun+jul+aug+sep+oct+nov+dec as month;

totalsales3 = Load '/home/hduser/2002.txt' USING PigStorage(',') as (categoryid:chararray,categoryname:chararray,jan:double,feb:double,mar:double,apr:double,may:double,jun:double,jul:double,aug:double,sep:double,oct:double,nov:double,dec:double);

totalmnth2 = foreach totalsales3 generate categoryid,categoryname,jan+feb+mar+apr+may+jun+jul+aug+sep+oct+nov+dec as month;

joined1 = join totalmnth by $0,totalmnth1 by $0,totalmnth2 by $0;

joined2 = foreach joined1 generate $0,$1,$2,$5,$8;

avgsales = foreach joined2 generate $0,$1,((($3-$2)*100)/$2) as firstgrow,((($4-$3)*100)/$3) as secondgrow;

avgsales1 = foreach avgsales generate $0,$1,ROUND_TO((($2+$3)/2),2) as avgperc;

final = FILTER avgsales1 BY $2>=10.0;

store final into '/home/hduser/niit/pig/avg10grow' using PigStorage(',');
