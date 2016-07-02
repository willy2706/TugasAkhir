LINEITEM = LOAD 'hdfs://localhost:54310/user/hduser/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);
PART = LOAD 'hdfs://localhost:54310/user/hduser/part' USING PigStorage(',') AS (P_PARTKEY: int, P_NAME: chararray, P_MFGR: chararray, P_BRAND: chararray, P_TYPE: chararray, P_SIZE: chararray, P_CONTAINER: chararray, P_RETAILPRICE: chararray, P_COMMENT: chararray);

tmp1 = JOIN LINEITEM BY L_PARTKEY, PART BY P_PARTKEY;
tmp2 = FILTER tmp1 BY LINEITEM::L_SHIPDATE>=1338508800000L AND LINEITEM::L_SHIPDATE<=1346457600000L;
tmp3 = GROUP tmp2 ALL;
tmp4 = FOREACH tmp3 {
	pembilang = FOREACH tmp2 GENERATE (P_TYPE MATCHES 'ISISENDIRI' ? L_EXTENDEDPRICE*(100-L_DISCOUNT) : 0) AS x;
	penyebut = FOREACH tmp2 GENERATE L_EXTENDEDPRICE * (100-L_DISCOUNT);
	GENERATE 100*SUM(pembilang)/SUM(penyebut);
};

STORE tmp4 INTO 'hdfs://localhost:54310/user/hduser/result9' USING PigStorage(',');