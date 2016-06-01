package model;

import helper.Helper;

/**
 * Created by nim_13512065 on 5/31/16.
 */
public class Part implements ModelInterface {
    private int P_PARTKEY;
    private String P_NAME;
    private String P_MFGR;
    private String P_BRAND;
    private String P_TYPE;
    private String P_SIZE;
    private String P_CONTAINER;
    private int P_RETAILPRICE;
    private String P_COMMENT;

    public Part() {

    }
    public Part(int id) {
        setP_PARTKEY(id);
        setP_NAME(Helper.randomStringFixedLength(10));
        setP_MFGR(Helper.randomStringFixedLength(10));
        setP_BRAND(Helper.randomStringFixedLength(5));
        setP_TYPE(Helper.randomStringFixedLength(2));
        setP_SIZE(Helper.randomStringFixedLength(2));
        setP_CONTAINER(Helper.randomStringFixedLength(5));
        setP_RETAILPRICE(Helper.randomIntegerWithLimit(5));
        setP_COMMENT(Helper.randomStringFixedLength(100));
    }

    public int getP_PARTKEY() {
        return P_PARTKEY;
    }

    public void setP_PARTKEY(int p_PARTKEY) {
        P_PARTKEY = p_PARTKEY;
    }

    public String getP_NAME() {
        return P_NAME;
    }

    public void setP_NAME(String p_NAME) {
        P_NAME = p_NAME;
    }

    public String getP_MFGR() {
        return P_MFGR;
    }

    public void setP_MFGR(String p_MFGR) {
        P_MFGR = p_MFGR;
    }

    public String getP_BRAND() {
        return P_BRAND;
    }

    public void setP_BRAND(String p_BRAND) {
        P_BRAND = p_BRAND;
    }

    public String getP_TYPE() {
        return P_TYPE;
    }

    public void setP_TYPE(String p_TYPE) {
        P_TYPE = p_TYPE;
    }

    public String getP_SIZE() {
        return P_SIZE;
    }

    public void setP_SIZE(String p_SIZE) {
        P_SIZE = p_SIZE;
    }

    public String getP_CONTAINER() {
        return P_CONTAINER;
    }

    public void setP_CONTAINER(String p_CONTAINER) {
        P_CONTAINER = p_CONTAINER;
    }

    public int getP_RETAILPRICE() {
        return P_RETAILPRICE;
    }

    public void setP_RETAILPRICE(int p_RETAILPRICE) {
        P_RETAILPRICE = p_RETAILPRICE;
    }

    public String getP_COMMENT() {
        return P_COMMENT;
    }

    public void setP_COMMENT(String p_COMMENT) {
        P_COMMENT = p_COMMENT;
    }
}
