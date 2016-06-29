LINEITEM = LOAD 'hdfs://localhost:54310/user/hduser/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);

tmp1 = FILTER LINEITEM BY L_SHIPDATE>=1338508800000L AND L_SHIPDATE<=1346457600000L AND L_DISCOUNT>=30 AND L_DISCOUNT<=60 AND L_QUANTITY<=5000;
tmp2 = GROUP tmp1 ALL;
tmp3 = FOREACH tmp2{
	val = FOREACH tmp1 GENERATE (L_EXTENDEDPRICE * L_DISCOUNT / 100f) as y;
	GENERATE SUM(val.y);
}

STORE tmp2 INTO 'hdfs://localhost:54310/user/hduser/query6-result2' USING PigStorage(',');