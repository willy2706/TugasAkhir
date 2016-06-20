package model;

import helper.Helper;

/**
 * Created by nim_13512065 on 6/2/16.
 */
public class Nation implements ModelInterface {
    private int N_NATIONKEY;
    private String N_NAME;
    private int N_REGIONKEY;
    private String N_COMMENT;

    public Nation () {

    }

    public Nation (int id) {
        setN_NATIONKEY(id);
        setN_NAME(Helper.randomStringFixedLength(10));
        setN_REGIONKEY(Helper.randomIntegerWithRange(1,5));
        setN_COMMENT(Helper.randomStringFixedLength(20));
    }

    public int getN_NATIONKEY() {
        return N_NATIONKEY;
    }

    public void setN_NATIONKEY(int n_NATIONKEY) {
        N_NATIONKEY = n_NATIONKEY;
    }

    public String getN_NAME() {
        return N_NAME;
    }

    public void setN_NAME(String n_NAME) {
        N_NAME = n_NAME;
    }

    public int getN_REGIONKEY() {
        return N_REGIONKEY;
    }

    public void setN_REGIONKEY(int n_REGIONKEY) {
        N_REGIONKEY = n_REGIONKEY;
    }

    public String getN_COMMENT() {
        return N_COMMENT;
    }

    public void setN_COMMENT(String n_COMMENT) {
        N_COMMENT = n_COMMENT;
    }
}
