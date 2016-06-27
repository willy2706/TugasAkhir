CUSTOMER = LOAD 'hdfs://localhost:54310/user/hduser/customer' USING PigStorage(',') AS (C_CUSTKEY: int, C_NAME: chararray, C_ADDRESS: chararray, C_NATIONKEY: int, C_PHONE: chararray, C_ACCTBAL: int, C_MKTSEGMENT: chararray, C_COMMENT: chararray);

ORDERS = LOAD 'hdfs://localhost:54310/user/hduser/orders' USING PigStorage(',') AS (O_ORDERKEY: int, O_CUSTKEY: int, O_ORDERSTATUS: int, O_TOTALPRICE: int, O_ORDERDATE: long, O_ORDERPRIORITY: int, O_CLERK: chararray, O_SHIPPRIORITY: int, O_COMMENT: chararray);

LINEITEM = LOAD 'hdfs://localhost:54310/user/hduser/lineitem' USING PigStorage(',') AS (L_ORDERKEY: int, L_LINENUMBER: int, L_PARTKEY: int, L_SUPPKEY: int, L_QUANTITY: int, L_EXTENDEDPRICE: int, L_DISCOUNT: int, L_TAX: int, L_RETURNFLAG: int, L_LINESTATUS: chararray, L_SHIPDATE: long, L_COMMITDATE: long, L_RECEIPTDATE: long, L_SHIPINSTRUCT: chararray, L_SHIPMODE: chararray, L_COMMENT: chararray);

SUPPLIER = LOAD 'hdfs://localhost:54310/user/hduser/supplier' USING PigStorage(',') AS (S_SUPPKEY: int, S_NAME: chararray, S_ADDRESS: chararray, S_NATIONKEY: int, S_PHONE: chararray, S_ACCTBAL: int, S_COMMENT: chararray);
    
NATION = LOAD'hdfs://localhost:54310/user/hduser/nation' USING PigStorage(',') AS (N_NATIONKEY:int, N_NAME: chararray, N_REGIONKEY: int, N_COMMENT: chararray);

REGION = LOAD 'hdfs://localhost:54310/user/hduser/region' USING PigStorage(',') AS (R_REGIONKEY: int, R_NAME: chararray, R_COMMENT: chararray);

tmp1 = JOIN CUSTOMER BY C_CUSTKEY, ORDERS BY O_CUSTKEY;
tmp2 = JOIN LINEITEM BY L_ORDERKEY, tmp1 BY ORDERS::O_ORDERKEY;
tmp3 = JOIN tmp2 BY LINEITEM::L_SUPPKEY, SUPPLIER BY S_SUPPKEY;
tmp4 = FILTER tmp3 BY CUSTOMER::C_NATIONKEY==SUPPLIER::S_NATIONKEY;
tmp5 = JOIN tmp4 BY SUPPLIER::S_NATIONKEY, NATION BY N_NATIONKEY;
tmp6 = JOIN tmp5 BY NATION::N_REGIONKEY, REGION BY R_REGIONKEY;
tmp7 = FILTER tmp6 BY ORDERS::O_ORDERDATE>=1338508800000L AND ORDERS::O_ORDERDATE<=1346457600000L; --1464739200000 = 1 june 2012 00 GMT and 1472688000000 is 1 sep 2012 00 GMT. Choose 3 months instead of 1 year due to the dataset range only 1 year
tmp8 = FOREACH tmp7 GENERATE NATION::N_NAME, LINEITEM::L_EXTENDEDPRICE * (100 - LINEITEM::L_DISCOUNT) as calc;
tmp9 = GROUP tmp8 BY NATION::N_NAME;
tmp10 = FOREACH tmp9 GENERATE group, SUM(tmp8.calc);
STORE tmp10 INTO 'hdfs://localhost:54310/user/hduser/result10' USING PigStorage(',');

-- X = JOIN NATION BY N_REGIONKEY, REGION BY R_REGIONKEY;

-- t = FILTER ORDERS BY O_ORDERKEY<=100;