LINEITEM = LOAD 'hdfs://localhost:54310/user/hduser/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);
LINEITEM = LOAD 'hdfs://167.205.35.25:9000/user/willyTA/1GB/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);
LINEITEM = LOAD 'hdfs://167.205.35.25:9000/user/willyTA/3GB/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);

LINEITEM = LOAD 'hdfs://167.205.35.25:9000/user/willyTA/testing/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);
tmp1 = FILTER LINEITEM BY L_SHIPDATE>=1338508800000L AND L_SHIPDATE<=1346457600000L AND L_DISCOUNT>=30 AND L_DISCOUNT<=60 AND L_QUANTITY<=5000;
tmp2 = GROUP tmp1 ALL;
tmp3 = FOREACH tmp2{
	val = FOREACH tmp1 GENERATE (L_EXTENDEDPRICE * L_DISCOUNT / (double)100) as y;
	GENERATE SUM(val.y);
};

STORE tmp3 INTO 'hdfs://localhost:54310/user/hduser/query6-result2' USING PigStorage(',');
STORE tmp3 INTO 'hdfs://167.205.35.25:9000/user/willyTA/1GB/query6-result' USING PigStorage(',');
STORE tmp3 INTO 'hdfs://167.205.35.25:9000/user/willyTA/3GB/query6-result' USING PigStorage(',');


STORE LINEITEM INTO 'sample_07' USING org.apache.hive.hcatalog.pig.HCatStorer();

-- hasil
-- 155.33