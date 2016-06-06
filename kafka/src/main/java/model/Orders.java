package model;

import helper.Helper;

/**
 * Created by nim_13512065 on 6/2/16.
 */
public class Orders implements ModelInterface {
    private int O_ORDERKEY;
    private int O_CUSTKEY;
    private int O_ORDERSTATUS;
    private int O_TOTALPRICE;
    private long O_ORDERDATE;
    private int O_ORDERPRIORITY;
    private String O_CLERK;
    private int O_SHIPPRIORITY;
    private String O_COMMENT;

    public Orders() {

    }

    public Orders (int id) {
        setO_ORDERKEY(id);
        setO_CUSTKEY(Helper.randomIntegerWithRange(1, Helper.MAX_ROW));
        setO_ORDERSTATUS(Helper.randomIntegerWithLimit(10));
        setO_TOTALPRICE(Helper.randomIntegerWithLimit(1000000));
        setO_ORDERDATE(Helper.randomTimestampt());
        setO_ORDERPRIORITY(Helper.randomIntegerWithLimit(100));
        setO_CLERK(Helper.randomStringFixedLength(10));
        setO_SHIPPRIORITY(Helper.randomIntegerWithLimit(100));
        setO_COMMENT(Helper.randomStringFixedLength(20));
    }


    public int getO_ORDERKEY() {
        return O_ORDERKEY;
    }

    public void setO_ORDERKEY(int o_ORDERKEY) {
        O_ORDERKEY = o_ORDERKEY;
    }

    public int getO_CUSTKEY() {
        return O_CUSTKEY;
    }

    public void setO_CUSTKEY(int o_CUSTKEY) {
        O_CUSTKEY = o_CUSTKEY;
    }

    public int getO_ORDERSTATUS() {
        return O_ORDERSTATUS;
    }

    public void setO_ORDERSTATUS(int o_ORDERSTATUS) {
        O_ORDERSTATUS = o_ORDERSTATUS;
    }

    public int getO_TOTALPRICE() {
        return O_TOTALPRICE;
    }

    public void setO_TOTALPRICE(int o_TOTALPRICE) {
        O_TOTALPRICE = o_TOTALPRICE;
    }

    public long getO_ORDERDATE() {
        return O_ORDERDATE;
    }

    public void setO_ORDERDATE(long o_ORDERDATE) {
        O_ORDERDATE = o_ORDERDATE;
    }

    public int getO_ORDERPRIORITY() {
        return O_ORDERPRIORITY;
    }

    public void setO_ORDERPRIORITY(int o_ORDERPRIORITY) {
        O_ORDERPRIORITY = o_ORDERPRIORITY;
    }

    public String getO_CLERK() {
        return O_CLERK;
    }

    public void setO_CLERK(String o_CLERK) {
        O_CLERK = o_CLERK;
    }

    public int getO_SHIPPRIORITY() {
        return O_SHIPPRIORITY;
    }

    public void setO_SHIPPRIORITY(int o_SHIPPRIORITY) {
        O_SHIPPRIORITY = o_SHIPPRIORITY;
    }

    public String getO_COMMENT() {
        return O_COMMENT;
    }

    public void setO_COMMENT(String o_COMMENT) {
        O_COMMENT = o_COMMENT;
    }
}
