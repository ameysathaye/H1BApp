user1 = Load '/home/hduser/weblog' using PigStorage(',') as (user:chararray,bank:chararray,time:double);

gateway = Load '/home/hduser/gateway' using PigStorage(',') as (bank:chararray,success_rate:double);

joined = join user1 by $1,gateway by $0;

groupuser = group joined by $0;

avgrate = foreach groupuser generate group,AVG(joined.$4);

final = FILTER avgrate by $1>90;

store final into '/home/hduser/niit/pig/paymentgateway' using PigStorage(',');
