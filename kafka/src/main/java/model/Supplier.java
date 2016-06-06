package model;

import helper.Helper;

/**
 * Created by nim_13512065 on 6/1/16.
 */
public class Supplier implements ModelInterface {
    private int S_SUPPKEY;
    private String S_NAME;
    private String S_ADDRESS;
    private int S_NATIONKEY;
    private String S_PHONE;
    private int S_ACCTBAL;
    private String S_COMMENT;

    public Supplier() {

    }

    public Supplier(int id) {
        setS_SUPPKEY(id);
        setS_NAME(Helper.randomStringFixedLength(10));
        setS_ADDRESS(Helper.randomStringFixedLength(20));
        setS_NATIONKEY(Helper.randomIntegerWithRange(1, Helper.MAX_ROW));
        setS_PHONE(Helper.randomNumberFixedLength(10));
        setS_ACCTBAL(Helper.randomIntegerWithLimit(1000000));
        setS_COMMENT(Helper.randomStringFixedLength(20));
    }

    public int getS_SUPPKEY() {
        return S_SUPPKEY;
    }

    public void setS_SUPPKEY(int s_SUPPKEY) {
        S_SUPPKEY = s_SUPPKEY;
    }

    public String getS_NAME() {
        return S_NAME;
    }

    public void setS_NAME(String s_NAME) {
        S_NAME = s_NAME;
    }

    public String getS_ADDRESS() {
        return S_ADDRESS;
    }

    public void setS_ADDRESS(String s_ADDRESS) {
        S_ADDRESS = s_ADDRESS;
    }

    public int getS_NATIONKEY() {
        return S_NATIONKEY;
    }

    public void setS_NATIONKEY(int s_NATIONKEY) {
        S_NATIONKEY = s_NATIONKEY;
    }

    public String getS_PHONE() {
        return S_PHONE;
    }

    public void setS_PHONE(String s_PHONE) {
        S_PHONE = s_PHONE;
    }

    public int getS_ACCTBAL() {
        return S_ACCTBAL;
    }

    public void setS_ACCTBAL(int s_ACCTBAL) {
        S_ACCTBAL = s_ACCTBAL;
    }

    public String getS_COMMENT() {
        return S_COMMENT;
    }

    public void setS_COMMENT(String s_COMMENT) {
        S_COMMENT = s_COMMENT;
    }
}
