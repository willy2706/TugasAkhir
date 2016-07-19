LINEITEM = LOAD 'hdfs://localhost:54310/user/hduser/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);
PART = LOAD 'hdfs://localhost:54310/user/hduser/part' USING PigStorage(',') AS (P_PARTKEY: int, P_NAME: chararray, P_MFGR: chararray, P_BRAND: chararray, P_TYPE: chararray, P_SIZE: chararray, P_CONTAINER: chararray, P_RETAILPRICE: chararray, P_COMMENT: chararray);

LINEITEM = LOAD 'hdfs://167.205.35.25:9000/user/willyTA/1GB/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);
LINEITEM = LOAD 'hdfs://167.205.35.25:9000/user/willyTA/3GB/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);
PART = LOAD 'hdfs://167.205.35.25:9000/user/willyTA/1GB/part' USING PigStorage(',') AS (P_PARTKEY: int, P_NAME: chararray, P_MFGR: chararray, P_BRAND: chararray, P_TYPE: chararray, P_SIZE: chararray, P_CONTAINER: chararray, P_RETAILPRICE: chararray, P_COMMENT: chararray);
PART = LOAD 'hdfs://167.205.35.25:9000/user/willyTA/3GB/part' USING PigStorage(',') AS (P_PARTKEY: int, P_NAME: chararray, P_MFGR: chararray, P_BRAND: chararray, P_TYPE: chararray, P_SIZE: chararray, P_CONTAINER: chararray, P_RETAILPRICE: chararray, P_COMMENT: chararray);

tmp1 = JOIN LINEITEM BY L_PARTKEY, PART BY P_PARTKEY;
tmp2 = GROUP tmp1 ALL;
tmp3 = FOREACH tmp2 {
	y = FOREACH tmp1 GENERATE L_QUANTITY; 
	GENERATE 0.2*AVG(y) as ave;
};

tmp4 = JOIN LINEITEM BY L_PARTKEY, PART BY P_PARTKEY;
tmp5 = FILTER tmp4 BY P_BRAND == 'abcde' AND P_CONTAINER == 'abcde' AND L_QUANTITY < tmp3.ave;
tmp6 = GROUP tmp5 ALL;
tmp7 = FOREACH tmp6 {
	s = FOREACH tmp5 GENERATE L_EXTENDEDPRICE;
	y = SUM(s)/7.0;
	GENERATE y;
};

STORE tmp7 INTO 'hdfs://localhost:54310/user/hduser/result9' USING PigStorage(',');
STORE tmp7 INTO 'hdfs://167.205.35.25:9000/user/willyTA/1GB/result9' USING PigStorage(',');
STORE tmp7 INTO 'hdfs://167.205.35.25:9000/user/willyTA/3GB/result9' USING PigStorage(',');

--untuk tau brand dan container
-- PART = LOAD 'hdfs://localhost:54310/user/hduser/part' USING PigStorage(',') AS (P_PARTKEY: int, P_NAME: chararray, P_MFGR: chararray, P_BRAND: chararray, P_TYPE: chararray, P_SIZE: chararray, P_CONTAINER: chararray, P_RETAILPRICE: chararray, P_COMMENT: chararray);
-- tmp_brand = GROUP PART BY P_BRAND;
-- tmp_brand1 = FOREACH tmp_brand GENERATE group, COUNT(PART.P_PARTKEY) as cnt;
-- tmp_brand2 = ORDER tmp_brand1 BY cnt DESC;
-- tmp_brand3 = LIMIT tmp_brand2 1;

-- HELPER
x = FOREACH PART GENERATE P_PARTKEY, P_NAME, P_MFGR, (P_PARTKEY<=3000000?'abcde':P_BRAND) as P_BRAND, (P_PARTKEY<=3000000?'1B':P_TYPE) as P_TYPE, P_SIZE, (P_PARTKEY<=3000000?'abcde':P_CONTAINER) as P_CONTAINER, P_RETAILPRICE, P_COMMENT;

STORE x INTO 'hdfs://167.205.35.25:9000/user/willyTA/1GB/part-new' USING PigStorage(',');
STORE x INTO 'hdfs://167.205.35.25:9000/user/willyTA/3GB/part-new' USING PigStorage(',');

tmp_brandx = GROUP x BY P_NAME;
tmp_brandx1 = FOREACH tmp_brandx GENERATE group, COUNT(x.P_PARTKEY) as cnt;
tmp_brandx2 = ORDER tmp_brandx1 BY cnt DESC;
tmp_brandx3 = LIMIT tmp_brandx2 1;

hdfs dfs -cat /user/willyTA/3GB/part-new/part-m-00000 /user/willyTA/3GB/part-new/part-m-00001 /user/willyTA/3GB/part-new/part-m-00002 /user/willyTA/3GB/part-new/part-m-00003 /user/willyTA/3GB/part-new/part-m-00004 /user/willyTA/3GB/part-new/part-m-00005 | hdfs dfs -put - /user/willyTA/3GB/part-new/concat
