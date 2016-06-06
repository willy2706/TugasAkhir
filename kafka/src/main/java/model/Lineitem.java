package model;

import helper.Helper;

import java.util.Date;

/**
 * Created by nim_13512065 on 6/2/16.
 */
public class Lineitem implements ModelInterface {
    private int L_ORDERKEY;
    private int L_LINENUMBER;
    private int L_PARTKEY;
    private int L_SUPPKEY;
    private int L_QUANTITY;
    private int L_EXTENDEDPRICE;
    private int L_DISCOUNT;
    private int L_TAX;
    private int L_RETURNFLAG;
    private String L_LINESTATUS;
    private long L_SHIPDATE;
    private long L_COMMITDATE;
    private long L_RECEIPTDATE;
    private String L_SHIPINSTRUCT;
    private String L_SHIPMODE;
    private String L_COMMENT;

    public Lineitem () {

    }

    public Lineitem(int id) {
        setL_ORDERKEY(Helper.randomIntegerWithRange(1, Helper.MAX_ROW));
        setL_LINENUMBER(id);
        setL_PARTKEY(Helper.randomIntegerWithRange(1, Helper.MAX_ROW));
        setL_SUPPKEY(Helper.randomIntegerWithRange(1, Helper.MAX_ROW));
        setL_QUANTITY(Helper.randomIntegerWithLimit(10000));
        setL_EXTENDEDPRICE(Helper.randomIntegerWithLimit(10000));
        setL_DISCOUNT(Helper.randomIntegerWithLimit(80));
        setL_TAX(Helper.randomIntegerWithLimit(100));
        setL_RETURNFLAG(Helper.randomIntegerWithLimit(100));
        setL_LINESTATUS(Helper.randomStringFixedLength(5));
        setL_SHIPDATE(Helper.randomTimestampt());
        setL_COMMITDATE(Helper.randomTimestampt());
        setL_RECEIPTDATE(Helper.randomTimestampt());
        setL_SHIPINSTRUCT(Helper.randomStringFixedLength(20));
        setL_SHIPMODE(Helper.randomStringFixedLength(5));
        setL_COMMENT(Helper.randomStringFixedLength(30));
    }

    public int getL_ORDERKEY() {
        return L_ORDERKEY;
    }

    public void setL_ORDERKEY(int l_ORDERKEY) {
        L_ORDERKEY = l_ORDERKEY;
    }

    public int getL_LINENUMBER() {
        return L_LINENUMBER;
    }

    public void setL_LINENUMBER(int l_LINENUMBER) {
        L_LINENUMBER = l_LINENUMBER;
    }

    public int getL_PARTKEY() {
        return L_PARTKEY;
    }

    public void setL_PARTKEY(int l_PARTKEY) {
        L_PARTKEY = l_PARTKEY;
    }

    public int getL_SUPPKEY() {
        return L_SUPPKEY;
    }

    public void setL_SUPPKEY(int l_SUPPKEY) {
        L_SUPPKEY = l_SUPPKEY;
    }

    public int getL_QUANTITY() {
        return L_QUANTITY;
    }

    public void setL_QUANTITY(int l_QUANTITY) {
        L_QUANTITY = l_QUANTITY;
    }

    public int getL_EXTENDEDPRICE() {
        return L_EXTENDEDPRICE;
    }

    public void setL_EXTENDEDPRICE(int l_EXTENDEDPRICE) {
        L_EXTENDEDPRICE = l_EXTENDEDPRICE;
    }

    public int getL_DISCOUNT() {
        return L_DISCOUNT;
    }

    public void setL_DISCOUNT(int l_DISCOUNT) {
        L_DISCOUNT = l_DISCOUNT;
    }

    public int getL_TAX() {
        return L_TAX;
    }

    public void setL_TAX(int l_TAX) {
        L_TAX = l_TAX;
    }

    public int getL_RETURNFLAG() {
        return L_RETURNFLAG;
    }

    public void setL_RETURNFLAG(int l_RETURNFLAG) {
        L_RETURNFLAG = l_RETURNFLAG;
    }

    public String getL_LINESTATUS() {
        return L_LINESTATUS;
    }

    public void setL_LINESTATUS(String l_LINESTATUS) {
        L_LINESTATUS = l_LINESTATUS;
    }

    public long getL_SHIPDATE() {
        return L_SHIPDATE;
    }

    public void setL_SHIPDATE(long l_SHIPDATE) {
        L_SHIPDATE = l_SHIPDATE;
    }

    public long getL_COMMITDATE() {
        return L_COMMITDATE;
    }

    public void setL_COMMITDATE(long l_COMMITDATE) {
        L_COMMITDATE = l_COMMITDATE;
    }

    public long getL_RECEIPTDATE() {
        return L_RECEIPTDATE;
    }

    public void setL_RECEIPTDATE(long l_RECEIPTDATE) {
        L_RECEIPTDATE = l_RECEIPTDATE;
    }

    public String getL_SHIPINSTRUCT() {
        return L_SHIPINSTRUCT;
    }

    public void setL_SHIPINSTRUCT(String l_SHIPINSTRUCT) {
        L_SHIPINSTRUCT = l_SHIPINSTRUCT;
    }

    public String getL_SHIPMODE() {
        return L_SHIPMODE;
    }

    public void setL_SHIPMODE(String l_SHIPMODE) {
        L_SHIPMODE = l_SHIPMODE;
    }

    public String getL_COMMENT() {
        return L_COMMENT;
    }

    public void setL_COMMENT(String l_COMMENT) {
        L_COMMENT = l_COMMENT;
    }
}
