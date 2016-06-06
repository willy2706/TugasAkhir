package model;

import helper.Helper;

/**
 * Created by nim_13512065 on 6/1/16.
 */
public class Partsupp implements ModelInterface {
    private int PS_PARTKEY;
    private int PS_SUPPKEY;
    private int PS_AVAILQTY;
    private int PS_SUPPLYCOST;
    private String PS_COMMENT;

    public Partsupp() {
        int partKey = Helper.randomIntegerWithRange(1, Helper.MAX_ROW);
        int suppKey = Helper.randomIntegerWithRange(1, Helper.MAX_ROW);
        while (suppKey == partKey) {
            suppKey = Helper.randomIntegerWithRange(1, Helper.MAX_ROW);
        }

        setPS_PARTKEY(partKey);
        setPS_SUPPKEY(suppKey);
        setPS_AVAILQTY(Helper.randomIntegerWithLimit(10000));
        setPS_SUPPLYCOST(Helper.randomIntegerWithLimit(1000000));
        setPS_COMMENT(Helper.randomStringFixedLength(20));
    }

    public int getPS_PARTKEY() {
        return PS_PARTKEY;
    }

    public void setPS_PARTKEY(int PS_PARTKEY) {
        this.PS_PARTKEY = PS_PARTKEY;
    }

    public int getPS_SUPPKEY() {
        return PS_SUPPKEY;
    }

    public void setPS_SUPPKEY(int PS_SUPPKEY) {
        this.PS_SUPPKEY = PS_SUPPKEY;
    }

    public int getPS_AVAILQTY() {
        return PS_AVAILQTY;
    }

    public void setPS_AVAILQTY(int PS_AVAILQTY) {
        this.PS_AVAILQTY = PS_AVAILQTY;
    }

    public int getPS_SUPPLYCOST() {
        return PS_SUPPLYCOST;
    }

    public void setPS_SUPPLYCOST(int PS_SUPPLYCOST) {
        this.PS_SUPPLYCOST = PS_SUPPLYCOST;
    }

    public String getPS_COMMENT() {
        return PS_COMMENT;
    }

    public void setPS_COMMENT(String PS_COMMENT) {
        this.PS_COMMENT = PS_COMMENT;
    }
}
