package model;

import helper.Helper;

/**
 * Created by nim_13512065 on 6/2/16.
 */
public class Customer implements ModelInterface {
    private int C_CUSTKEY;
    private String C_NAME;
    private String C_ADDRESS;
    private int C_NATIONKEY;
    private String C_PHONE;
    private int C_ACCTBAL;
    private String C_MKTSEGMENT;
    private String C_COMMENT;

    public Customer() {

    }

    public Customer(int id) {
        setC_CUSTKEY(id);
        setC_NAME(Helper.randomNumberFixedLength(10));
        setC_ADDRESS(Helper.randomNumberFixedLength(20));
        setC_NATIONKEY(Helper.randomIntegerWithRange(1,25));
        setC_PHONE(Helper.randomNumberFixedLength(7));
        setC_ACCTBAL(Helper.randomIntegerWithLimit(1000000));
        setC_MKTSEGMENT(Helper.randomStringFixedLength(30));
        setC_COMMENT(Helper.randomStringFixedLength(20));
    }

    public int getC_CUSTKEY() {
        return C_CUSTKEY;
    }

    public void setC_CUSTKEY(int c_CUSTKEY) {
        C_CUSTKEY = c_CUSTKEY;
    }

    public String getC_NAME() {
        return C_NAME;
    }

    public void setC_NAME(String c_NAME) {
        C_NAME = c_NAME;
    }

    public String getC_ADDRESS() {
        return C_ADDRESS;
    }

    public void setC_ADDRESS(String c_ADDRESS) {
        C_ADDRESS = c_ADDRESS;
    }

    public int getC_NATIONKEY() {
        return C_NATIONKEY;
    }

    public void setC_NATIONKEY(int c_NATIONKEY) {
        C_NATIONKEY = c_NATIONKEY;
    }

    public String getC_PHONE() {
        return C_PHONE;
    }

    public void setC_PHONE(String c_PHONE) {
        C_PHONE = c_PHONE;
    }

    public int getC_ACCTBAL() {
        return C_ACCTBAL;
    }

    public void setC_ACCTBAL(int c_ACCTBAL) {
        C_ACCTBAL = c_ACCTBAL;
    }

    public String getC_MKTSEGMENT() {
        return C_MKTSEGMENT;
    }

    public void setC_MKTSEGMENT(String c_MKTSEGMENT) {
        C_MKTSEGMENT = c_MKTSEGMENT;
    }

    public String getC_COMMENT() {
        return C_COMMENT;
    }

    public void setC_COMMENT(String c_COMMENT) {
        C_COMMENT = c_COMMENT;
    }
}
